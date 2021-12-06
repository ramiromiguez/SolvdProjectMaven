package com.solvd.gym.data;

import com.solvd.gym.exception_container.ReceiveSalaryException;

public class InstructorYoga extends Instructor {

    public InstructorYoga(int id, String name, int salary) {
	super(id, name, salary);
    }

    // need to complete
    @Override
    public final void receiveSalary() throws ReceiveSalaryException {
    }
}
