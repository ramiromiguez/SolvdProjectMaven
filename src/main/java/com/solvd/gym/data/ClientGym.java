package com.solvd.gym.data;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.exceptionContainer.NameContainNumberException;
import com.solvd.gym.exceptionContainer.NullNameException;
import com.solvd.gym.exceptionContainer.QuantityLeaveUnavailableException;
import com.solvd.gym.exceptionContainer.QuantityUnavailableException;

public class ClientGym extends Client{
	private static Set<ClientGym> clientsGymSet = new HashSet<>();
	private final static Logger LOG = Logger.getLogger(ClientGym.class.getName());
	
	public ClientGym(int id, String name) throws NullNameException, NameContainNumberException {
		super(id, name);
	}
	
	public final void pick5kg(int weight) throws QuantityUnavailableException{
		WeightStorage.pick10kg(weight);
	}
	
	public final void pick10kg(int weight) throws QuantityUnavailableException{
		WeightStorage.pick10kg(weight);
	}

	public final void pick15kg(int weight) throws QuantityUnavailableException{
		WeightStorage.pick15kg(weight);
	}
	
	public final void pick20kg(int weight) throws QuantityUnavailableException{
		WeightStorage.pick20kg(weight);
	}
	
	public final void leave5kg(int weight) throws QuantityLeaveUnavailableException {
		WeightStorage.leave5kg(weight);
	}
	
	public final void leave10kg(int weight) throws QuantityLeaveUnavailableException {
		WeightStorage.leave10kg(weight);
	}
	
	public final void leave15kg(int weight) throws QuantityLeaveUnavailableException {
		WeightStorage.leave15kg(weight);
	}
	
	public final void leave20kg(int weight) throws QuantityLeaveUnavailableException {
		WeightStorage.leave20kg(weight);
	}
	
	public static final void eliminateClientGym(ClientGym client) {
		eliminateFromTheCollectionClientGym(client);
		client = null;
	}

	public static void addToTheCollectionClientGym(ClientGym client) {
		if(clientsGymSet.contains(client)) {
			LOG.log(Level.WARNING, client.getName() +" is already on the Set");
		}
		else {
			clientsGymSet.add(client);
			addToTheCollectionClient(client);
		}
		
	}

	private static final void eliminateFromTheCollectionClientGym(ClientGym client) {
		if(clientsGymSet.contains(client)) {
			clientsGymSet.remove(client);
			eliminateFromTheCollectionClient(client);
		}
		else {
			return;
		}
	}
	
	public static boolean isInTheCollectionClientGym(ClientGym client) {
		boolean isIn = false;
		if(clientsGymSet.contains(client)) {
			isIn = true;
		}
		return isIn;
	}

	public static void printTheCollectionClientGym() {
		if(clientsGymSet.size() >= 1) {
			for(ClientGym client: clientsGymSet) {
				LOG.log(Level.INFO, client.toString());
			}
		}
		else {
			LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
		}
	}
}
