package com.solvd.gym.exceptionContainer;

public class NullNameException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "The name cant be empty";
	}
}
