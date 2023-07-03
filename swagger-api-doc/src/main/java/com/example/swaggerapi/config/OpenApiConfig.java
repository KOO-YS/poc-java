package com.example.swaggerapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
            .version("v1.0")
            .title("API Document")
            .description("Sample Document with Open API");

        // TODO : header에 jwt 토큰 포함할 것 -> ref : https://tg360.tistory.com/entry/Springdoc-openapi%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-Spring-Boot-%EA%B8%B0%EB%B0%98-API%EC%9D%98-%EB%AC%B8%EC%84%9C-%EC%9E%90%EB%8F%99%ED%99%94
        return new OpenAPI()
            .info(info);
    }

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
            .group("All")
            .pathsToMatch("/v1/api/**")
            .packagesToScan("com.example.swaggerapi")
            .build();
    }

    @Bean
    public GroupedOpenApi FoodApi() {
        return GroupedOpenApi.builder()
            .group("Food")
            .pathsToMatch("/v1/api/food/**")
            .packagesToScan("com.example.swaggerapi.food")
            .build();
    }

    @Bean
    public GroupedOpenApi OrderApi() {
        return GroupedOpenApi.builder()
            .group("order")
            .pathsToMatch("/v1/api/order/**")
            .packagesToScan("com.example.swaggerapi.order")
            .build();
    }

}
