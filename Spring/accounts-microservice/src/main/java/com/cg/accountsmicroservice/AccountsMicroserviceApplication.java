package com.cg.accountsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cg.accountsmicroservice.repositories")
@EntityScan("com.cg.accountsmicroservice.model")
public class AccountsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsMicroserviceApplication.class, args);
	}

}
