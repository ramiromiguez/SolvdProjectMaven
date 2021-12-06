package com.solvd.gym.data;

import com.solvd.gym.exception_container.ReceiveSalaryException;

public class InstructorMartialArt extends Instructor{
	MartialArtType martialArtType;
	public InstructorMartialArt(int id, String name, int salary, MartialArtType martialArtType) {
		super(id, name, salary);
	}

	@Override
	public void receiveSalary() throws ReceiveSalaryException {
		// TODO Auto-generated method stub
		
	}

}
