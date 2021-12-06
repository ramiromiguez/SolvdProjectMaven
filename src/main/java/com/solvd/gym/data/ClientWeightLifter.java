package com.solvd.gym.data;

import com.solvd.gym.exception_container.NameContainNumberException;
import com.solvd.gym.exception_container.NullNameException;

public class ClientWeightLifter extends Client {

    public ClientWeightLifter(int id, String name) throws NullNameException, NameContainNumberException {
	super(id, name);
	// TODO Auto-generated constructor stub
    }

//	public void listOfTrainingExcercise(List<WeightLiftExcercise> listOfTraningExcercise) {
//		for(WeightLiftExcercise w: WeightLiftExcercise.values()) {
//			if(w.getUsedIn() == "train") {
//				listOfTraningExcercise.add(w);
//			}
//		}
//	}
//	
//	public List<String> returnListTraining(List<String> listOftrainingExcercise) {
//		return listOftrainingExcercise;
//	}
//	
}
