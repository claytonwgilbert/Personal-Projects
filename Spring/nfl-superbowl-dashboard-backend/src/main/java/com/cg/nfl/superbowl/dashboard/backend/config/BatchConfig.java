package com.cg.nfl.superbowl.dashboard.backend.config;

import com.cg.nfl.superbowl.dashboard.backend.data.GameData;
import com.cg.nfl.superbowl.dashboard.backend.data.GameDataProcessor;
import com.cg.nfl.superbowl.dashboard.backend.model.Game;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final String[] FIELD_NAMES = new String[]{
        "date",
        "sb",
        "winner",
        "winner_pts",
        "loser",
        "loser_pts",
        "mvp",
        "stadium",
        "city",
        "state"
    };

    public JobBuilderFactory jobBuilderFactory;
    public StepBuilderFactory stepBuilderFactory;

    public BatchConfig(JobBuilderFactory jobBuilderFactory,StepBuilderFactory stepBuilderFactory){
        this.jobBuilderFactory=jobBuilderFactory;
        this.stepBuilderFactory=stepBuilderFactory;
    }

    // - Reader...reads the data that needs converted
    @Bean
    public FlatFileItemReader<GameData> reader() {
        return new FlatFileItemReaderBuilder<GameData>()
                .name("GameDataReader")
                .resource(new ClassPathResource("superbowl-data.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<GameData>() {{
                    setTargetType(GameData.class);
                }})
                .build();
    }

    @Bean
    public GameDataProcessor processor() {
        return new GameDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Game> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Game>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO Game (id, sb_date, sb, winner, winner_pts, loser, loser_pts, mvp, stadium, city, state) VALUES (:id, :sbDate, :sb, :winner, :winnerPts, :loser, :loserPts, :mvp, :stadium, :city, :state)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Game> writer) {
        return stepBuilderFactory.get("step1")
                .<GameData, Game> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }

}