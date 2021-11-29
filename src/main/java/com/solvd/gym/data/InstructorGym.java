package com.solvd.gym.data;


import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.exceptionContainer.ReceiveSalaryException;

public class InstructorGym extends Instructor {
	private static Set<InstructorGym> instructorGymSet = new HashSet<>();
	private final static Logger LOG = Logger.getLogger(InstructorGym.class.getName());
	
	public InstructorGym(int id, String name, int salary) {
		super(id, name, salary);
	}
	
	@Override
	public final void receiveSalary() throws ReceiveSalaryException{
		salaryEarned =+ getSalary();
			if(Gym.getTotalMoneyEarned() < salary) {
				Gym.updateTotalMoneySpent(getSalary());
			}
			else{
				throw new ReceiveSalaryException();
			}
		}
	
	public static final void eliminateInstructorGym(InstructorGym instructorGym) {
		eliminateFromTheCollectionInstructorGym(instructorGym);
		instructorGym = null;
	}

	public static void addToTheCollectionInstructorGym(InstructorGym instructorGym) {
		if(instructorGymSet.contains(instructorGym)) {
			LOG.log(Level.WARNING, instructorGym.getName() +" is already on the Set");
		}
		else {
			instructorGymSet.add(instructorGym);
			addToTheCollectionInstructor(instructorGym);
		}
		
	}

	private static final void eliminateFromTheCollectionInstructorGym(InstructorGym instructorGym) {
		if(instructorGymSet.contains(instructorGym)) {
			instructorGymSet.remove(instructorGym);
			eliminateFromTheCollectionInstructor(instructorGym);
		}
		else {
			return;
		}
	}
	
	public static boolean isInTheCollectionInstructorGym(InstructorGym instructorGym) {
		boolean isIn = false;
		if(instructorGymSet.contains(instructorGym)) {
			isIn = true;
		}
		return isIn;
	}

	public static void printTheCollectionInstructorGym() {
		if(instructorGymSet.size() >= 1) {
			for(InstructorGym instructorGym: instructorGymSet) {
				LOG.log(Level.INFO, instructorGym.toString());
			}
		}
		else {
			LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
		}
	}
}
