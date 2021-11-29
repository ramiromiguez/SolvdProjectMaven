package com.solvd.gym.runner;

import com.solvd.gym.exceptionContainer.NameContainNumberException;
import com.solvd.gym.exceptionContainer.NullNameException;
import com.solvd.gym.exceptionContainer.ReceiveSalaryException;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.data.Client;
import com.solvd.gym.data.ClientGym;
import com.solvd.gym.data.ClientYoga;
import com.solvd.gym.data.Gym;
import com.solvd.gym.data.Instructor;
import com.solvd.gym.data.InstructorGym;
import com.solvd.gym.data.InstructorYoga;
import com.solvd.gym.data.WeightStorage;

public class Runner {

	public static void main(String[] args) throws NullNameException, NameContainNumberException, ReceiveSalaryException {
		Logger LOG = Logger.getLogger(Gym.class.getName());
		
		Gym gym = new Gym(Instructor.getCollection(), Client.getCollection());
		
		ClientYoga ramiro = new ClientYoga(1, "Ramiro");
		ClientYoga sergei = new ClientYoga(2, "Sergei");
		ClientYoga juan = new ClientYoga(3, "Juan");
		ClientYoga dario = new ClientYoga(4, "Dario");
		ClientYoga maria = new ClientYoga(5, "Maria");
		
		ClientGym nina = new ClientGym(1, "Nina");
		ClientGym teo = new ClientGym(2,"Teo");
		ClientGym camila = new ClientGym(3, "Camila");
		ClientGym matias = new ClientGym(4, "Matias");
		ClientGym roberto = new ClientGym(5, "Roberto");
		
		InstructorYoga manuel = new InstructorYoga(1, "manuel", 100);
		InstructorYoga bianca = new InstructorYoga(2, "bianca", 150);
		
		InstructorGym axel = new InstructorGym(1, "Axel", 700);
		InstructorGym ezequiel = new InstructorGym(2, "Ezequiel", 600);
		
		ClientYoga.addToTheCollectionClientYoga(ramiro);
		ClientYoga.addToTheCollectionClientYoga(sergei);
		ClientYoga.addToTheCollectionClientYoga(juan);
		ClientYoga.addToTheCollectionClientYoga(dario);
		ClientYoga.addToTheCollectionClientYoga(maria);
		
		ClientGym.addToTheCollectionClientGym(nina);
		ClientGym.addToTheCollectionClientGym(teo);
		ClientGym.addToTheCollectionClientGym(camila);
		ClientGym.addToTheCollectionClientGym(matias);
		ClientGym.addToTheCollectionClientGym(roberto);
		
		InstructorYoga.addToTheCollectionYogaInstrcuctor(manuel);
		InstructorYoga.addToTheCollectionYogaInstrcuctor(bianca);
		
		InstructorGym.addToTheCollectionInstructorGym(axel);
		InstructorGym.addToTheCollectionInstructorGym(ezequiel);
		
		LOG.log(Level.INFO, "Is juan on the ClientYoga Collection? " + ClientYoga.isInTheCollectionClientYoga(juan));
		LOG.log(Level.INFO, "Is juan on the Client Collection? " + ClientYoga.isInTheCollectionClient(juan));
		ClientYoga.eliminateClientYoga(juan);
		LOG.log(Level.INFO, "Is juan on the ClientYoga Collection? " +ClientYoga.isInTheCollectionClientYoga(juan));
		LOG.log(Level.INFO, "Is juan on the Client Collection? " +ClientYoga.isInTheCollectionClient(juan));
		ClientYoga.printTheCollectionClientYoga();
		LOG.log(Level.INFO, "Is roberto on the ClientGym Collection? " + ClientGym.isInTheCollectionClientGym(roberto));
		LOG.log(Level.INFO, "Is roberto on the Client Collection? " + ClientGym.isInTheCollectionClient(roberto));
		ClientGym.eliminateClientGym(roberto);
		LOG.log(Level.INFO, "Is juan on the ClientGym Collection? " + ClientGym.isInTheCollectionClientGym(roberto));
		LOG.log(Level.INFO, "Is juan on the Client Collection? " + ClientGym.isInTheCollectionClientGym(roberto));
		ClientGym.printTheCollectionClientGym();
		LOG.log(Level.INFO, "Client Collection print");
		Client.printTheCollectionClient();
		InstructorYoga.printTheCollectionYogaInstrcuctor();
		InstructorGym.printTheCollectionInstructorGym();
		Instructor.printTheCollectionInstrcutor();
		Gym.printTheCollectionInstrcutor();
		Gym.printTheTotalCollection();
		
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
		LOG.log(Level.INFO,"Adrenaline gym has spent: " + gym.getTotalMoneySpent());
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
	}
}
