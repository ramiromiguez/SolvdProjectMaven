package com.solvd.gym.exceptionContainer;

public class QuantityUnavailableException extends Exception {
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "The weight is not available, sorry";
	}
}
