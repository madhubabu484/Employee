package com.Employee.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Employee.CustomExceptions.EmailAlredyexistexception;
import com.Employee.CustomExceptions.EmployeNotFoundWithId;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(EmailAlredyexistexception.class)
    public ResponseEntity<String> handleEmailAlredyexistexception(EmailAlredyexistexception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT); // 409
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Something went wrong Email is Alredy Existed with SomeOne: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500
    }
	
	
	public ResponseEntity<String> handleEmployeNotFoundwithId(EmployeNotFoundWithId ex)
	{
        return new ResponseEntity<>(" Employe Not found with the Id : " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500

	}
	public ResponseEntity<String> handleDeleteNotFoundWithId(EmployeNotFoundWithId ex)
	{
        return new ResponseEntity<>(" Delete Not Found Employe Not found with the Id : " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500

	}

    
}


