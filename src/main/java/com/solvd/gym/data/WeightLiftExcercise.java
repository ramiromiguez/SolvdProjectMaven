package com.solvd.gym.data;

import java.util.ArrayList;
import java.util.List;

public enum WeightLiftExcercise {
    SNATCH("competition"), CLEAN_AND_JERK("competetion"), GOOD_MORNING("train"), FRONT_SQUAT("train"), SQUAT("train"),
    JUMP("warm up"), PUSH_UPS("warm up");

    private String usedIn;
    private static List<String> listOfExcercises = new ArrayList<>();

    private WeightLiftExcercise(String usedIn) {
	this.usedIn = usedIn;
    }

    public String getUsedIn() {
	return usedIn;
    }

    public static List<String> listOfExcercises() {
	listOfExcercises.clear();
	for (WeightLiftExcercise w : WeightLiftExcercise.values()) {
	    listOfExcercises.add(w.name());
	}
	return listOfExcercises;
    }

//    public static List<String> listOfCompetitionExcercises() {
//	listOfExcercises.clear();
//	Stream.of(WeightLiftExcercise.values() -> {usedIn==})
//	}
//    }

    public static List<String> listOfTrainingExcercises() {
	listOfExcercises.clear();
	for (WeightLiftExcercise w : WeightLiftExcercise.values()) {
	    if (w.usedIn == "train") {
		listOfExcercises.add(w.name());
	    }
	}
	return listOfExcercises;
    }

    public static List<String> listOfWarmUpExcercises() {
	listOfExcercises.clear();
	for (WeightLiftExcercise w : WeightLiftExcercise.values()) {
	    if (w.usedIn == "competition") {
		listOfExcercises.add(w.name());
	    }
	}
	return listOfExcercises;
    }

}