package com.solvd.gym.exception_container;

public class NameContainNumberException extends Exception {
    private static final long serialVersionUID = 1L;

    public String getMessage() {
	return "Your name cant contain numbers";
    }
}
