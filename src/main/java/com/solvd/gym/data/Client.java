package com.solvd.gym.data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.solvd.gym.exceptionContainer.NameContainNumberException;
import com.solvd.gym.exceptionContainer.NullNameException;

public abstract class Client implements IClientInfo {
	private int id;
	private String name;
	private int feesPaid;
	
	public Client(int id, String name) throws NullNameException, NameContainNumberException{
		feesPaid = 0;
		this.id = id;
		
		boolean found = false;
		StringBuilder sb = new StringBuilder();
	    for(char c : name.toCharArray()){
		        if(Character.isDigit(c)){
		            sb.append(c);
		            found = true;
		        } else if(found){
		            break;                
		        }
		    }
		
		if(name == null || name.trim().isEmpty()) {
            throw new NullNameException();
		}
		if(found == true){
			throw new NameContainNumberException(); 
		}
		else {
			this.name = name;
		}
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(int feesPaid) {
		this.feesPaid = feesPaid;
	}

	public void payFees(int fees) {
		feesPaid += fees;
		Gym.updateTOtalMoneyEarned(feesPaid);
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", feesPaid=" + feesPaid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(feesPaid, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return feesPaid == other.feesPaid && id == other.id && Objects.equals(name, other.name);
	}

}
