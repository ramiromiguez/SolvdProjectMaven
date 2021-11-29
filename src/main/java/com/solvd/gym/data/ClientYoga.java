package com.solvd.gym.data;

import com.solvd.gym.exceptionContainer.NullNameException;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.exceptionContainer.NameContainNumberException;

public class ClientYoga extends Client {
	private static Set<ClientYoga> clientsYogaSet = new HashSet<>();
	private final static Logger LOG = Logger.getLogger(ClientGym.class.getName());

	public ClientYoga(int id, String name) throws NullNameException, NameContainNumberException {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	
	public final static void eliminateClientYoga(ClientYoga client) {
		eliminateFromTheCollectionClientYoga(client);
		client = null;
	}

	public static void addToTheCollectionClientYoga(ClientYoga client) {
		if(clientsYogaSet.contains(client)) {
			LOG.log(Level.WARNING, client.getName() +" is already on the Set");
		}
		else {
			clientsYogaSet.add(client);
			addToTheCollectionClient(client);
		}
		
	}

	private static final void eliminateFromTheCollectionClientYoga(ClientYoga client) {
		if(clientsYogaSet.contains(client)) {
			clientsYogaSet.remove(client);
			eliminateFromTheCollectionClient(client);
		}
		else {
			return;
		}
	}
	
	public static boolean isInTheCollectionClientYoga(ClientYoga client) {
		boolean isIn = false;
		if(clientsYogaSet.contains(client)) {
			isIn = true;
		}
		return isIn;
	}

	public static void printTheCollectionClientYoga() {
		if(clientsYogaSet.size() >= 1) {
			for(ClientYoga client: clientsYogaSet) {
				LOG.log(Level.INFO, client.toString());
			}
		}
		else {
			LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
		}
	}
}
