package com.atosss.raidpl.raid;

import com.atosss.raidpl.settings.RaidSettings;

public class Raid {
    private final String region;
    private int numberOfWaves;
    private int waveDuration;
    private int waitTime;
    private RaidSettings settings;

    // Constructor
    public Raid(String region, int numberOfWaves, int waveDuration, int waitTime, RaidSettings settings) {
        this.region = region;
        this.numberOfWaves = numberOfWaves;
        this.waveDuration = waveDuration;
        this.waitTime = waitTime;
        this.settings = settings;
    }

    // Getters and Setters
    public String getRegion() {
        return region;
    }

    public int getNumberOfWaves() {
        return numberOfWaves;
    }

    public void setNumberOfWaves(int numberOfWaves) {
        this.numberOfWaves = numberOfWaves;
    }

    public int getWaveDuration() {
        return waveDuration;
    }

    public void setWaveDuration(int waveDuration) {
        this.waveDuration = waveDuration;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public RaidSettings getSettings() {
        return settings;
    }

    public void setSettings(RaidSettings settings) {
        this.settings = settings;
    }
}
