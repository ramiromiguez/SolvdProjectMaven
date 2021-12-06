package com.solvd.gym.exception_container;

public class QuantityLeaveUnavailableException extends Exception {
    private static final long serialVersionUID = 1L;

    public String getMessage() {
	return "You want to leave more weight than you actually have";
    }
}
