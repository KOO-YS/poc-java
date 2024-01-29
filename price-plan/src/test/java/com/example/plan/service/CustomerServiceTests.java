package com.example.plan.service;


import com.example.plan.dto.CustomerDto;
import com.example.plan.model.Customer;
import com.example.plan.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTests {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private
    CustomerService customerService;

    @Test
    void validateName() {

        Assertions.assertTrue(customerService.validateName("길동", "홍"));
        Assertions.assertTrue(customerService.validateName("John", "Park"));

        Assertions.assertFalse(customerService.validateName("안녕", "s"));
        Assertions.assertFalse(customerService.validateName("안녕", ""));
        Assertions.assertFalse(customerService.validateName("", "Hello"));
    }

    @Test
    public void signUp() {
        // given
        CustomerDto dto = CustomerDto.builder()
            .account("testId02")
            .firstName("gildong")
            .lastName("lee")
            .build();

        Customer result = Customer.builder()
                .account(dto.getAccount())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
            .validCode("xxxxxx")
            .build();

        doReturn(result)
            .when(customerRepository.save(result));

        // when
        Customer customer = customerService.signUp(dto);

        // then
        System.out.println(customer.getIdx()+ customer.getFirstName());
    }
}
