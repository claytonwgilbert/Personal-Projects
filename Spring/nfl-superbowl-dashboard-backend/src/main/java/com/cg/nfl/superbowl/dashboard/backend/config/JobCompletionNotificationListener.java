package com.cg.nfl.superbowl.dashboard.backend.config;

import com.cg.nfl.superbowl.dashboard.backend.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final EntityManager em;

    @Autowired
    public JobCompletionNotificationListener(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("=========JOB FINISHED========");

            Map<String, Team> teamData = new HashMap<>();

            em.createQuery("select g.winner, count(*) from Game g group by g.winner", Object[].class)
                    .getResultList()
                    .stream()
                    .map(e -> new Team((String)e[0], (Long)e[1]))
                    .forEach(team -> teamData.put(((Team) team).getTeamName(), team));

            em.createQuery("select g.loser, count(*) from Game g group by g.loser", Object[].class)
                    .getResultList()
                    .stream()
                    .forEach(e -> {
                        if(!teamData.containsKey(e[0])){
                            Team team = new Team((String)e[0], (Long)e[1]);
                            teamData.put(((Team) team).getTeamName(), team);
                        }
                    });

            em.createQuery("select g.loser, count(*) from Game g group by g.loser", Object[].class)
                    .getResultList()
                    .stream()
                    .forEach(e -> {
                        Team team = teamData.get((String) e[0]);
                        team.setTotalAppearances(team.getTotalAppearances() + (Long) e[1]);
                    });

            em.createQuery("select g.winner, count(*) from Game g group by g.winner", Object[].class)
                    .getResultList()
                    .stream()
                    .forEach(e -> {
                        Team team = teamData.get((String) e[0]);
                        team.setTotalWins((Long) e[1]);
                    });

            teamData.values().forEach(team -> em.persist(team));

            teamData.values().forEach(team -> System.out.println(team));






        }
    }
}
