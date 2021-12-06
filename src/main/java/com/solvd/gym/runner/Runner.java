package com.solvd.gym.runner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.data.Client;
import com.solvd.gym.data.ClientGym;
import com.solvd.gym.data.ClientYoga;
import com.solvd.gym.data.CollectionsAdministrator;
import com.solvd.gym.data.DaysOfTheWeek;
import com.solvd.gym.data.Gym;
import com.solvd.gym.data.Instructor;
import com.solvd.gym.data.InstructorGym;
import com.solvd.gym.data.InstructorYoga;
import com.solvd.gym.exception_container.NameContainNumberException;
import com.solvd.gym.exception_container.NullNameException;
import com.solvd.gym.exception_container.ReceiveSalaryException;

public class Runner {

    public static void main(String[] args)
	    throws NullNameException, NameContainNumberException, ReceiveSalaryException {

	Logger LOG = Logger.getLogger(Gym.class.getName());
	Queue<Instructor> instructorsQueue = new LinkedList<>();
	List<Client> clientsList = new ArrayList<>();

	CollectionsAdministrator collectionAdmin = new CollectionsAdministrator(instructorsQueue, clientsList);
	Gym gym = new Gym(collectionAdmin);

	InstructorYoga manuel = new InstructorYoga(1, "manuel", 100);
	InstructorYoga bianca = new InstructorYoga(2, "bianca", 150);

	InstructorGym axel = new InstructorGym(1, "Axel", 700);
	InstructorGym ezequiel = new InstructorGym(2, "Ezequiel", 600);

	ClientYoga ramiro = new ClientYoga(1, "Ramiro");
	ClientYoga sergei = new ClientYoga(2, "Sergei");
	ClientYoga juan = new ClientYoga(3, "Juan");

	ClientGym nina = new ClientGym(1, "Nina");
	ClientGym teo = new ClientGym(2, "Teo");
	ClientGym camila = new ClientGym(3, "Camila");

	collectionAdmin.addInstructorToTheCollection(manuel);
	collectionAdmin.addInstructorToTheCollection(bianca);
	collectionAdmin.addInstructorToTheCollection(axel);
	collectionAdmin.addInstructorToTheCollection(ezequiel);

	collectionAdmin.addClientToTheCollection(ramiro);
	collectionAdmin.addClientToTheCollection(sergei);
	collectionAdmin.addClientToTheCollection(juan);
	collectionAdmin.addClientToTheCollection(nina);
	collectionAdmin.addClientToTheCollection(teo);
	collectionAdmin.addClientToTheCollection(camila);

	LOG.log(Level.INFO, "is ramiro in the client collection " + collectionAdmin.isClientInTheCollection(ramiro));
	collectionAdmin.printClientCollection();
	collectionAdmin.eliminateClientFromTheCollection(ramiro);
	LOG.log(Level.INFO, "is ramiro in the client collection " + collectionAdmin.isClientInTheCollection(ramiro));
	collectionAdmin.printClientYogaCollection();

	ramiro.payFees(300);
	sergei.payFees(300);
	LOG.log(Level.INFO, "Ramiro paid: " + ramiro.getFeesPaid());
	LOG.log(Level.INFO, "Sergei paid: " + sergei.getFeesPaid());
	LOG.log(Level.INFO, "The gym earned: " + Gym.getTotalMoneyEarned());

	try {
	    manuel.receiveSalary();
	} catch (Exception e) {
	    LOG.log(Level.WARNING, "a problem ocurred " + e);
	}

	LOG.log(Level.INFO, "Manuel earned: $" + manuel.getSalaryEarned());
	LOG.log(Level.INFO, "Adrenaline gym has spent: " + gym.getTotalMoneySpent());
	LOG.log(Level.INFO, "Adrenaline gym total money is: $" + Gym.getTotalMoneyEarned());
	Gym.updateTotalMoneySpent(50);
	LOG.log(Level.INFO, "Adrenaline buy a product for $50 now the total money is: $" + Gym.getTotalMoneyEarned());

	try {
	    nina.pick5kg(10);
	} catch (Exception e) {
	    LOG.log(Level.WARNING, "A problem ocurred " + e);
	}

	try {
	    teo.pick10kg(10);
	} catch (Exception e) {
	    LOG.log(Level.WARNING, "A problem ocurred " + e);
	}

	try {
	    nina.leave5kg(11);
	} catch (Exception e) {
	    LOG.log(Level.WARNING, "A problem ocurred " + e);
	}

	try {
	    camila.pick10kg(2);
	} catch (Exception e) {
	    LOG.log(Level.WARNING, "A problem ocurred " + e);
	}

	try {
	    teo.pick10kg(11);
	} catch (Exception e) {
	    LOG.log(Level.WARNING, "A problem ocurred " + e);
	}

	gym.existClientWithName("Sergei");

	Function<Instructor, Integer> getSalary = Instructor::getSalary;
	LOG.log(Level.INFO, "The salary is " + String.valueOf(getSalary.apply(manuel)));
	Consumer<Instructor> changeSalary = Instructor::getSalary;
	changeSalary.accept(axel);
	gym.modifyInstructor(ezequiel, e -> e.setSalary(700));
	LOG.log(Level.INFO, "Ezequiel salary is " + ezequiel.getSalary());
	DaysOfTheWeek.isOpen(DaysOfTheWeek.SUNDAY, d -> d.getIsOpen());
    }
}
