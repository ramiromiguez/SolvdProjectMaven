package com.solvd.gym.data;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.exceptionContainer.ReceiveSalaryException;

public class InstructorYoga extends Instructor {
	private static Set<InstructorYoga> instructorYogaSet = new HashSet<>();
	private final static Logger LOG = Logger.getLogger(InstructorYoga.class.getName());

	public InstructorYoga(int id, String name, int salary) {
		super(id, name, salary);
	}

	//need to complete
	@Override
	public final void receiveSalary() throws ReceiveSalaryException {
		
	}
	
	public static final void eliminateYogaInstructor(InstructorYoga instructorYoga) {
		eliminateFromTheCollectionYogaInstructor(instructorYoga);
		instructorYoga = null;
	}

	public static void addToTheCollectionYogaInstrcuctor(InstructorYoga instructorYoga) {
		if(isInTheCollectionYogaInstrcuctor(instructorYoga)) {
			LOG.log(Level.WARNING, instructorYoga.getName() +" is already on the Set");
		}
		else {
			instructorYogaSet.add(instructorYoga);
			addToTheCollectionInstructor(instructorYoga);
		}
		
	}

	private static final void eliminateFromTheCollectionYogaInstructor(InstructorYoga instructorYoga) {
		if(isInTheCollectionYogaInstrcuctor(instructorYoga)) {
			instructorYogaSet.remove(instructorYoga);
			eliminateFromTheCollectionInstructor(instructorYoga);
		}
		else {
			return;
		}
	}
	
	public static boolean isInTheCollectionYogaInstrcuctor(InstructorYoga instructorYoga) {
		boolean isIn = false;
		if(instructorYogaSet.contains(instructorYoga)) {
			isIn = true;
		}
		return isIn;
	}

	public static void printTheCollectionYogaInstrcuctor() {
		if(instructorYogaSet.size() >= 1) {
			for(InstructorYoga instructorYoga: instructorYogaSet) {
				LOG.log(Level.INFO, instructorYoga.toString());
			}
		}
		else {
		LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
		}
	}
}

	


