package com.niit.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator getRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p
                        .path("/admin/**","/admin/menu/**","/addToFavourite/**","/addToCart/**","/orderHistory/**")
                        .uri("http://localhost:8085"))
                .route(p->p
                        .path("/user/**")
                        .uri("http://localhost:8082"))
                .route(p->p
                        .path("/userprofile/**")
                        .uri("http://localhost:8083"))
                .route(p->p
                        .path("/**")
                        .uri("http://localhost:9090"))
                .build();

    }
}
