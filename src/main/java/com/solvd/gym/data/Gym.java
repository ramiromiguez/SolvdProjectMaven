package com.solvd.gym.data;

import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.solvd.gym.interfaces.BiggerListProcessor;

public final class Gym {
    private final static Logger LOG = Logger.getLogger(Gym.class.getName());
    private static int totalMoneyEarned;
    private static int totalMoneySpent;
    private static CollectionsAdministrator collectionAdmin;

    public Gym(CollectionsAdministrator collectionAdmin) {
	totalMoneyEarned = 0;
	totalMoneySpent = 0;
	Gym.collectionAdmin = collectionAdmin;
    }

    // GYM FUNCTIONS
    public static int getTotalMoneyEarned() {
	return totalMoneyEarned;
    }

    public static void updateTOtalMoneyEarned(int moneyEarned) {
	totalMoneyEarned += moneyEarned;
    }

    public int getTotalMoneySpent() {
	return totalMoneySpent;
    }

    public List<Instructor> returnInstructorWithSalaryBiggerThan499() {
	Queue<Instructor> instructors = collectionAdmin.getInstructorList();
	return instructors.stream().filter(instructor -> instructor.getSalary() >= 500).collect(Collectors.toList());
    }

    public List<Instructor> sortInstructorsByTheirSalary() {
	Queue<Instructor> instructors = collectionAdmin.getInstructorList();
	return instructors.stream().sorted(Comparator.comparing(instructor -> instructor.getSalary()))
		.collect(Collectors.toList());
    }

    public void getClientsSortedByTheirName() {
	List<Client> var = collectionAdmin.getClientList().stream()
		.sorted(Comparator.comparing(client -> client.getName())).collect(Collectors.toList());
	var.forEach(client -> LOG.log(Level.INFO, client.getName()));
    }

    public static void updateTotalMoneySpent(int moneySpent) {
	totalMoneyEarned -= moneySpent;
	totalMoneySpent += moneySpent;
    }

    private void nameChecker(Client client, Function<Client, Boolean> isOnTheGym) {
	boolean isOn = isOnTheGym.apply(client);
	LOG.log(Level.INFO, "Client " + client.getName() + " name is equal " + isOn);
    }

    public void existClientWithName(String string) {
	for (Client c : collectionAdmin.getClientList()) {
	    nameChecker(c, client -> client.getName().equals(string));
	}
    }

    public void modifyInstructor(Instructor instructor, Consumer<Instructor> modify) {
	modify.accept(instructor);
    }

    public void biggerList(boolean itIs, BiggerListProcessor processor) {
	boolean isBigger = processor.biggerListProcessor(itIs);
	LOG.log(Level.INFO, "the first collection is bigger than the second " + isBigger);
    }
}
