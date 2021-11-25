package com.solvd.gym.data;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.exceptionContainer.ReceiveSalaryException;

public class InstructorYoga extends Instructor {
	private Set<ClientYoga> clients = new HashSet<>();
	private final static Logger LOG = Logger.getLogger(InstructorYoga.class.getName());

	public InstructorYoga(int id, String name, int salary, Set<ClientYoga> clients) {
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

	//return the quantity of clients that the instructor has
	public String quantityOfClients() {
		if(clients.isEmpty() == true) {
			return name +"doesnt have any clients yet";
		}
		else {
		return "Yoga instructor " +name +" has " +clients.size();
		}
	}
	
	
	//print the list of clients of the instructor
	public void printClients() {
		System.out.println("Yoga instructor " +name +" list of clients");
		for(ClientYoga clients: clients) {
			LOG.log(Level.INFO, clients.getName());
		}
	}
}
