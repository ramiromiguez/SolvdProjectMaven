package com.solvd.gym.data;

import java.util.ArrayList;
import java.util.List;

import com.solvd.gym.exceptionContainer.ReceiveSalaryException;

public class InstructorYoga extends Instructor {
	List<ClientYoga> clients = new ArrayList<>();

	public InstructorYoga(int id, String name, int salary, List<ClientYoga> clients) {
		super(id, name, salary);
		this.clients = clients;
	}

	@Override
	public final void receiveSalary() throws ReceiveSalaryException {
		int length = clients.size();
		int total = length * getSalary();

		if (Gym.getTotalMoneyEarned() >= total) {
			salaryEarned = +total;
			Gym.updateTotalMoneySpent(total);
		} else {
			throw new ReceiveSalaryException();
		}

	}

}
