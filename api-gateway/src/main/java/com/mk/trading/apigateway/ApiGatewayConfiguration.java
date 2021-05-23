package com.mk.trading.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		logger.info("{}={}", "MESSAGE", "Routing the request");

		return builder.routes()
				.route(p -> p.path("/trading-service/**").uri("lb://trading-service/**"))
				.route(p -> p.path("/tax-service/**").uri("lb://tax-service/**"))
//				.route(p -> p.path("/tradin-service-new/**")
//						.filters(f -> f.rewritePath("/trading-service-new/(?<segment>.*)", "/trading-service/${segment}"))
//						.uri("lb://trading-service/${segment}"))
				.build();
	}

}
