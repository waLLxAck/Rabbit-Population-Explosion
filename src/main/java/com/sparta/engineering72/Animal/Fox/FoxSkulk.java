package com.sparta.engineering72.Animal.Fox;


import java.util.ArrayList;

public class FoxSkulk {
    public static ArrayList<FemaleFox> femaleFoxList = new ArrayList<>();
    public static ArrayList<MaleFox> maleFoxList = new ArrayList<>();

    public static ArrayList<FemaleFox> getFemaleFoxList() {
        return femaleFoxList;
    }

    public static ArrayList<MaleFox> getMaleFoxList() {
        return maleFoxList;
    }

    public int getFoxPopulationSize(){
        return getFemaleFoxPopulation() + getMaleFoxPopulation();
    }

    public int getFemaleFoxPopulation(){
        int femalePopulation = 0;
        for(FemaleFox femaleFox : femaleFoxList){
            femalePopulation += femaleFox.getCount();
        }
        return femalePopulation;
    }

    public int getMaleFoxPopulation(){
        int malePopulation = 0;
        for(MaleFox maleFox : maleFoxList){
            malePopulation += maleFox.getCount();
        }
        return malePopulation;
    }

    public void addFemaleFox(FemaleFox femaleFox) {
        femaleFoxList.add(femaleFox);
    }

    public void addMaleFox(MaleFox maleFox) {
        maleFoxList.add(maleFox);
    }

    public void removeFemaleFox(FemaleFox femaleFox) {
        femaleFoxList.remove(femaleFox);
    }

    public void removeMaleFox(MaleFox maleFox) {
        maleFoxList.remove(maleFox);
    }
}
