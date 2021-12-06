package com.solvd.gym.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.genericlinkedlist.GenericLinkedList;
import com.solvd.gym.interfaces.ICollectionsAdministrator;

public class CollectionsAdministrator implements ICollectionsAdministrator {

    private GenericLinkedList<Object> totalCollection = new GenericLinkedList<>();
    private Queue<Instructor> instructorsQueue = new LinkedList<>();
    private List<Client> clientsList = new ArrayList<>();
    private Set<InstructorYoga> instructorsYogaSet = new HashSet<>();
    private Set<ClientYoga> clientsYogaSet = new HashSet<>();
    private Set<InstructorGym> instructorsGymSet = new HashSet<>();
    private Set<ClientGym> clientsGymSet = new HashSet<>();
    private final static Logger LOG = Logger.getLogger(CollectionsAdministrator.class.getName());

    public CollectionsAdministrator(Queue<Instructor> instructorsQueue, List<Client> clientList) {
	super();
	this.instructorsQueue = instructorsQueue;
    }

    @Override
    public void addInstructorToTheCollection(InstructorYoga instructorYoga) {
	if (isInstructorInTheCollection(instructorYoga)) {
	    return;
	} else {
	    instructorsYogaSet.add(instructorYoga);
	    instructorsQueue.add(instructorYoga);
	    totalCollection.insert(instructorYoga);
	}
    }

    @Override
    public void addInstructorToTheCollection(InstructorGym instructorGym) {
	if (isInstructorInTheCollection(instructorGym)) {
	    return;
	} else {
	    instructorsGymSet.add(instructorGym);
	    instructorsQueue.add(instructorGym);
	    totalCollection.insert(instructorGym);
	}
    }

    @Override
    public void addClientToTheCollection(ClientYoga clientYoga) {
	if (isClientInTheCollection(clientYoga)) {
	    LOG.log(Level.WARNING, clientYoga.getName() + " is already on the Set");
	} else {
	    clientsYogaSet.add(clientYoga);
	    clientsList.add(clientYoga);
	    totalCollection.insert(clientYoga);
	}
    }

    @Override
    public void addClientToTheCollection(ClientGym clientGym) {
	if (isClientInTheCollection(clientGym)) {
	    LOG.log(Level.WARNING, clientGym.getName() + " is already on the Set");
	} else {
	    clientsGymSet.add(clientGym);
	    clientsList.add(clientGym);
	    totalCollection.insert(clientGym);
	}
    }

    @Override
    public void eliminateInstructorFromTheCollection(InstructorYoga instructorYoga) {
	if (isInstructorInTheCollection(instructorYoga)) {
	    instructorsYogaSet.remove(instructorYoga);
	    instructorsQueue.remove(instructorYoga);
	    totalCollection.deleteData(instructorYoga);
	} else {
	    return;
	}
    }

    @Override
    public void eliminateInstructorFromTheCollection(InstructorGym instructorGym) {
	if (isInstructorInTheCollection(instructorGym)) {
	    instructorsGymSet.remove(instructorGym);
	    instructorsQueue.remove(instructorGym);
	    totalCollection.deleteData(instructorGym);
	} else {
	    return;
	}

    }

    @Override
    public void eliminateClientFromTheCollection(ClientYoga clientYoga) {
	if (isClientInTheCollection(clientYoga)) {
	    clientsYogaSet.remove(clientYoga);
	    clientsList.remove(clientYoga);
	    totalCollection.deleteData(clientYoga);
	} else {
	    return;
	}
    }

    @Override
    public void eliminateClientFromTheCollection(ClientGym clientGym) {
	if (isClientInTheCollection(clientGym)) {
	    clientsGymSet.remove(clientGym);
	    clientsList.remove(clientGym);
	    totalCollection.deleteData(clientGym);
	} else {
	    return;
	}
    }

    @Override
    public boolean isInstructorInTheCollection(InstructorYoga instructorYoga) {
	boolean isIn = false;
	if (instructorsYogaSet.contains(instructorYoga)) {
	    isIn = true;
	}
	return isIn;
    }

