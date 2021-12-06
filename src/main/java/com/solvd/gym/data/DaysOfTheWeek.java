package com.solvd.gym.data;

import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum DaysOfTheWeek {
    MONDAY(true), TUSDAY(true), WENSDAY(true), THURSDAY(true), FRIDAY(true), SATURDAY(true), SUNDAY(false);

    private boolean isOpen;
    private final static Logger LOG = Logger.getLogger(CollectionsAdministrator.class.getName());

    private DaysOfTheWeek(boolean isOpen) {
	this.isOpen = isOpen;
    }

    public boolean getIsOpen() {
	return isOpen;
    }

    @Override
    public String toString() {
	if (isOpen) {
	    return "The day " + this.name().toLowerCase() + " the gym is open";

	} else {
	    return "On " + this.name().toLowerCase() + " the gym is not open";
	}
    }

    public static void isOpen(DaysOfTheWeek day, Predicate<DaysOfTheWeek> isIn) {
	boolean is = isIn.test(day);
	LOG.log(Level.INFO, "is the gym open " + is);
    }
}