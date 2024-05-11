package com.example.plan.validate;

import com.example.plan.dto.AppUserDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, AppUserDto> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(AppUserDto value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getMatchingPassword());
    }
}
