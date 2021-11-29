package com.solvd.gym.interfaces;

import com.solvd.gym.exceptionContainer.ReceiveSalaryException;

public interface IInstructorSalary {
	void receiveSalary() throws ReceiveSalaryException;
}