    @Override
    public boolean isInstructorInTheCollection(InstructorGym instructorGym) {
	boolean isIn = false;
	if (instructorsGymSet.contains(instructorGym)) {
	    isIn = true;
	}
	return isIn;
    }

    @Override
    public boolean isClientInTheCollection(ClientYoga clientYoga) {
	boolean isIn = false;
	if (clientsYogaSet.contains(clientYoga)) {
	    isIn = true;
	}
	return isIn;

    }

    @Override
    public boolean isClientInTheCollection(ClientGym clientGym) {
	boolean isIn = false;
	if (clientsGymSet.contains(clientGym)) {
	    isIn = true;
	}
	return isIn;

    }

    @Override
    public void printTotalCollection() {
	totalCollection.show();
    }

    @Override
    public void printInstructorCollection() {
	if (instructorsQueue.size() >= 1) {
	    for (Instructor instructor : instructorsQueue) {
		LOG.log(Level.INFO, instructor.toString());
	    }
	} else {
	    LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
	}
    }

    @Override
    public void printInstructorYogaCollection() {
	if (instructorsYogaSet.size() >= 1) {
	    for (InstructorYoga instructor : instructorsYogaSet) {
		LOG.log(Level.INFO, instructor.toString());
	    }
	} else {
	    LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
	}
    }

    @Override
    public void printInstrcutorGymCollection() {
	if (instructorsGymSet.size() >= 1) {
	    for (InstructorGym instructor : instructorsGymSet) {
		LOG.log(Level.INFO, instructor.toString());
	    }
	} else {
	    LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
	}

    }

    @Override
    public void printClientCollection() {
	if (clientsList.size() >= 1) {
	    for (Client client : clientsList) {
		LOG.log(Level.INFO, client.toString());
	    }
	} else {
	    LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
	}
    }

    @Override
    public void printClientYogaCollection() {
	if (clientsYogaSet.size() >= 1) {
	    for (ClientYoga client : clientsYogaSet) {
		LOG.log(Level.INFO, client.toString());
	    }
	} else {
	    LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
	}
    }

    @Override
    public void printClientGymCollection() {
	if (clientsGymSet.size() >= 1) {
	    for (ClientGym client : clientsGymSet) {
		LOG.log(Level.INFO, client.toString());
	    }
	} else {
	    LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
	}
    }

    @Override
    public GenericLinkedList<Object> getTotalGenericLinkedList() {
	return totalCollection;
    }

    @Override
    public Queue<Instructor> getInstructorList() {
	return instructorsQueue;
    }

    @Override
    public Set<InstructorYoga> getInstructorYogaSet() {
	return instructorsYogaSet;
    }

    @Override
    public Set<InstructorGym> getInstructorGymSet() {
	return instructorsGymSet;
    }

    @Override
    public List<Client> getClientList() {
	return clientsList;
    }

    @Override
    public Set<ClientYoga> getClientYogaSet() {
	return clientsYogaSet;
    }

    @Override
    public Set<ClientGym> getClientGymSet() {
	return clientsGymSet;
    }

}

/*
 * //CLIENT FUNCTIONS public void nameChecker(Client client, Function<Client,
 * Boolean> isOnTheGym) { boolean isOn = isOnTheGym.apply(client);
 * System.out.println("Client " + client.getName() + " name is equal " + isOn);
 * }
 * 
 * public void existClientWithName(String string) { for (Client c :
 * Gym.getTheCollectionClient()) { Gym.nameChecker(c, client ->
 * client.getName().equals(string)); } }
 * 
 * static BiFunction<Integer, Integer, Integer> salaryFunction = (salary1,
 * salary2) -> Math.abs(salary1 - salary2);
 * 
 * public static int minusSalary(int salary1, int salary2) { int difference =
 * salaryFunction.apply(salary1, salary2); return difference;
 */
