package com.myinvest.simplerest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

    @Configuration
    // @EnableSwagger2 (Since version swagger 3, not needed (also removed dependencies)
    //    // http://springfox.github.io/springfox/docs/current/#regular-spring-mvc  (migration)
    public class SwaggerConfig {

        @Bean
        public Docket api() {

            return new Docket(DocumentationType.SWAGGER_2).select().
                    apis(RequestHandlerSelectors.basePackage("com.myinvest.simplerest"))
                    .paths(PathSelectors.any())
                    .build();
        }
    }
