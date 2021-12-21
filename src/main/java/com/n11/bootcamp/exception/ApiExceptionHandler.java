package com.n11.bootcamp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleRequestException (ApiRequestException apiRequestException){

        String responseMessage = apiRequestException.getMessage();

        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }
}
