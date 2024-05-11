package com.example.plan.dto;
import com.example.plan.validate.PasswordMatches;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
@JsonNaming(value =  PropertyNamingStrategies.SnakeCaseStrategy.class)
@PasswordMatches
public class AppUserDto {

    @NotNull
    @NotEmpty
    private String account;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;



}
