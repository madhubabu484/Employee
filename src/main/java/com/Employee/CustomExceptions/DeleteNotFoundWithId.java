package com.Employee.CustomExceptions;

public class DeleteNotFoundWithId extends RuntimeException {
	
	public DeleteNotFoundWithId(String message)
	{
		super(message);
	}

}
