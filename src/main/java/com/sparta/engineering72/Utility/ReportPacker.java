package com.sparta.engineering72.Utility;

public class ReportPacker {

    long totalRabbits = 0;
    long maleRabbits = 0;
    long femaleRabbits = 0;
    long totalFoxes = 0;
    long maleFoxes = 0;
    long femaleFoxes = 0;
    long rabbitAgeDeaths = 0;
    long rabbitPreyDeaths = 0;
    long foxDeaths = 0;

    public ReportPacker(long totalRabbits, long maleRabbits, long femaleRabbits, long totalFoxes, long maleFoxes,
                        long femaleFoxes, long rabbitAgeDeaths, long rabbitPreyDeaths, long foxDeaths) {
        this.totalRabbits = totalRabbits;
        this.femaleRabbits = femaleRabbits;
        this.maleRabbits = maleRabbits;
        this.totalFoxes = totalFoxes;
        this.maleFoxes = maleFoxes;
        this.femaleFoxes = femaleFoxes;
        this.rabbitAgeDeaths = rabbitAgeDeaths;
        this.rabbitPreyDeaths = rabbitPreyDeaths;
        this.foxDeaths = foxDeaths;
    }

    public long getTotalRabbits() {
        return totalRabbits;
    }

    public void setTotalRabbits(long totalRabbits) {
        this.totalRabbits = totalRabbits;
    }

    public long getFemaleRabbits() {
        return femaleRabbits;
    }

    public void setFemaleRabbits(long femaleRabbits) {
        this.femaleRabbits = femaleRabbits;
    }

    public long getMaleRabbits() {
        return maleRabbits;
    }

    public void setMaleRabbits(long maleRabbits) {
        this.maleRabbits = maleRabbits;
    }

    public long getTotalFoxes() {
        return totalFoxes;
    }

    public void setTotalFoxes(long totalFoxes) {
        this.totalFoxes = totalFoxes;
    }

    public long getMaleFoxes() {
        return maleFoxes;
    }

    public void setMaleFoxes(long maleFoxes) {
        this.maleFoxes = maleFoxes;
    }

    public long getFemaleFoxes() {
        return femaleFoxes;
    }

    public void setFemaleFoxes(long femaleFoxes) {
        this.femaleFoxes = femaleFoxes;
    }

    public long getRabbitAgeDeaths() {
        return rabbitAgeDeaths;
    }

    public void setRabbitAgeDeaths(long rabbitAgeDeaths) {
        this.rabbitAgeDeaths = rabbitAgeDeaths;
    }

    public long getRabbitPreyDeaths() {
        return rabbitPreyDeaths;
    }

    public void setRabbitPreyDeaths(long rabbitPreyDeaths) {
        this.rabbitPreyDeaths = rabbitPreyDeaths;
    }

    public long getFoxDeaths() {
        return foxDeaths;
    }

    public void setFoxDeaths(long foxDeaths) {
        this.foxDeaths = foxDeaths;
    }
}
