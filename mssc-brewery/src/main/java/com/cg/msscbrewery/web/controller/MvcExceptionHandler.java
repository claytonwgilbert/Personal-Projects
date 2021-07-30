package com.cg.msscbrewery.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

//Top level exception handler for application
@ControllerAdvice
public class MvcExceptionHandler {

    //Method handles JSR bean validation errors if they were to happen as to provide end users with helpful error
    //messaging. Only applying to v2 since its our latest version of our api as v1 becomes deprecated.
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandling(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(violation -> {
            errors.add(violation.getPropertyPath() + ":" + violation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    //If Spring runs into any problems binding data from client to the our object models on the backend, this will send
    //back a detailed list of reasons as to what went wrong.
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> bindingErrorHandling(BindException ex){
        return new ResponseEntity(ex.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}
