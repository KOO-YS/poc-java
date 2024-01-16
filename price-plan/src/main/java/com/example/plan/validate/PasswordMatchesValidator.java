package com.example.plan.validate;

import com.example.plan.dto.CustomerDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, CustomerDto> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(CustomerDto value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getMatchingPassword());
    }
}
