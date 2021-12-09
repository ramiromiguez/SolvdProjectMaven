package com.solvd.gym.data;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.exception_container.ReceiveSalaryException;

public class InstructorWeightLifter extends Instructor {
    private List<String> listOfExcercises;
    WeightLiftExcercise bestLift;
    private final static Logger LOG = Logger.getLogger(InstructorWeightLifter.class.getName());

    public InstructorWeightLifter(int id, String name, int salary, WeightLiftExcercise bestLift) {
	super(id, name, salary);
	this.bestLift = bestLift;
	// TODO Auto-generated constructor stub
    }

    @Override
    public void receiveSalary() throws ReceiveSalaryException {
	salaryEarned = +getSalary();
	if (Gym.getTotalMoneyEarned() < salary) {
	    Gym.updateTotalMoneySpent(getSalary());
	} else {
	    throw new ReceiveSalaryException();
	}
    }

    public void printTrainingExcercises() {
	listOfExcercises = WeightLiftExcercise.listOfTrainingExcercises();
	for (String exc : listOfExcercises) {
	    LOG.log(Level.INFO, exc);
	}
    }

    public void printWarmUpExcercises() {
	listOfExcercises = WeightLiftExcercise.listOfWarmUpExcercises();
	for (String exc : listOfExcercises) {
	    LOG.log(Level.INFO, exc);
	}
    }
}
