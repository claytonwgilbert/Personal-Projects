package com.cg.loansmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RefreshScope //Allows the ability to refresh config properties without restarting the services
@EnableJpaRepositories("com.cg.loansmicroservice.repository")
@EntityScan("com.cg.loansmicroservice.model")
public class LoansMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoansMicroserviceApplication.class, args);
	}
}
