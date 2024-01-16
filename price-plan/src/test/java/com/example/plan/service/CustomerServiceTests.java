package com.example.plan.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceTests {

    @Autowired
    CustomerService customerService;

    @Test
    void validateName() {

        Assertions.assertTrue(customerService.validateName("길동", "홍"));
        Assertions.assertTrue(customerService.validateName("John", "Park"));

        Assertions.assertFalse(customerService.validateName("안녕", "s"));
        Assertions.assertFalse(customerService.validateName("안녕", ""));
        Assertions.assertFalse(customerService.validateName("", "Hello"));
    }
}
