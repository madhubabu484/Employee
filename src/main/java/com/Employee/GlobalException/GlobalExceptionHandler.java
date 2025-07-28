package com.Employee.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Employee.CustomExceptions.EmailAlredyexistexception;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(EmailAlredyexistexception.class)
    public ResponseEntity<String> handleEmailAlreadyExists(EmailAlredyexistexception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT); // 409
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Something went wrong Email is Alredy Existed with SomeOne: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500
    }

    
}


