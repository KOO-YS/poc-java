package com.example.plan.service;

import com.example.plan.dto.CustomerDto;
import com.example.plan.exception.CustomerAlreadyExistException;
import com.example.plan.model.Customer;
import com.example.plan.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.file.Matcher;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private static final Pattern VALID_KOR = Pattern.compile("^[ㄱ-ㅎ|가-힣]+$");
    private static final Pattern VALID_ENG = Pattern.compile("^[a-z|A-Z]+$");

    public boolean validateName(String firstName, String lastName) {
        return ((VALID_KOR.matcher(firstName).matches() && VALID_KOR.matcher(lastName).matches())
            || (VALID_ENG.matcher(firstName).matches() && VALID_ENG.matcher(lastName).matches()));
    }

    public Customer signUp(CustomerDto customerDto) {
        if (existAccount(customerDto.getAccount()))
            throw new CustomerAlreadyExistException("이미 존재하는 계정입니다 : "+customerDto.getAccount());

        Customer customer = Customer.builder()
                .account(customerDto.getAccount())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .validCode("xxxxxx")    // TODO : 사용자 고유 인증번호
                .build();

        return customerRepository.save(customer);
    }

    private boolean existAccount(String account) {
        return customerRepository.findByAccount(account).isPresent();
    }
}
