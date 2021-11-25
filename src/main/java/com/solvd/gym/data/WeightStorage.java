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

	public static void pick5kg(int quantity) throws QuantityUnavailableException{
			if (WeightStorage.getFiveKgQuantity() >= quantity) {
				WeightStorage.setFiveKgQuantity(WeightStorage.getFiveKgQuantity() - quantity);
				LOG.log(Level.INFO,"You have just picked " + quantity + " plates of 5 kg");
			}
			if (WeightStorage.getFiveKgQuantity() < quantity) {
				throw new QuantityUnavailableException();
			}
	}

	public static void leave5kg(int quantity) throws QuantityLeaveUnavailableException {
			if(WeightStorage.getFiveKgQuantity() >= quantity) {
				WeightStorage.setFiveKgQuantity(quantity + WeightStorage.getFiveKgQuantity());
				LOG.log(Level.INFO, "You have just leaved " + quantity + " plates of 5kg");
			}
			if(WeightStorage.getFiveKgQuantity() > quantity){
				throw new QuantityLeaveUnavailableException();
			}
	
	}

	public static void pick10kg(int quantity) throws QuantityUnavailableException {
		if (WeightStorage.getTenKgQuantity() >= quantity) {
			WeightStorage.setTenKgQuantity(WeightStorage.getTenKgQuantity() - quantity);
			LOG.log(Level.INFO,"You have just picked " + quantity + " plates of 10 kg");
		}
		if (WeightStorage.getTenKgQuantity() < quantity) {
			throw new QuantityUnavailableException();
		}
	}
	
	public static void leave10kg(int quantity) throws QuantityLeaveUnavailableException {
			if(WeightStorage.getTenKgQuantity() >= quantity) {
				WeightStorage.setTenKgQuantity(quantity + WeightStorage.getTenKgQuantity());
				LOG.log(Level.INFO, "You have just leaved " + quantity + " plates of 10kg");
			}
			if(WeightStorage.getTenKgQuantity() < quantity){
				throw new QuantityLeaveUnavailableException();
			}
	}
	
	public static void pick15kg(int quantity) throws QuantityUnavailableException {
		if (WeightStorage.getFifteenKgQuantity() >= quantity) {
			WeightStorage.setFifteenKgQuantity(WeightStorage.getFifteenKgQuantity() - quantity);
			LOG.log(Level.INFO,"You have just picked " + quantity + " plates of 15 kg");
		}
		if (WeightStorage.getFifteenKgQuantity() < quantity) {
			throw new QuantityUnavailableException();
		}
	}
	
	public static void leave15kg(int quantity) throws QuantityLeaveUnavailableException {
		if(WeightStorage.getFifteenKgQuantity() >= quantity) {
			WeightStorage.setFifteenKgQuantity(quantity + WeightStorage.getFifteenKgQuantity());
			LOG.log(Level.INFO, "You have just leaved " + quantity + " plates of 15kg");
		}
		if(WeightStorage.getFifteenKgQuantity() < quantity){
			throw new QuantityLeaveUnavailableException();
		}
	}
	
	public static void pick20kg(int quantity) throws QuantityUnavailableException {
		if (WeightStorage.getTwentyKgQuantity() >= quantity) {
			WeightStorage.setTwentyKgQuantity(WeightStorage.getTwentyKgQuantity() - quantity);
			LOG.log(Level.INFO,"You have just picked " + quantity + " plates of 20 kg");
		}
		if (WeightStorage.getTwentyKgQuantity() < quantity) {
			throw new QuantityUnavailableException();
		}
	}
	
	public static void leave20kg(int quantity) throws QuantityLeaveUnavailableException {
		if(WeightStorage.getTwentyKgQuantity() >= quantity) {
			WeightStorage.setTwentyKgQuantity(quantity + WeightStorage.getTwentyKgQuantity());
			LOG.log(Level.INFO, "You have just leaved " + quantity + " plates of 20kg");
		}
		if(WeightStorage.getTwentyKgQuantity() < quantity){
			throw new QuantityLeaveUnavailableException();
		}
	}
}