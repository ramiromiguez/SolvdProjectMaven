package com.solvd.gym.exceptionContainer;

public class ReceiveSalaryException extends Exception {
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Sorry, the pay will be delayed because we do not have the money at the moment";
	}
}
