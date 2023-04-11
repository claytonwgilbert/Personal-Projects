package com.cg.accountsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RefreshScope //Allows the ability to refresh config properties without restarting the services
@EnableJpaRepositories("com.cg.accountsmicroservice.repositories")
@EntityScan("com.cg.accountsmicroservice.model")
@EnableFeignClients //Eureka server
public class AccountsMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountsMicroserviceApplication.class, args);
	}
}
