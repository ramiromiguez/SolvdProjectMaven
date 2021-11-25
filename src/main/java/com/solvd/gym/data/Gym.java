package com.solvd.gym.data;

import java.util.Set;

public final class Gym {
	
	private final Set<Client> clients;
	private final Set<Instructor> instructors;
	private static int totalMoneyEarned;
	private static int totalMoneySpent;
	
	public Gym(Set<Instructor> instructors, Set<Client> clients) {
		this.clients = clients;
		this.instructors = instructors;
		totalMoneyEarned = 0;
		totalMoneySpent = 0;
	}
	
	public final Set<Instructor> getInstructors(){
		return instructors;
	}
	
	public final void addInstructor(Instructor instructor) {
		instructors.add(instructor);
	}
	
	public final Set<Client> getClients(){
		return clients;
	}
	
	public final void addClients(Client client) {
		clients.add(client);
	}
	
	public final static int getTotalMoneyEarned() {
		return totalMoneyEarned;
	}
	
	public static void updateTOtalMoneyEarned(int moneyEarned) {
		totalMoneyEarned += moneyEarned;
	}
	
	public int getTotalMoneySpent() {
		return totalMoneySpent;
	}
	
	public static void updateTotalMoneySpent(int moneySpent) {
		totalMoneyEarned -= moneySpent;
		totalMoneySpent += moneySpent;
	}
}
