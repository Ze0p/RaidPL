package com.atosss.raidpl.settings;

public class RaidSettings {
    private String difficulty;
    private int maxPlayers;

    // Constructors, getters, and setters
    public RaidSettings(String difficulty, int maxPlayers) {
        this.difficulty = difficulty;
        this.maxPlayers = maxPlayers;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}
