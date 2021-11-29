package com.solvd.gym.data;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.interfaces.IInstructorInfo;
import com.solvd.gym.interfaces.IInstructorSalary;

public abstract class Instructor implements IInstructorInfo, IInstructorSalary{
	private int id;
	protected String name;
	protected int salary;
	protected int salaryEarned;
	protected static Queue<Instructor> instructorQueue = new LinkedList<>();
	private final static Logger LOG = Logger.getLogger(Instructor.class.getName());
	
	public Instructor(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getSalaryEarned() {
		return salaryEarned;
	}
	
	public static Queue<Instructor> getCollection() {
		return instructorQueue;
	}
	
	protected static final void addToTheCollectionInstructor(Instructor instructor) {
		if(isInTheCollectionInstructor(instructor)) {
			return;
		}
		else {
			instructorQueue.add(instructor);
			Gym.addInstructorToTheTotalCollection(instructor);
		}
		
	}

	protected static final void eliminateFromTheCollectionInstructor(Instructor instructor) {
		if(isInTheCollectionInstructor(instructor)) {
			instructorQueue.remove(instructor);
		}
		else {
			return;
		}
	}
	
	public static boolean isInTheCollectionInstructor(Instructor instructor) {
		boolean isIn = false;
		if(instructorQueue.contains(instructor)) {
			isIn = true;
		}
		return isIn;
	}

	public static void printTheCollectionInstrcutor() {
		if(instructorQueue.size() >= 1) {
			for(Instructor instructor: instructorQueue) {
				LOG.log(Level.INFO, instructor.toString());
			}
		}
		else {
			LOG.log(Level.WARNING, "the Collection that you are trying to print is empty");
		}
	}
	
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", salary=" + salary + ", salaryEarned=" + salaryEarned
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, salary, salaryEarned);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instructor other = (Instructor) obj;
		return id == other.id && Objects.equals(name, other.name) && salary == other.salary
				&& salaryEarned == other.salaryEarned;
	}
	
	
 }