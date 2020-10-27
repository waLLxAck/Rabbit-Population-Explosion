package com.sparta.engineering72;

import java.util.ArrayList;
import java.util.List;

public class RabbitFluffle {

    static ArrayList<Rabbit> femaleRabbitList = new ArrayList<>();
    static ArrayList<Rabbit> maleRabbitList = new ArrayList<>();

    public static ArrayList<Rabbit> getFemaleRabbitList() {
        return femaleRabbitList;
    }

    public static ArrayList<Rabbit> getMaleRabbitList() {
        return maleRabbitList;
    }

    public int getRabbitPopulationSize(){
        return getFemaleRabbitSize() + getMaleRabbitSize();
    }

    public int getFemaleRabbitSize(){
       return femaleRabbitList.size();
    }

    public int getMaleRabbitSize(){
        return maleRabbitList.size();
    }

    public void addRabbit(Rabbit rabbit){
        if(rabbit.getGender().equals(Animal.Gender.FEMALE)) addFemaleRabbit(rabbit);
        else { addMaleRabbit(rabbit);}
    }

    private void addFemaleRabbit(Rabbit rabbit) {
        femaleRabbitList.add(rabbit);
    }

    private void addMaleRabbit(Rabbit rabbit) {
        maleRabbitList.add(rabbit);
    }

    public void removeRabbit(Rabbit rabbit){
        if(rabbit.getGender().equals(Animal.Gender.FEMALE)) removeFemaleRabbit(rabbit);
        else { removeMaleRabbit(rabbit);}
    }

    private void removeFemaleRabbit(Rabbit rabbit) {
        femaleRabbitList.remove(rabbit);
    }

    private void removeMaleRabbit(Rabbit rabbit) {
        maleRabbitList.remove(rabbit);
    }


}
