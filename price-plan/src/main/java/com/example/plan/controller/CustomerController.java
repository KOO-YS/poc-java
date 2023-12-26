package com.example.plan.controller;


import com.example.plan.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/name")
    public ResponseEntity<Boolean> validateCustomerName(@RequestParam String firstName, String lastName) {
        boolean validName = customerService.validateName(firstName, lastName);
        return ResponseEntity.ok(validName);
    }



}
