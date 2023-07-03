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
