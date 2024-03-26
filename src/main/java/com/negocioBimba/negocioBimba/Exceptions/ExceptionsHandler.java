/*package com.negocioBimba.negocioBimba.Exceptions;


import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {


    @ExceptionHandler({DataAccessException.class,
    Exception.class})
    public ResponseEntity<ErrorMessage> exceptionHandler(Exception e) {
        return new ResponseEntity<>(ErrorMessage.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}*/
