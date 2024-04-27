package com.example.plan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PricePlanApplication {

    private static final Logger LOG = LoggerFactory.getLogger(PricePlanApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PricePlanApplication.class, args);
    }


}
