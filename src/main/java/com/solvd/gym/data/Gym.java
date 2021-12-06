package com.solvd.gym.data;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void updateTotalMoneySpent(int moneySpent) {
	totalMoneyEarned -= moneySpent;
	totalMoneySpent += moneySpent;
    }

    // CLIENT FUNCTIONS
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
}
