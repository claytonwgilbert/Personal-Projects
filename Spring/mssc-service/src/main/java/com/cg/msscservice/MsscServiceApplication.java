package com.cg.msscservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;

@SpringBootApplication
public class MsscServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsscServiceApplication.class, args);
	}

}
