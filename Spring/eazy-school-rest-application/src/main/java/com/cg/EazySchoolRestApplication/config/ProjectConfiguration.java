package com.cg.EazySchoolRestApplication.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfiguration {
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin@eazyschool.com", "admin");
    }

    //For rest template
    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder =
                new RestTemplateBuilder();
        return restTemplateBuilder.basicAuthentication
                ("admin@eazyschool.com", "admin").build();
    }

    //For web client
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .filter(ExchangeFilterFunctions.
                        basicAuthentication("admin@eazyschool.com", "admin"))
                .build();
    }
}
