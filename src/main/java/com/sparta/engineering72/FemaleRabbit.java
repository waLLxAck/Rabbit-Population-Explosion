package com.sparta.engineering72;

import java.util.List;

public class FemaleRabbit extends Rabbit implements Breedable{
    private int age;
    private Gender gender;
    private boolean isPregnant;

    public FemaleRabbit(){
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
        return null;
    }
}
