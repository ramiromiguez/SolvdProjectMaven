package com.solvd.gym.data;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.solvd.gym.exceptionContainer.QuantityLeaveUnavailableException;
import com.solvd.gym.exceptionContainer.QuantityUnavailableException;

public class WeightStorage {
	private static int fiveKgQuantity = 20;
	private static int tenKgQuantity = 20;
	private static int fifteenKgQuantity = 20;
	private static int twentyKgQuantity = 20;
	private static int quantity;
	private final static Logger LOG = Logger.getLogger(WeightStorage.class.getName());
	
	public WeightStorage() {
	}

	public static int getFiveKgQuantity() {
		return fiveKgQuantity;
	}

	public static void setFiveKgQuantity(int fiveKgQuantity) {
		WeightStorage.fiveKgQuantity = fiveKgQuantity;
	}

	public static int getTenKgQuantity() {
		return tenKgQuantity;
	}

	public static void setTenKgQuantity(int tenKg) {
		WeightStorage.tenKgQuantity = tenKg;
	}

	public static int getFifteenKgQuantity() {
		return fifteenKgQuantity;
	}

	public static void setFifteenKgQuantity(int fifteenKg) {
		WeightStorage.fifteenKgQuantity = fifteenKg;
	}

	public static int getTwentyKgQuantity() {
		return twentyKgQuantity;
	}

	public static void setTwentyKgQuantity(int twentyKg) {
		WeightStorage.twentyKgQuantity = twentyKg;
	}

	public static int getQuantity() {
		return quantity;
	}

	public static void setQuantity(int quantity) {
		WeightStorage.quantity = quantity;
	}

	public static void pick5kg(int quantity) throws QuantityUnavailableException {
		try {
			if (WeightStorage.fiveKgQuantity >= quantity) {
				WeightStorage.setFiveKgQuantity(WeightStorage.getFiveKgQuantity() - quantity);
				LOG.log(Level.INFO,"You have just picked " + quantity + "plates of 5 kg");
				return;
			}
			if (WeightStorage.fiveKgQuantity < quantity) {
				throw new QuantityUnavailableException();
			}
		} catch (QuantityUnavailableException e) {
			LOG.log(Level.WARNING, e.getMessage());
		}
	}

	public static void leave5kg(int quantity) {
		try {
			if(WeightStorage.fiveKgQuantity >= quantity) {
				WeightStorage.setFiveKgQuantity(quantity + WeightStorage.getFiveKgQuantity());
			}
			else{
				throw new QuantityLeaveUnavailableException();
			}
		}
		catch(QuantityLeaveUnavailableException e){
			LOG.log(Level.WARNING, e.getMessage());
		}
	}

	public static void pick10kg(int tenKg) {
		try {
			if (WeightStorage.tenKgQuantity >= quantity) {
				WeightStorage.setTenKgQuantity(WeightStorage.getTenKgQuantity() - quantity);
				LOG.log(Level.INFO, "You have just picked " + quantity + "plates of 10 kg");
				return;
			}
			if (WeightStorage.tenKgQuantity < quantity) {
				throw new QuantityUnavailableException();
			}
		} catch (QuantityUnavailableException e) {
			LOG.log(Level.WARNING, e.getMessage());
		}
	}
	
	public static void leave10kg(int quantity) {
		try {
			if(WeightStorage.tenKgQuantity >= quantity) {
				WeightStorage.setTenKgQuantity(quantity + WeightStorage.getTenKgQuantity());
			}
			else{
				throw new QuantityLeaveUnavailableException();
			}
		}
		catch(QuantityLeaveUnavailableException e){
			LOG.log(Level.WARNING, e.getMessage());
		}
	}
	
	public static void pick15kg(int tenKg) {
		try {
			if (WeightStorage.fifteenKgQuantity >= quantity) {
				WeightStorage.setFifteenKgQuantity(WeightStorage.getFifteenKgQuantity() - quantity);
				LOG.log(Level.INFO, "You have just picked " + quantity + "plates of 15 kg");
				return;
			}
			if (WeightStorage.fifteenKgQuantity < quantity) {
				throw new QuantityUnavailableException();
			}
		} catch (QuantityUnavailableException e) {
			LOG.log(Level.WARNING, e.getMessage());
		}
	}
	
	public static void leave15kg(int quantity) {
		try {
			if(WeightStorage.fifteenKgQuantity >= quantity) {
				WeightStorage.setFifteenKgQuantity(quantity + WeightStorage.getFifteenKgQuantity());
			}
			else{
				throw new QuantityLeaveUnavailableException();
			}
		}
		catch(QuantityLeaveUnavailableException e){
			LOG.log(Level.WARNING, e.getMessage());
		}
	}
	
	public static void pick20kg(int tenKg) {
		try {
			if (WeightStorage.twentyKgQuantity >= quantity) {
				WeightStorage.setTwentyKgQuantity(WeightStorage.getTwentyKgQuantity() - quantity);
				LOG.log(Level.INFO, "You have just picked " + quantity + "plates of 20 kg");
				return;
			}
			if (WeightStorage.twentyKgQuantity < quantity) {
				throw new QuantityUnavailableException();
			}
		} catch (QuantityUnavailableException e) {
			LOG.log(Level.WARNING, e.getMessage());
		}
	}
	
	public static void leave20kg(int quantity) {
		try {
			if(WeightStorage.twentyKgQuantity >= quantity) {
				WeightStorage.setTwentyKgQuantity(quantity + WeightStorage.getTwentyKgQuantity());
			}
			else{
				throw new QuantityLeaveUnavailableException();
			}
		}
		catch(QuantityLeaveUnavailableException e){
			LOG.log(Level.WARNING, e.getMessage());
		}
	}
}