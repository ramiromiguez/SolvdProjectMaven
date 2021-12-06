package com.solvd.gym.data;

import java.util.Objects;

import com.solvd.gym.interfaces.IInstructorInfo;
import com.solvd.gym.interfaces.IInstructorSalary;

public abstract class Instructor implements IInstructorInfo, IInstructorSalary {
    private int id;
    protected String name;
    protected int salary;
    protected int salaryEarned;

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