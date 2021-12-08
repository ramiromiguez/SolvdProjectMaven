package com.solvd.gym.data;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public enum DaysOfTheWeek {
    MONDAY(true, 18), TUSDAY(true, 18), WENSDAY(true, 18), THURSDAY(true, 18), FRIDAY(true, 18), SATURDAY(true, 10),
    SUNDAY(false, 0);

    private boolean isOpen;
    private int hoursOpen;
    private final static Logger LOG = Logger.getLogger(CollectionsAdministrator.class.getName());

    private DaysOfTheWeek(boolean isOpen, int hoursOpen) {
	this.isOpen = isOpen;
	this.hoursOpen = hoursOpen;
    }

    public boolean getIsOpen() {
	return isOpen;
    }

    public int getHoursOpen() {
	return hoursOpen;
    }

    public static void isOpen(DaysOfTheWeek day, Predicate<DaysOfTheWeek> isIn) {
	boolean is = isIn.test(day);
	LOG.log(Level.INFO, "is the gym open " + is);
    }

    public void getLeesHoursOpen() {
	Optional<DaysOfTheWeek> xd = Stream.of(DaysOfTheWeek.values()).filter(m -> m.isOpen == true)
		.min(Comparator.comparing(day -> day.hoursOpen));
	if (xd.isPresent()) {
	    LOG.log(Level.INFO, "The gym day where the gym is less hours open is " + xd.get());
	}
    }

}
