package com.solvd.gym.data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static int getFIVE_KGQuantity() {
	return WeightStorage.FIVE_KG.quantity;
    }

    public static void setFIVE_KGQuantity(int FIVE_KGQuantity) {
	WeightStorage.FIVE_KG.quantity = FIVE_KGQuantity;
    }

    public static int getTEN_KGQuantity() {
	return WeightStorage.TEN_KG.quantity;
    }

    public static void setTEN_KGQuantity(int TEN_KG) {
	WeightStorage.TEN_KG.quantity = TEN_KG;
    }

    public static int getFIFTEEN_KGQuantity() {
	return WeightStorage.FIFTEEN_KG.quantity;
    }

    public static void setFIFTEEN_KGQuantity(int FIFTEEN_KG) {
	WeightStorage.FIFTEEN_KG.quantity = FIFTEEN_KG;
    }

    public static int getTWENTY_KGQuantity() {
	return WeightStorage.TWENTY_KG.quantity;
    }

    public static void setTWENTY_KGQuantity(int TWENTY_KG) {
	WeightStorage.TWENTY_KG.quantity = TWENTY_KG;
    }

    private static BiFunction<Integer, Integer, Integer> minusWeight = (weightTotal,
	    weightPicked) -> (weightTotal - weightPicked);

    private static int weightPickedMinusTotalWeight(int weightTotal, int weightPicked) {
	int difference = minusWeight.apply(weightTotal, weightPicked);
	return difference;
    }

    public static void pick5kg(int quantity) throws QuantityUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.getFIVE_KGQuantity(), quantity);
	if (result >= 0) {
	    WeightStorage.setFIVE_KGQuantity(result);
	    LOG.log(Level.INFO, "You have just picked " + quantity + " plates of 5 kg");
	} else {
	    throw new QuantityUnavailableException();
	}
    }

    public static void leave5kg(int quantity) throws QuantityLeaveUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.getFIVE_KGQuantity(), quantity);
	if (result < 0) {
	    throw new QuantityLeaveUnavailableException();
	} else {
	    WeightStorage.setFIVE_KGQuantity(result);
	    LOG.log(Level.INFO, "You have just left " + quantity + " plates of 5 kg");
	}
    }

    public static void pick10kg(int quantity) throws QuantityUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.getTEN_KGQuantity(), quantity);
	if (result >= 0) {
	    WeightStorage.setTEN_KGQuantity(result);
	    LOG.log(Level.INFO, "You have just picked " + quantity + " plates of 10 kg");
	} else {
	    throw new QuantityUnavailableException();
	}
    }

    public static void leave10kg(int quantity) throws QuantityLeaveUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.getTEN_KGQuantity(), quantity);
	if (result < 0) {
	    throw new QuantityLeaveUnavailableException();
	} else {
	    WeightStorage.setTEN_KGQuantity(result);
	    LOG.log(Level.INFO, "You have just left " + quantity + " plates of 10 kg");
	}
    }

    public static void pick15kg(int quantity) throws QuantityUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.getFIFTEEN_KGQuantity(), quantity);
	if (result >= 0) {
	    WeightStorage.setFIFTEEN_KGQuantity(result);
	    LOG.log(Level.INFO, "You have just picked " + quantity + " plates of 15 kg");
	} else {
	    throw new QuantityUnavailableException();
	}
    }

    public static void leave15kg(int quantity) throws QuantityLeaveUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.getFIFTEEN_KGQuantity(), quantity);
	if (result < 0) {
	    throw new QuantityLeaveUnavailableException();
	} else {
	    WeightStorage.setFIFTEEN_KGQuantity(result);
	    LOG.log(Level.INFO, "You have just left " + quantity + " plates of 15 kg");
	}
    }

    public static void pick20kg(int quantity) throws QuantityUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.getTWENTY_KGQuantity(), quantity);
	if (result >= 0) {
	    WeightStorage.setTWENTY_KGQuantity(result);
	    LOG.log(Level.INFO, "You have just picked " + quantity + " plates of 20 kg");
	} else {
	    throw new QuantityUnavailableException();
	}
    }

    public static void leave20kg(int quantity) throws QuantityLeaveUnavailableException {
	int result = weightPickedMinusTotalWeight(WeightStorage.getTWENTY_KGQuantity(), quantity);
	if (result < 0) {
	    throw new QuantityLeaveUnavailableException();
	} else {
	    WeightStorage.setTWENTY_KGQuantity(result);
	    LOG.log(Level.INFO, "You have just left " + quantity + " plates of 20 kg");
	}
    }
}