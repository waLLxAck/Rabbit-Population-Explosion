package com.sparta.engineering72;

import java.util.ArrayList;
import java.util.List;

public class RabbitFluffle {

    static ArrayList<FemaleRabbit> femaleRabbitList = new ArrayList<>();
    static ArrayList<MaleRabbit> maleRabbitList = new ArrayList<>();

    public static ArrayList<FemaleRabbit> getFemaleRabbitList() {
        return femaleRabbitList;
    }

    public static ArrayList<MaleRabbit> getMaleRabbitList() {
        return maleRabbitList;
    }

    public int getRabbitPopulationSize(){
        return getFemaleRabbitPopulation() + getMaleRabbitPopulation();
    }

    public int getFemaleRabbitPopulation(){
        int femalePopulation = 0;
        for(FemaleRabbit femaleRabbit : femaleRabbitList){
            femalePopulation += femaleRabbit.getCount();
        }
        return femalePopulation;
    }

    public int getMaleRabbitPopulation(){
        int malePopulation = 0;
        for(MaleRabbit maleRabbit : maleRabbitList){
            malePopulation += maleRabbit.getCount();
        }
        return malePopulation;
    }

    public void addFemaleRabbit(FemaleRabbit femaleRabbit) {
        femaleRabbitList.add(femaleRabbit);
    }

    public void addMaleRabbit(MaleRabbit maleRabbit) {
        maleRabbitList.add(maleRabbit);
    }

    private void removeFemaleRabbit(FemaleRabbit femaleRabbit) {
        femaleRabbitList.remove(femaleRabbit);
    }

    private void removeMaleRabbit(MaleRabbit maleRabbit) {
        maleRabbitList.remove(maleRabbit);
    }

}
