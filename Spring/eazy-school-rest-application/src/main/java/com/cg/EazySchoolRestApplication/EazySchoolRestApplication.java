package com.cg.EazySchoolRestApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.cg.EazySchoolRestApplication.proxy")
public class EazySchoolRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazySchoolRestApplication.class, args);
	}

}
