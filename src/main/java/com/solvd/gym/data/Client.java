package com.solvd.gym.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.exceptionContainer.NameContainNumberException;
import com.solvd.gym.exceptionContainer.NullNameException;
import com.solvd.gym.interfaces.IClientInfo;

public abstract class Client implements IClientInfo {
	private int id;
	private String name;
	private int feesPaid;
	protected static List<Client> clientsList = new ArrayList<>();
	private final static Logger LOG = Logger.getLogger(Client.class.getName());
	
	public Client(int id, String name) throws NullNameException, NameContainNumberException{
		feesPaid = 0;
		this.id = id;
		
		boolean found = false;
		StringBuilder sb = new StringBuilder();
	    for(char c : name.toCharArray()){
		        if(Character.isDigit(c)){
		            sb.append(c);
		            found = true;
		        } else if(found){
		            break;                
		        }
		    }
		
		if(name == null || name.trim().isEmpty()) {
            throw new NullNameException();
		}
		if(found == true){
			throw new NameContainNumberException(); 
		}
		else {
			this.name = name;
		}
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(int feesPaid) {
		this.feesPaid = feesPaid;
	}

	public void payFees(int fees) {
		feesPaid += fees;
		Gym.updateTOtalMoneyEarned(feesPaid);
	}
	
	public static List<Client> getCollection() {
		return clientsList;
	}
	
	protected static final void addToTheCollectionClient(Client client) {
		if(isInTheCollectionClient(client)) {
			return;
		}
		else {
			clientsList.add(client);
			Gym.addClientToTheTotalCollection(client);
		}
		
	}

	protected static final void eliminateFromTheCollectionClient(Client client) {
		if(isInTheCollectionClient(client)) {
			clientsList.remove(client);
		}
		else {
			return;
		}
	}
	
	public static boolean isInTheCollectionClient(Client client) {
		boolean isIn = false;
		if(clientsList.contains(client)) {
			isIn = true;
		}
		return isIn;
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
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", feesPaid=" + feesPaid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(feesPaid, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return feesPaid == other.feesPaid && id == other.id && Objects.equals(name, other.name);
	}

}
