package com.example.plan.service;


import com.example.plan.dto.CustomerDto;
import com.example.plan.exception.CustomerAlreadyExistException;
import com.example.plan.model.Customer;
import com.example.plan.repository.CustomerRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class CustomerServiceTests {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private
    CustomerService customerService;

    @Order(1)
    @Test
    void validateName() {

        Assertions.assertTrue(customerService.validateName("길동", "홍"));
        Assertions.assertTrue(customerService.validateName("John", "Park"));

        Assertions.assertFalse(customerService.validateName("안녕", "s"));
        Assertions.assertFalse(customerService.validateName("안녕", ""));
        Assertions.assertFalse(customerService.validateName("", "Hello"));
    }

    @Order(2)
    @Test
    void signUp() {
        // given
        CustomerDto dto = CustomerDto.builder()
            .account("testId02")
            .firstName("gildong")
            .lastName("lee")
            .build();

        Customer expected = Customer.builder()
                .idx(1L)
                .account(dto.getAccount())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
            .build();

        when(customerRepository.save(any(Customer.class)))
                .thenReturn(expected);

        // when
        Customer actual = customerService.signUp(dto);

        // then
        verify(customerRepository, times(1)).save(any(Customer.class));

        assertThat(expected.getAccount().equals(actual.getAccount()));
        assertThat(expected.getFirstName().equals(actual.getFirstName()));

    }
}
