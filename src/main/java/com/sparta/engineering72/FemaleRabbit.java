package com.sparta.engineering72;

import java.util.ArrayList;
import java.util.List;

public class FemaleRabbit extends Rabbit implements Breedable{
    private int age;
    private Gender gender;
    private boolean isPregnant;

    public FemaleRabbit(){
        super(Gender.FEMALE);
        this.gender=Gender.FEMALE;
        age = 0;
        isPregnant = false;
    }

    public boolean isPregnant(){
        return isPregnant;
    }

    public void getPregnant(){
        isPregnant = true;
    }

    @Override
    public List<Animal> breed() {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < Randomizer.getRandomOffspring(); i++) { //TODO: Check if right
            if (Randomizer.getRandomGender() == 0) {
                MaleRabbit maleRabbit = new MaleRabbit();
                animals.add(maleRabbit);
            } else {
                FemaleRabbit femaleRabbit = new FemaleRabbit();
                animals.add(femaleRabbit);
            }
        }
        return animals;
    }
}
