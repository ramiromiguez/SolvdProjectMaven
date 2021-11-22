package com.solvd.gym.data;

import java.util.List;

public final class Gym {
	
	private final List<Client> clients;
	private final List<Instructor> instructors;
	private static int totalMoneyEarned;
	private static int totalMoneySpent;
	
	public Gym(List<Instructor> instructors, List<Client> clients) {
		this.clients = clients;
		this.instructors = instructors;
		totalMoneyEarned = 0;
		totalMoneySpent = 0;
	}
	
	public final List<Instructor> getInstructors(){
		return instructors;
	}
	
	public final void addInstructor(Instructor instructor) {
		instructors.add(instructor);
	}
	
	public final List<Client> getClients(){
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
