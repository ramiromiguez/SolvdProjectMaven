package com.solvd.gym.data;

import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.genericlinkedlist.GenericLinkedList;

public final class Gym {
	
	private static List<Client> clientsList;
	private static Queue<Instructor> instructorsQueue;
	private static GenericLinkedList<Object> clientsAndInstructors = new GenericLinkedList<>();
	private final static Logger LOG = Logger.getLogger(Gym.class.getName());
	
	private static int totalMoneyEarned;
	private static int totalMoneySpent;
	
	public Gym(Queue<Instructor> instructorsQueue, List<Client> clientsList) {
		Gym.clientsList = clientsList;
		Gym.instructorsQueue = instructorsQueue;
		totalMoneyEarned = 0;
		totalMoneySpent = 0;
	}
	
	public final Queue<Instructor> getInstructors(){
		return instructorsQueue;
	}
	
	public final List<Client> getClients(){
		return clientsList;
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
	
	protected static final void addInstructorToTheTotalCollection(Instructor instructor) {
		clientsAndInstructors.insert(instructor);
	}
	
	protected static final void addClientToTheTotalCollection(Client client) {
		clientsAndInstructors.insert(client);
	}

// need to finish
//	protected static final void eliminateInstructorFromTheTotalCollection(Instructor instructor) {
//		if(isInTheCollectionInstructor(instructor)) {
//			clientsAndInstructors.deleteAt(totalMoneyEarned);
//		}
//		else {
//			return;
//		}
//	}
//	
//	protected static final void eliminateClientFromTheTotalCollection(Instructor instructor) {
//		if(isInTheCollectionInstructor(instructor)) {
//			clientsAndInstructors.deleteAt(instructor);
//		}
//		else {
//			return;
//		}
//	}
//	

	public static void printTheTotalCollection() {
		clientsAndInstructors.show();
	}
	
	public static void printTheCollectionInstrcutor() {
		if(instructorsQueue.size() >= 1) {
			for(Instructor instructor: instructorsQueue) {
				LOG.log(Level.INFO, instructor.toString());
			}
		}
		else {
			LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
		}
	}
	public static void printTheCollectionClient() {
		if(clientsList.size() >= 1) {
			for(Client client: clientsList) {
				LOG.log(Level.INFO, client.toString());
			}
		}
		else {
			LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
		}
	}
	
}
