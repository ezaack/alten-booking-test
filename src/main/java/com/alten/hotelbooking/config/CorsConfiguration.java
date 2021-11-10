package com.alten.hotelbooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@Order(0)
public class CorsConfiguration {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfigurationSource source = request -> {
            org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration().applyPermitDefaultValues();
            config.setAllowCredentials(false);
            config.addAllowedMethod(HttpMethod.GET);
            config.addAllowedMethod(HttpMethod.OPTIONS);
            config.addAllowedMethod(HttpMethod.POST);
            config.addAllowedMethod(HttpMethod.PUT);
            config.addAllowedMethod(HttpMethod.DELETE);
            config.addAllowedOrigin("*");
            return config;
        };

        return new CorsFilter(source);
    }

}
