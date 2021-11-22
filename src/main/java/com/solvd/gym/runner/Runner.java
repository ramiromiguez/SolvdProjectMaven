package com.solvd.gym.runner;

import java.util.ArrayList;
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
import com.solvd.gym.data.GenericLinkedList;
import com.solvd.gym.data.Gym;
import com.solvd.gym.data.Instructor;
import com.solvd.gym.data.InstructorGym;
import com.solvd.gym.data.InstructorYoga;
import com.solvd.gym.data.WeightStorage;


public class Runner {
	public static void main(String[] args) throws NullNameException, NameContainNumberException, ReceiveSalaryException {
		
		Logger LOG = Logger.getLogger(WeightStorage.class.getName());
		
		
		//Clients Yoga
		ClientYoga ramiro = new ClientYoga(1, "Ramiro");
		ClientYoga sergei = new ClientYoga(2, "Sergei");
		ClientYoga juan = new ClientYoga(3, "Juan");
		ClientYoga dario = new ClientYoga(4, "Dario");
		ClientYoga maria = new ClientYoga(5, "Maria");
		//Clients Gym
		ClientGym nina = new ClientGym(1, "Nina");
		ClientGym teo = new ClientGym(2,"Teo");
		ClientGym camila = new ClientGym(3, "Camila");
		ClientGym matias = new ClientGym(4, "Matias");
		ClientGym roberto = new ClientGym(5, "Roberto");
		
		List<ClientYoga> listClientsYoga = new ArrayList<>();
		Set<ClientGym> listClientsGym = new HashSet<>();
		
		listClientsYoga.add(ramiro);
		listClientsYoga.add(sergei);
		listClientsYoga.add(juan);
		listClientsYoga.add(dario);
		listClientsYoga.add(maria);
		listClientsGym.add(nina);
		listClientsGym.add(teo);
		listClientsGym.add(camila);
		listClientsGym.add(matias);
		listClientsGym.add(roberto);
		
		Set<Client> listClients = new HashSet<>();
				
//		Iterator<ClientYoga> i = listClientsYoga.iterator();
//		while(i.hasNext()) {
//			listClients.add(i.next());
//			//LOG.log(Level.INFO, i.next().getName());
//			System.out.println(i.next().getName());
//		}
		
		System.out.println("Yoga clients");
		for(ClientYoga clientYoga: listClientsYoga) {
			listClients.add(clientYoga);
			LOG.log(Level.INFO, clientYoga.getName());
		}
		System.out.println("Gym clients");
		for(ClientGym clientGym: listClientsGym) {
			listClients.add(clientGym);
			LOG.log(Level.INFO, clientGym.getName());
		}
		System.out.println("All clients");
		for(Client client: listClients) {
			LOG.log(Level.INFO, client.getName());
		}

		InstructorYoga manuel = new InstructorYoga(1, "manuel", 100, listClientsYoga);
		InstructorYoga bianca = new InstructorYoga(2, "bianca", 150, listClientsYoga);
		InstructorGym axel = new InstructorGym(1, "Axel", 700);
		InstructorGym ezequiel = new InstructorGym(2, "Ezequiel", 600);
		
		List<Instructor> instructorList = new ArrayList<>();
		
		Map<Integer, InstructorGym> mapInstructorGym = new HashMap<>();
		
		mapInstructorGym.put(1, ezequiel);
		mapInstructorGym.put(2, axel);
		
		System.out.println("Gym instructors");
		for(Integer key: mapInstructorGym.keySet()) {
			instructorList.add(mapInstructorGym.get(key));
			LOG.log(Level.INFO, key + ":" + mapInstructorGym.get(key));
		}
		
		Queue<InstructorYoga> queueInstructorsYoga = new LinkedList<>();
		
		queueInstructorsYoga.add(manuel);
		queueInstructorsYoga.add(bianca);
		
		System.out.println("Yoga instructors");
		for(InstructorYoga instructorYoga: queueInstructorsYoga) {
			instructorList.add(instructorYoga);
			LOG.log(Level.INFO, instructorYoga.getName());
		}
		
		System.out.println("Instructors");
		for(Instructor instructor: instructorList ) {
			LOG.log(Level.INFO, instructor.getName());
		}
		
		//super list containing instructors and clients
		
		GenericLinkedList<Object> superList = new GenericLinkedList<>();
		
		for(Instructor instructor: instructorList) {
			superList.insert(instructor);
		}
		for(Client client: listClients) {
			superList.insert(client);
		}
		//shows all the clients and instructors
		superList.show();
		
		
		
//		instructorsList.add(manuel);
//		instructorsList.add(axel);
				
//		Gym adrenaline = new Gym(instructorsList, listClients);
//		
//		System.out.println("-----Yoga-----");
//		ramiro.payFees(300);
//		sergei.payFees(300);
//		LOG.log(Level.INFO,"Ramiro paid: "+ramiro.getFeesPaid());
//		LOG.log(Level.INFO,"Sergei paid: "+sergei.getFeesPaid());
//		LOG.log(Level.INFO,"The gym earned: "+Gym.getTotalMoneyEarned());
//		try {
//			manuel.receiveSalary();
//		}
//		catch(Exception e){
//			LOG.log(Level.WARNING,"a problem ocurred" +e);
//		}
//		LOG.log(Level.INFO,"Manuel earned: $"+manuel.getSalaryEarned()); 
//		LOG.log(Level.INFO,"Adrenaline gym has spent: " + adrenaline.getTotalMoneySpent());
//		LOG.log(Level.INFO,"Adrenaline gym total money is: $"+Gym.getTotalMoneyEarned());
//		System.out.println("----Gym-----");
//		Gym.updateTotalMoneySpent(50);
//		LOG.log(Level.INFO,"Adrenaline buy a product for $50 now the total money is: $"+Gym.getTotalMoneyEarned());
//		nina.pick5kg(15);
//		teo.pick5kg(6);
//		nina.leave5kg(10);
//		teo.pick5kg(6);
	}
}