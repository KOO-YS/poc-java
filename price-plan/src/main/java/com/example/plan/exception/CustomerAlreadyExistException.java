package com.example.plan.exception;

public class CustomerAlreadyExistException extends RuntimeException {
    public CustomerAlreadyExistException(String s) {
        super(s);
    }
}
