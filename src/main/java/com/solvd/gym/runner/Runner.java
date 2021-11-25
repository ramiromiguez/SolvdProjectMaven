package com.solvd.gym.runner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.exceptionContainer.NameContainNumberException;
import com.solvd.gym.exceptionContainer.NullNameException;
import com.solvd.gym.exceptionContainer.ReceiveSalaryException;
import com.solvd.gym.data.Client;
import com.solvd.gym.data.ClientGym;
import com.solvd.gym.data.ClientYoga;
import com.solvd.gym.genericlinkedlist.*;
import com.solvd.gym.data.Gym;
import com.solvd.gym.data.Instructor;
import com.solvd.gym.data.InstructorGym;
import com.solvd.gym.data.InstructorYoga;
import com.solvd.gym.data.WeightStorage;


public class Runner {

//	public Collection<Object> createNewList(Collection<Object> oldList) {
//		List<Object> newList = new ArrayList<>();
//		for(Object x: oldList) {
//			newList.add(x);
//		}
//		return newList;
//	}
	
	public static void main(String[] args) throws NullNameException, NameContainNumberException, ReceiveSalaryException {
	
		
		Logger LOG = Logger.getLogger(WeightStorage.class.getName());
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("OBJECTS AND COLLECTION CREATION");
		System.out.println("------------------------------------------------------------------------------------");
		//Yoga clients creation
		ClientYoga ramiro = new ClientYoga(1, "Ramiro");
		ClientYoga sergei = new ClientYoga(2, "Sergei");
		ClientYoga juan = new ClientYoga(3, "Juan");
		ClientYoga dario = new ClientYoga(4, "Dario");
		ClientYoga maria = new ClientYoga(5, "Maria");
		//Gym clients creation
		ClientGym nina = new ClientGym(1, "Nina");
		ClientGym teo = new ClientGym(2,"Teo");
		ClientGym camila = new ClientGym(3, "Camila");
		ClientGym matias = new ClientGym(4, "Matias");
		ClientGym roberto = new ClientGym(5, "Roberto");
		
		// yoga and gym collection creation
		Set<ClientYoga> clientsYogaSet= new HashSet<>();
		List<ClientGym> clientsGymList = new ArrayList<>();
		
		// adding yoga clients to the list
		clientsYogaSet.add(ramiro);
		clientsYogaSet.add(sergei);
		clientsYogaSet.add(juan);
		clientsYogaSet.add(dario);
		clientsYogaSet.add(maria);
		// adding gym clients to the Set
		clientsGymList.add(nina);
		clientsGymList.add(teo);
		clientsGymList.add(camila);
		clientsGymList.add(matias);
		clientsGymList.add(roberto);
		
		// Creating all clients Set
		Set<Client> ClientsSet = new HashSet<>();
				
//		Iterator<ClientYoga> i = clientsYogaSet.iterator();
//		while(i.hasNext()) {
//			ClientsSet.add(i.next());
//			//LOG.log(Level.INFO, i.next().getName());
//			System.out.println(i.next().getName());
//		}
		
		// Adding Yoga clients to the List
		System.out.println("Yoga clients");
		for(ClientYoga clientYoga: clientsYogaSet) {
			ClientsSet.add(clientYoga);
			LOG.log(Level.INFO, clientYoga.getName());
		}
//		ClientsSet = createNewList(clientsYogaSet);
		// Adding Gym clients to the Set
		System.out.println("Gym clients");
		for(ClientGym clientGym: clientsGymList) {
			ClientsSet.add(clientGym);
			LOG.log(Level.INFO, clientGym.getName());
		}
		// Adding all clients to the Set
		System.out.println("All clients");
		for(Client client: ClientsSet) {
			LOG.log(Level.INFO, client.getName());
		}
		
		// Creating individual client set for yoga instructors
		Set<ClientYoga> manuelYogaClients = new HashSet<>();
		Set<ClientYoga> biancaYogaClients = new HashSet<>();
		manuelYogaClients.add(ramiro);
		manuelYogaClients.add(sergei);
		biancaYogaClients.add(maria);
		biancaYogaClients.add(dario);
		
		
		// Yoga instructors creation
		InstructorYoga manuel = new InstructorYoga(1, "manuel", 100, manuelYogaClients);
		manuel.quantityOfClients();
		manuel.printClients();
		InstructorYoga bianca = new InstructorYoga(2, "bianca", 150, biancaYogaClients);
		bianca.quantityOfClients();
		bianca.printClients();
		// Gym instructors creation
		InstructorGym axel = new InstructorGym(1, "Axel", 700);
		InstructorGym ezequiel = new InstructorGym(2, "Ezequiel", 600);
		
		
		// Instructor list creation
		Set<Instructor> instructorsSet = new HashSet<>();
		// Instructors gym map creation
		Map<Integer, InstructorGym> mapInstructorGym = new HashMap<>();
		// Instructors yoga queue creation
		Queue<InstructorYoga> queueInstructorsYoga = new LinkedList<>();
		
		//adding gym instructors to the map
		mapInstructorGym.put(1, axel);
		mapInstructorGym.put(2, ezequiel);
		//adding yoga instructors to the queue
		queueInstructorsYoga.add(manuel);
		queueInstructorsYoga.add(bianca);
		
		// adding gym instructors to the instructors list
		System.out.println("Gym instructors");
		for(Integer key: mapInstructorGym.keySet()) {
			instructorsSet.add(mapInstructorGym.get(key));
			LOG.log(Level.INFO, key + ":" + mapInstructorGym.get(key));
		}
		// adding yoga instructors to the instructors list
		System.out.println("Yoga instructors");
		for(InstructorYoga instructorYoga: queueInstructorsYoga) {
			instructorsSet.add(instructorYoga);
			LOG.log(Level.INFO, instructorYoga.getName());
		}
		//printing total instructors list
		System.out.println("All INSTRUCTORS");
		for(Instructor instructor: instructorsSet ) {
			LOG.log(Level.INFO, instructor.getName());
		}
		
		//Creation of super list that contains instructors and clients
		GenericLinkedList<Object> superList = new GenericLinkedList<>();
		
		//adding instructors to the super list
		for(Instructor instructor: instructorsSet) {
			superList.insert(instructor);
		}
		//adding clients to the super list
		for(Client client: ClientsSet) {
			superList.insert(client);
		}
		
		//shows all the clients and instructors
		superList.show();
		
		Gym adrenaline = new Gym(instructorsSet, ClientsSet);
	
	
		System.out.println("\n\n------------------------------------------------------------------------------------");
		System.out.println("PLAYING WITH OBJECT METHODS");
		System.out.println("------------------------------------------------------------------------------------");
		
		ramiro.payFees(300);
		sergei.payFees(300);
		LOG.log(Level.INFO,"Ramiro paid: "+ramiro.getFeesPaid());
		LOG.log(Level.INFO,"Sergei paid: "+sergei.getFeesPaid());
		LOG.log(Level.INFO,"The gym earned: "+Gym.getTotalMoneyEarned());
		
		try {
			manuel.receiveSalary();
		}
		catch(Exception e){
			LOG.log(Level.WARNING,"a problem ocurred " +e);
		}
		
		LOG.log(Level.INFO,"Manuel earned: $"+manuel.getSalaryEarned()); 
		LOG.log(Level.INFO,"Adrenaline gym has spent: " + adrenaline.getTotalMoneySpent());
		LOG.log(Level.INFO,"Adrenaline gym total money is: $"+Gym.getTotalMoneyEarned());
		System.out.println("----Gym-----");
		Gym.updateTotalMoneySpent(50);
		LOG.log(Level.INFO,"Adrenaline buy a product for $50 now the total money is: $"+Gym.getTotalMoneyEarned());
		
		try {
			nina.pick5kg(10);
		}
		catch(Exception e) {
			LOG.log(Level.WARNING, "A problem ocurred " +e);
		}
		try {
			teo.pick5kg(20);
		}
		catch(Exception e) {
			LOG.log(Level.WARNING, "A problem ocurred " +e);
		}
		
		System.out.println("\n\n------------------------------------------------------------------------------------");
		System.out.println("PLAYING WITH COLLECTIONS METHODS");
		System.out.println("------------------------------------------------------------------------------------");
		LOG.log(Level.INFO,"Is clientsYogaSet empty? "+clientsYogaSet.isEmpty());
		clientsYogaSet.clear();
		LOG.log(Level.INFO,"Is clientsYogaSet empty? "+clientsYogaSet.isEmpty());
	}
}