package com.cg.cardsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RefreshScope //Allows the ability to refresh config properties without restarting the services
@EnableJpaRepositories("com.cg.cardsmicroservice.repository")
@EntityScan("com.cg.cardsmicroservice.model")
public class CardsMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CardsMicroserviceApplication.class, args);
	}
}
