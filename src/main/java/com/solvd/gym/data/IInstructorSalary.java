package com.solvd.gym.data;

import com.solvd.gym.exceptionContainer.ReceiveSalaryException;

public interface IInstructorSalary {
	void receiveSalary() throws ReceiveSalaryException;
}
