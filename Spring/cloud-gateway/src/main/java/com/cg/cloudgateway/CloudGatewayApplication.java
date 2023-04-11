package com.cg.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CloudGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}

	//Setting up rerouting in our application, with the help of gateway server, we can define custom routes and still specify
	//to gateway server where to direct that custom url
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/cg/accounts/**")
						.filters(f -> f.rewritePath("/cg/accounts/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time",new Date().toString()))
						.uri("lb://ACCOUNTS")).
				route(p -> p
						.path("/cg/loans/**")
						.filters(f -> f.rewritePath("/cg/loans/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time",new Date().toString()))
						.uri("lb://LOANS")).
				route(p -> p
						.path("/cg/cards/**")
						.filters(f -> f.rewritePath("/cg/cards/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time",new Date().toString()))
						.uri("lb://CARDS")).build();
	}
}
