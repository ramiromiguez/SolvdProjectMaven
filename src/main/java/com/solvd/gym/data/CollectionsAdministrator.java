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
    private Set<InstructorWeightLifter> instructorsWeightLifterSet = new HashSet<>();
    private Set<InstructorMartialArt> instructorsMartialArtSet = new HashSet<>();
    private Set<ClientWeightLifter> clientsWeightLifterSet = new HashSet<>();
    private Set<ClientMartialArt> clientsMartialArtSet = new HashSet<>();
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
    public void addInstructorToTheCollection(InstructorWeightLifter instructorWeightLifter) {
	if (isInstructorInTheCollection(instructorWeightLifter)) {
	    return;
	} else {
	    instructorsWeightLifterSet.add(instructorWeightLifter);
	    instructorsQueue.add(instructorWeightLifter);
	    totalCollection.insert(instructorWeightLifter);
	}
    }

    @Override
    public void addInstructorToTheCollection(InstructorMartialArt instructorMartialArt) {
	if (isInstructorInTheCollection(instructorMartialArt)) {
	    return;
	} else {
	    instructorsMartialArtSet.add(instructorMartialArt);
	    instructorsQueue.add(instructorMartialArt);
	    totalCollection.insert(instructorMartialArt);
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
    public void addClientToTheCollection(ClientWeightLifter clientWeightLifter) {
	if (isClientInTheCollection(clientWeightLifter)) {
	    LOG.log(Level.WARNING, clientWeightLifter.getName() + " is already on the Set");
	} else {
	    clientsWeightLifterSet.add(clientWeightLifter);
	    clientsList.add(clientWeightLifter);
	    totalCollection.insert(clientWeightLifter);
	}
    }

    @Override
    public void addClientToTheCollection(ClientMartialArt clientMartialArt) {
	if (isClientInTheCollection(clientMartialArt)) {
	    LOG.log(Level.WARNING, clientMartialArt.getName() + " is already on the Set");
	} else {
	    clientsMartialArtSet.add(clientMartialArt);
	    clientsList.add(clientMartialArt);
	    totalCollection.insert(clientMartialArt);
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
    public void eliminateInstructorFromTheCollection(InstructorWeightLifter instructorWeightLifter) {
	if (isInstructorInTheCollection(instructorWeightLifter)) {
	    instructorsWeightLifterSet.remove(instructorWeightLifter);
	    instructorsQueue.remove(instructorWeightLifter);
	    totalCollection.deleteData(instructorWeightLifter);
	} else {
	    return;
	}
    }

    @Override
    public void eliminateInstructorFromTheCollection(InstructorMartialArt instructorMartialArt) {
	if (isInstructorInTheCollection(instructorMartialArt)) {
	    instructorsMartialArtSet.remove(instructorMartialArt);
	    instructorsQueue.remove(instructorMartialArt);
	    totalCollection.deleteData(instructorMartialArt);
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
    public void eliminateClientFromTheCollection(ClientWeightLifter clientWeightLifter) {
	if (isClientInTheCollection(clientWeightLifter)) {
	    clientsWeightLifterSet.remove(clientWeightLifter);
	    clientsList.remove(clientWeightLifter);
	    totalCollection.deleteData(clientWeightLifter);
	} else {
	    return;
	}
    }

    @Override
    public void eliminateClientFromTheCollection(ClientMartialArt clientMartialArt) {
	if (isClientInTheCollection(clientMartialArt)) {
	    clientsMartialArtSet.remove(clientMartialArt);
	    clientsList.remove(clientMartialArt);
	    totalCollection.deleteData(clientMartialArt);
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
    public boolean isInstructorInTheCollection(InstructorWeightLifter instructorWeightLifter) {
	boolean isIn = false;
	if (instructorsWeightLifterSet.contains(instructorWeightLifter)) {
	    isIn = true;
	}
	return isIn;
    }

    @Override
    public boolean isInstructorInTheCollection(InstructorMartialArt instructorMartialArt) {
	boolean isIn = false;
	if (instructorsMartialArtSet.contains(instructorMartialArt)) {
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
    public boolean isClientInTheCollection(ClientWeightLifter clientWeightLifter) {
	boolean isIn = false;
	if (clientsWeightLifterSet.contains(clientWeightLifter)) {
	    isIn = true;
	}
	return isIn;
    }

    @Override
    public boolean isClientInTheCollection(ClientMartialArt clientMartialArt) {
	boolean isIn = false;
	if (clientsMartialArtSet.contains(clientMartialArt)) {
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
    public void printInstructorWeightLifter() {
	if (instructorsWeightLifterSet.size() >= 1) {
	    for (InstructorWeightLifter instructor : instructorsWeightLifterSet) {
		LOG.log(Level.INFO, instructor.toString());
	    }
	} else {
	    LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
	}
    }

    @Override
    public void printInstructorMartialArt() {
	if (instructorsMartialArtSet.size() >= 1) {
	    for (InstructorMartialArt instructor : instructorsMartialArtSet) {
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
    public void printClientWeightLifterCollection() {
	if (clientsWeightLifterSet.size() >= 1) {
	    for (ClientWeightLifter client : clientsWeightLifterSet) {
		LOG.log(Level.INFO, client.toString());
	    }
	} else {
	    LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
	}
    }

    @Override
    public void printClientMartialArtCollection() {
	if (clientsMartialArtSet.size() >= 1) {
	    for (ClientMartialArt client : clientsMartialArtSet) {
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
    public Set<InstructorWeightLifter> getInstructorWeightLifterSet() {
	return instructorsWeightLifterSet;
    }

    @Override
    public Set<InstructorMartialArt> getInstructorMartialArtSet() {
	return instructorsMartialArtSet;
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

    @Override
    public Set<ClientWeightLifter> getClientWeightLifterSet() {
	return clientsWeightLifterSet;
    }

    @Override
    public Set<ClientMartialArt> getClientMartialArtSet() {
	return clientsMartialArtSet;
    }
}
