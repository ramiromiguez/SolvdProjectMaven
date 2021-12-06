package com.solvd.gym.exception_container;

public class NullNameException extends Exception {
    private static final long serialVersionUID = 1L;

    public String getMessage() {
	return "The name cant be empty";
    }
}
