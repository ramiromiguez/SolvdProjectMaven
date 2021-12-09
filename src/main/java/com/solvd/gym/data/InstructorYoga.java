package com.solvd.gym.data;

import com.solvd.gym.exception_container.ReceiveSalaryException;

public class InstructorYoga extends Instructor {
    DaysOfTheWeek workDay;

    public InstructorYoga(int id, String name, int salary, DaysOfTheWeek workDay) {
	super(id, name, salary);
	this.workDay = workDay;
    }

    @Override
    public final void receiveSalary() throws ReceiveSalaryException {
	salaryEarned = +getSalary();
	if (Gym.getTotalMoneyEarned() < salary) {
	    Gym.updateTotalMoneySpent(getSalary());
	} else {
	    throw new ReceiveSalaryException();
	}
    }
}
