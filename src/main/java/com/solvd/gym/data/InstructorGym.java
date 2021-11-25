package com.solvd.gym.data;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.exceptionContainer.ReceiveSalaryException;

public class InstructorGym extends Instructor {
	
	public InstructorGym(int id, String name, int salary) {
		super(id, name, salary);
	}
	
	@Override
	public final void receiveSalary() throws ReceiveSalaryException{
		salaryEarned =+ getSalary();
			if(Gym.getTotalMoneyEarned() < salary) {
				Gym.updateTotalMoneySpent(getSalary());
			}
			else{
				throw new ReceiveSalaryException();
			}
		}
}
