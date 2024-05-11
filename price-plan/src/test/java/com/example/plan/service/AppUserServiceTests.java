package com.example.plan.service;


import com.example.plan.dto.AppUserDto;
import com.example.plan.model.AppUser;
import com.example.plan.repository.AppUserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class AppUserServiceTests {

    @Mock
    private AppUserRepository appUserRepository;

    @InjectMocks
    private
    AppUserService appUserService;

    @Order(1)
    @Test
    void validateName() {

        Assertions.assertTrue(appUserService.validateName("길동", "홍"));
        Assertions.assertTrue(appUserService.validateName("John", "Park"));

        Assertions.assertFalse(appUserService.validateName("안녕", "s"));
        Assertions.assertFalse(appUserService.validateName("안녕", ""));
        Assertions.assertFalse(appUserService.validateName("", "Hello"));
    }

    @Order(2)
    @Test
    void signUp() {
        // given
        AppUserDto dto = AppUserDto.builder()
            .account("testId02")
            .firstName("gildong")
            .lastName("lee")
            .build();

        AppUser expected = AppUser.builder()
                .id(1L)
                .account(dto.getAccount())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
            .build();

        when(appUserRepository.save(any(AppUser.class)))
                .thenReturn(expected);

        // when
        AppUser actual = appUserService.signUp(dto);

        // then
        verify(appUserRepository, times(1)).save(any(AppUser.class));

        assertThat(expected.getAccount().equals(actual.getAccount()));
        assertThat(expected.getFirstName().equals(actual.getFirstName()));

    }
}
