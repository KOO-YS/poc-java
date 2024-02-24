package com.example.plan;

import com.example.plan.config.KeycloakServerProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({KeycloakServerProperties.class})
public class PricePlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricePlanApplication.class, args);
    }

}
