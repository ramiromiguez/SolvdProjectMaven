package com.solvd.gym.runner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;
import java.util.function.LongBinaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.data.Client;
import com.solvd.gym.data.ClientGym;
import com.solvd.gym.data.ClientMartialArt;
import com.solvd.gym.data.ClientWeightLifter;
import com.solvd.gym.data.ClientYoga;
import com.solvd.gym.data.CollectionsAdministrator;
import com.solvd.gym.data.DaysOfTheWeek;
import com.solvd.gym.data.Gym;
import com.solvd.gym.data.Instructor;
import com.solvd.gym.data.InstructorGym;
import com.solvd.gym.data.InstructorMartialArt;
import com.solvd.gym.data.InstructorWeightLifter;
import com.solvd.gym.data.InstructorYoga;
import com.solvd.gym.data.MartialArtType;
import com.solvd.gym.data.WeightLiftExcercise;
import com.solvd.gym.data.WeightStorage;
import com.solvd.gym.exception_container.NameContainNumberException;
import com.solvd.gym.exception_container.NullNameException;
import com.solvd.gym.exception_container.ReceiveSalaryException;
import com.solvd.gym.interfaces.DifficultCombinator;
import com.solvd.gym.interfaces.SalaryIncrease;

public class Runner {

    public static void main(String[] args)
	    throws NullNameException, NameContainNumberException, ReceiveSalaryException {

	Logger LOG = Logger.getLogger(Gym.class.getName());
	Queue<Instructor> instructorsQueue = new LinkedList<>();
	List<Client> clientsList = new ArrayList<>();
	CollectionsAdministrator collectionAdmin = new CollectionsAdministrator(instructorsQueue, clientsList);
	Gym gym = new Gym(collectionAdmin);

	InstructorYoga manuel = new InstructorYoga(1, "manuel", 100, DaysOfTheWeek.FRIDAY);
	InstructorYoga bianca = new InstructorYoga(2, "bianca", 150, DaysOfTheWeek.MONDAY);

	InstructorGym axel = new InstructorGym(1, "Axel", 700);
	InstructorGym ezequiel = new InstructorGym(2, "Ezequiel", 600);

	InstructorWeightLifter marcos = new InstructorWeightLifter(4, "Marcos", 2000, WeightLiftExcercise.FRONT_SQUAT);

	InstructorMartialArt pablo = new InstructorMartialArt(5, "Pablo", 3000, MartialArtType.KICKBOXING);

	ClientYoga ramiro = new ClientYoga(1, "Ramiro");
	ClientYoga sergei = new ClientYoga(2, "Sergei");
	ClientYoga juan = new ClientYoga(3, "Juan");

	ClientGym nina = new ClientGym(1, "Nina");
	ClientGym teo = new ClientGym(2, "Teo");
	ClientGym camila = new ClientGym(3, "Camila");

	ClientWeightLifter pedro = new ClientWeightLifter(10, "Pedro");

	ClientMartialArt sabrina = new ClientMartialArt(11, "Sabrina", MartialArtType.KICKBOXING);

	collectionAdmin.addInstructorToTheCollection(manuel);
	collectionAdmin.addInstructorToTheCollection(bianca);
	collectionAdmin.addInstructorToTheCollection(axel);
	collectionAdmin.addInstructorToTheCollection(ezequiel);
	collectionAdmin.addInstructorToTheCollection(marcos);
	collectionAdmin.addInstructorToTheCollection(pablo);

	collectionAdmin.addClientToTheCollection(ramiro);
	collectionAdmin.addClientToTheCollection(sergei);
	collectionAdmin.addClientToTheCollection(juan);
	collectionAdmin.addClientToTheCollection(nina);
	collectionAdmin.addClientToTheCollection(teo);
	collectionAdmin.addClientToTheCollection(camila);
	collectionAdmin.addClientToTheCollection(pedro);
	collectionAdmin.addClientToTheCollection(sabrina);

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

	// java.util.function
	gym.existClientWithName("Sergei");
	Function<Instructor, Integer> getSalary = Instructor::getSalary;
	LOG.log(Level.INFO, "The salary is " + String.valueOf(getSalary.apply(ezequiel)));
	gym.modifyInstructor(ezequiel, e -> e.setSalary(500));
	LOG.log(Level.INFO, "Ezequiel salary is " + ezequiel.getSalary());
	LongBinaryOperator longBinaryOperator = (power1, power2) -> {
	    return power1 + power2;
	};
	LOG.log(Level.INFO,
		"the power level of " + MartialArtType.KICKBOXING + " combined with the power of " + MartialArtType.JUDO
			+ " is " + longBinaryOperator.applyAsLong(MartialArtType.KICKBOXING.getDamage(),
				MartialArtType.JUDO.getDamage()));
	DaysOfTheWeek.isOpen(DaysOfTheWeek.SUNDAY, d -> d.getIsOpen());

	// custom functions
	boolean isBigger = false;
	gym.biggerList(isBigger,
		i -> collectionAdmin.getClientGymSet().size() > collectionAdmin.getClientYogaSet().size());

	DifficultCombinator combinatorEspecialization = (String a, String b) -> {
	    return "You will be espcialized in " + a + " and " + b;
	};

	LOG.log(Level.INFO, combinatorEspecialization.combination(MartialArtType.BOX.getEspecialization(),
		MartialArtType.KICKBOXING.getEspecialization()));

	SalaryIncrease increaser = (int a, float b, int c) -> {
	    return (int) (a * b + c);
	};

	LOG.log(Level.INFO, "bianca salary is: " + bianca.getSalary());
	bianca.setSalary(increaser.increase(1200, (float) 0.5, 50));
	LOG.log(Level.INFO, "bianca salary after update is: " + bianca.getSalary());

	// streams
	List<Instructor> instList = gym.returnInstructorWithSalaryBiggerThan499();
	instList.forEach(instructor -> LOG.log(Level.INFO,
		"instructor " + instructor.getName() + " earn " + instructor.getSalary()));

	instList = gym.sortInstructorsByTheirSalary();
	instList.forEach(instructor -> LOG.log(Level.INFO, instructor.getName() + " " + instructor.getSalary()));

	List<MartialArtType> martialList = MartialArtType.BOX.getHardMartialArts();
	martialList.forEach(MartialArtType -> LOG.log(Level.INFO, MartialArtType.name() + " is hard"));

	MartialArtType.KICKBOXING.getMostPowerfullMartial();

	DaysOfTheWeek.FRIDAY.getLeesHoursOpen();

	WeightStorage.FIFTEEN_KG.getAvailableWeights();

    }
}
