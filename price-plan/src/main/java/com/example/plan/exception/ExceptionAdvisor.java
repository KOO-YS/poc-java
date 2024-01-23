package com.example.plan.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice
@RestController
public class ExceptionAdvisor {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        // FIXME : not work with custom valid annotation
        // ref : https://stackoverflow.com/questions/74067502/controlleradvice-not-work-correctly-in-constraintvalidator
        String field = bindingResult.getFieldErrors().get(0).getField();
        String validMsg = bindingResult.getFieldErrors().get(0).getDefaultMessage();

        log.error("{} Error occurred >> field '{}' : {}", e.getClass().getName(), field, validMsg);
        String errMessage = "필드 [" + field + "] -> " + validMsg;
        return ResponseEntity.badRequest().body(errMessage);
    }

}
