package com.solvd.gym.data;

public enum MartialArtType {
    KARATE("easy", 4), BOX("medium", 5), KICKBOXING("hard", 6);

    private String difficulty;
    private int damage;

    private MartialArtType(String difficulty, int damage) {
	this.difficulty = difficulty;
	this.damage = damage;
    }

    public String getDifficulty() {
	return difficulty;
    }

    public int getDamage() {
	return damage;
    }
}
