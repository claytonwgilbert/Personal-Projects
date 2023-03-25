package com.cg.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cg.eazyschool.repository")
@EntityScan("com.cg.eazyschool.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl") //Handle auditing persistence to the db regarding our BaseEntity class
public class EazySchoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(EazySchoolApplication.class, args);
	}
}
