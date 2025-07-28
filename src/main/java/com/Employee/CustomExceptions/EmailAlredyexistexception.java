package com.Employee.CustomExceptions;

public class EmailAlredyexistexception extends RuntimeException {
	public EmailAlredyexistexception(String message) {
        super(message);  
}

}