package com.solvd.gym.data;

import java.util.ArrayList;
import java.util.List;

public enum YogaExcercise {
    MOUNTAIN("back"), PLANK("abdomen"), EASY_SEAT("legs"), HERO("abdomen"), DONWARD_FACING_DOG("legs");

    private String strechs;
    private static List<String> listOfExcercises = new ArrayList<>();

    private YogaExcercise(String strechs) {
	this.strechs = strechs;
    }

    public String getStrechs() {
	return strechs;
    }

    public static List<String> listOfExcercises() {
	listOfExcercises.clear();
	for (YogaExcercise w : YogaExcercise.values()) {
	    listOfExcercises.add(w.name());
	}
	return listOfExcercises;
    }

    public static List<String> listOfLegStrechExcercises() {
	listOfExcercises.clear();
	for (YogaExcercise w : YogaExcercise.values()) {
	    if (w.strechs == "legs") {
		listOfExcercises.add(w.name());
	    }
	}
	return listOfExcercises;
    }

    public static List<String> listOfBackStrechExcercises() {
	listOfExcercises.clear();
	for (YogaExcercise w : YogaExcercise.values()) {
	    if (w.strechs == "back") {
		listOfExcercises.add(w.name());
	    }
	}
	return listOfExcercises;
    }
}
