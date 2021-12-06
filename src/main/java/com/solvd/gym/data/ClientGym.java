package com.solvd.gym.data;

import com.solvd.gym.exception_container.NameContainNumberException;
import com.solvd.gym.exception_container.NullNameException;
import com.solvd.gym.exception_container.QuantityLeaveUnavailableException;
import com.solvd.gym.exception_container.QuantityUnavailableException;

public class ClientGym extends Client {

    public ClientGym(int id, String name) throws NullNameException, NameContainNumberException {
	super(id, name);
    }

    public final void pick5kg(int weight) throws QuantityUnavailableException {
	WeightStorage.pick5kg(weight);
    }

    public final void pick10kg(int weight) throws QuantityUnavailableException {
	WeightStorage.pick10kg(weight);
    }

    public final void pick15kg(int weight) throws QuantityUnavailableException {
	WeightStorage.pick15kg(weight);
    }

    public final void pick20kg(int weight) throws QuantityUnavailableException {
	WeightStorage.pick20kg(weight);
    }

    public final void leave5kg(int weight) throws QuantityLeaveUnavailableException {
	WeightStorage.leave5kg(weight);
    }

    public final void leave10kg(int weight) throws QuantityLeaveUnavailableException {
	WeightStorage.leave10kg(weight);
    }

    public final void leave15kg(int weight) throws QuantityLeaveUnavailableException {
	WeightStorage.leave15kg(weight);
    }

    public final void leave20kg(int weight) throws QuantityLeaveUnavailableException {
	WeightStorage.leave20kg(weight);
    }
}
