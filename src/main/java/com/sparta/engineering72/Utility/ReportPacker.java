package com.sparta.engineering72.Utility;

public class ReportPacker {

    int totalRabbits = 0;
    int maleRabbits = 0;
    int femaleRabbits = 0;
    int totalFoxes = 0;
    int maleFoxes = 0;
    int femaleFoxes = 0;
    int rabbitAgeDeaths = 0;
    int rabbitPreyDeaths = 0;
    int foxDeaths = 0;

    public ReportPacker(int totalRabbits, int maleRabbits, int femaleRabbits, int totalFoxes, int maleFoxes,
                        int femaleFoxes, int rabbitAgeDeaths, int rabbitPreyDeaths, int foxDeaths) {
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

    public int getTotalRabbits() {
        return totalRabbits;
    }

    public void setTotalRabbits(int totalRabbits) {
        this.totalRabbits = totalRabbits;
    }

    public int getFemaleRabbits() {
        return femaleRabbits;
    }

    public void setFemaleRabbits(int femaleRabbits) {
        this.femaleRabbits = femaleRabbits;
    }

    public int getMaleRabbits() {
        return maleRabbits;
    }

    public void setMaleRabbits(int maleRabbits) {
        this.maleRabbits = maleRabbits;
    }

    public int getTotalFoxes() {
        return totalFoxes;
    }

    public void setTotalFoxes(int totalFoxes) {
        this.totalFoxes = totalFoxes;
    }

    public int getMaleFoxes() {
        return maleFoxes;
    }

    public void setMaleFoxes(int maleFoxes) {
        this.maleFoxes = maleFoxes;
    }

    public int getFemaleFoxes() {
        return femaleFoxes;
    }

    public void setFemaleFoxes(int femaleFoxes) {
        this.femaleFoxes = femaleFoxes;
    }

    public int getRabbitAgeDeaths() {
        return rabbitAgeDeaths;
    }

    public void setRabbitAgeDeaths(int rabbitAgeDeaths) {
        this.rabbitAgeDeaths = rabbitAgeDeaths;
    }

    public int getRabbitPreyDeaths() {
        return rabbitPreyDeaths;
    }

    public void setRabbitPreyDeaths(int rabbitPreyDeaths) {
        this.rabbitPreyDeaths = rabbitPreyDeaths;
    }

    public int getFoxDeaths() {
        return foxDeaths;
    }

    public void setFoxDeaths(int foxDeaths) {
        this.foxDeaths = foxDeaths;
    }
}
