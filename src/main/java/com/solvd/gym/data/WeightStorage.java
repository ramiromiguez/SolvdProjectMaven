package com.solvd.gym.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.solvd.gym.exception_container.QuantityLeaveUnavailableException;
import com.solvd.gym.exception_container.QuantityUnavailableException;

public enum WeightStorage {
    FIVE_KG(20), TEN_KG(20), FIFTEEN_KG(20), TWENTY_KG(20);

    private int quantity;
    private final static List<WeightStorage> LISTWITHFREEWEIGHTS = new ArrayList<>();
    private final static Logger LOG = Logger.getLogger(WeightStorage.class.getName());

    WeightStorage(int quantity) {
	this.quantity = quantity;
    }

    public static List<WeightStorage> getFreeWeightList() {
	LISTWITHFREEWEIGHTS.clear();
	for (WeightStorage w : LISTWITHFREEWEIGHTS) {
	    if (w.quantity >= 1) {
		LISTWITHFREEWEIGHTS.add(w);
	    }
	}
	return LISTWITHFREEWEIGHTS;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public void getAvailableWeights() {
	List<WeightStorage> var = Stream.of(WeightStorage.values()).filter(weight -> weight.quantity > 0)
		.sorted(Comparator.comparing(weight -> weight.quantity)).collect(Collectors.toList());
	var.forEach(WeightStorage -> LOG.log(Level.INFO,
		"For " + WeightStorage.name() + " there are disponible " + WeightStorage.quantity));
	LOG.log(Level.INFO, "Disponible weights quantity: " + var);
    }

    private static BiFunction<Integer, Integer, Integer> minusWeight = (weightTotal,
	    weightPicked) -> (weightTotal - weightPicked);

    private static int weightPickedMinusTotalWeight(int weightTotal, int weightPicked) {
	int difference = minusWeight.apply(weightTotal, weightPicked);
	return difference;
    }

    public static void pick5kg(int quantity) throws QuantityUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.FIVE_KG.getQuantity(), quantity);
	if (result >= 0) {
	    WeightStorage.FIVE_KG.setQuantity(result);
	    LOG.log(Level.INFO, "You have just picked " + quantity + " plates of 5 kg");
	} else {
	    throw new QuantityUnavailableException();
	}
    }

    public static void leave5kg(int quantity) throws QuantityLeaveUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.FIVE_KG.getQuantity(), quantity);
	if (result < 0) {
	    throw new QuantityLeaveUnavailableException();
	} else {
	    WeightStorage.FIVE_KG.setQuantity(result);
	    LOG.log(Level.INFO, "You have just left " + quantity + " plates of 5 kg");
	}
    }

    public static void pick10kg(int quantity) throws QuantityUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.TEN_KG.getQuantity(), quantity);
	if (result >= 0) {
	    WeightStorage.TEN_KG.setQuantity(result);
	    LOG.log(Level.INFO, "You have just picked " + quantity + " plates of 10 kg");
	} else {
	    throw new QuantityUnavailableException();
	}
    }

    public static void leave10kg(int quantity) throws QuantityLeaveUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.TEN_KG.getQuantity(), quantity);
	if (result < 0) {
	    throw new QuantityLeaveUnavailableException();
	} else {
	    WeightStorage.TEN_KG.setQuantity(result);
	    LOG.log(Level.INFO, "You have just left " + quantity + " plates of 10 kg");
	}
    }

    public static void pick15kg(int quantity) throws QuantityUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.FIFTEEN_KG.getQuantity(), quantity);
	if (result >= 0) {
	    WeightStorage.FIFTEEN_KG.setQuantity(result);
	    LOG.log(Level.INFO, "You have just picked " + quantity + " plates of 15 kg");
	} else {
	    throw new QuantityUnavailableException();
	}
    }

    public static void leave15kg(int quantity) throws QuantityLeaveUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.FIFTEEN_KG.getQuantity(), quantity);
	if (result < 0) {
	    throw new QuantityLeaveUnavailableException();
	} else {
	    WeightStorage.FIFTEEN_KG.setQuantity(result);
	    LOG.log(Level.INFO, "You have just left " + quantity + " plates of 15 kg");
	}
    }

    public static void pick20kg(int quantity) throws QuantityUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.TWENTY_KG.getQuantity(), quantity);
	if (result >= 0) {
	    WeightStorage.TWENTY_KG.setQuantity(result);
	    LOG.log(Level.INFO, "You have just picked " + quantity + " plates of 20 kg");
	} else {
	    throw new QuantityUnavailableException();
	}
    }

    public static void leave20kg(int quantity) throws QuantityLeaveUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.TWENTY_KG.getQuantity(), quantity);
	if (result < 0) {
	    throw new QuantityLeaveUnavailableException();
	} else {
	    WeightStorage.TWENTY_KG.setQuantity(result);
	    LOG.log(Level.INFO, "You have just left " + quantity + " plates of 20 kg");
	}
    }
}