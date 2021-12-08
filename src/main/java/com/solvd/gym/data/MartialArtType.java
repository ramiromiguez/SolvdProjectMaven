package com.solvd.gym.data;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MartialArtType {
    KARATE("easy", 4, "kicks"), BOX("medium", 5, "punchs"), KICKBOXING("hard", 6, "speed"),
    JUDO("hard", 7, "submission"), KUN_FU("hard", 6, "knees"), JU_JITSU("easy", 8, "resistance");

    private String difficulty;
    private long damage;
    private String especialization;
    Logger LOG = Logger.getLogger(MartialArtType.class.getName());

    private MartialArtType(String difficulty, long damage, String especialization) {
	this.difficulty = difficulty;
	this.damage = damage;
	this.especialization = especialization;
    }

    public String getDifficulty() {
	return difficulty;
    }

    public long getDamage() {
	return damage;
    }

    public String getEspecialization() {
	return especialization;
    }

    public List<MartialArtType> getHardMartialArts() {
	return Stream.of(MartialArtType.values()).filter(martial -> martial.difficulty == "hard")
		.collect(Collectors.toList());
    }

    public void getMostPowerfullMartial() {
	Optional<MartialArtType> var = Stream.of(MartialArtType.values())
		.max(Comparator.comparing(martial -> martial.damage));
	if (var.isPresent()) {
	    LOG.log(Level.INFO, "The most powerfull martial art is " + var.get());
	}

    }
}
