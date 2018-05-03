package com.example.springAppDemo.instrumentering;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Created by bla on 24/04/2018.
 */
    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    //.apis(RequestHandlerSelectors.any())
                    .apis(RequestHandlerSelectors.basePackage("com.example.springAppDemo"))
                    .paths(PathSelectors.any())
                    //.paths(PathSelectors.ant("/foos/*"))
                    .build()
                    .apiInfo(minapiInfo());
        }

    private ApiInfo minapiInfo() {
        return new ApiInfo(
                "My REST API",
                "Some custom description of API.",
                "Den aller første versjon av API",
                "Terms of service",
                new Contact("John Doe", "www.example.com", "myeaddress@company.com"),
                "License of API", "API license URL", Collections.emptyList());
    }    }

