package com.solvd.gym.data;

import com.solvd.gym.exceptionContainer.NameContainNumberException;
import com.solvd.gym.exceptionContainer.NullNameException;

public class ClientGym extends Client{

	public ClientGym(int id, String name) throws NullNameException, NameContainNumberException {
		super(id, name);
	}
	
	public final void pick5kg(int weight){
		WeightStorage.pick10kg(weight);
	}
	
	public final void pick10kg(int weight){
		WeightStorage.pick10kg(weight);
	}

	public final void pick15kg(int weight){
		WeightStorage.pick15kg(weight);
	}
	
	public final void pick20kg(int weight){
		WeightStorage.pick20kg(weight);
	}
	
	public final void leave5kg(int weight) {
		WeightStorage.leave5kg(weight);
	}
	
	public final void leave10kg(int weight) {
		WeightStorage.leave10kg(weight);
	}
	
	public final void leave15kg(int weight) {
		WeightStorage.leave15kg(weight);
	}
	
	public final void leave20kg(int weight) {
		WeightStorage.leave20kg(weight);
	}
}
