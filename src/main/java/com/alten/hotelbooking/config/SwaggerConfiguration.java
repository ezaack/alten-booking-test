package com.alten.hotelbooking.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfiguration extends WebMvcConfigurationSupport {

    @Value("#{${app.swagger.base:null}}")
    private List<String> packages;

    @Autowired
    private SwaggerUiWebMvcConfigurer swaggerUiWebMvcConfigurer;

    public SwaggerConfiguration() {
    }

    @Bean
    public Docket greetingApi() {
        ApiSelectorBuilder docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(metaData())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .paths(PathSelectors.any());
        if ( null == packages || packages.isEmpty() ) {
            docket.apis(RequestHandlerSelectors.basePackage("com.alten.hotelbooking.controller") );
        } else {
            packages.stream().forEach((each -> docket.apis(RequestHandlerSelectors.basePackage(each)) ));
        }
        return docket.build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API - hotel booking")
                .description("Alten test: Booking system")
                .version("0.0.1")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[] {
            new AuthorizationScope("global", "accessEverything")
        };
        return Arrays.asList(
                new SecurityReference("JWT", authorizationScopes)
        );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        swaggerUiWebMvcConfigurer.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        swaggerUiWebMvcConfigurer.addViewControllers(registry);
    }
}

