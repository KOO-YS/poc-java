package com.example.plan.controller;


import com.example.plan.dto.CustomerDto;
import com.example.plan.exception.CustomerAlreadyExistException;
import com.example.plan.model.AppUser;
import com.example.plan.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(path = "/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/name")
    public ResponseEntity<String> validateCustomerName(@RequestParam String firstName,
                                                        @RequestParam String lastName) {
        // FIXME : try with custom validation
        // ref : https://stackoverflow.com/questions/2781771/how-can-i-validate-two-or-more-fields-in-combination
        boolean validName = customerService.validateName(firstName, lastName);
        if (validName)
            return ResponseEntity.ok("사용 가능한 이름입니다.");
        else
            return ResponseEntity.badRequest().body("이름은 한/영 중 하나의 언어로 통일해야 합니다.");
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody @Valid CustomerDto customerDto) {
        try {
            AppUser newAppUser = customerService.signUp(customerDto);
            return ResponseEntity.ok(newAppUser);

        } catch (CustomerAlreadyExistException e) {
            return ResponseEntity.internalServerError().build();
        }

    }

}
