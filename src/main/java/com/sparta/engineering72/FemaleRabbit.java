package com.sparta.engineering72;

import java.util.ArrayList;
import java.util.List;

public class FemaleRabbit extends Rabbit {
    public static double GET_PREGNANCY_CHANCE = 0.5d;
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

    public static double getGetPregnantChance() {
        return GET_PREGNANCY_CHANCE;
    }

    public static void setGetPregnantChance(double getPregnantChance) {
        GET_PREGNANCY_CHANCE = getPregnantChance;
    }

    public static List<Animal> breed(int count) {
        List<Animal> animals = new ArrayList<>();

        MaleRabbit maleRabbit = new MaleRabbit();
        FemaleRabbit femaleRabbit = new FemaleRabbit();

        int countMaleOffspring = 0;
        int countFemaleOffspring = 0;

        for (int i = 0; i < count; i++) {
            if (Randomizer.getRandomGender() == 0) {
                countMaleOffspring++;
            } else {
                countFemaleOffspring++;
            }
        }

        maleRabbit.setCount(countMaleOffspring);
        femaleRabbit.setCount(countFemaleOffspring);

        animals.add(maleRabbit);
        animals.add(femaleRabbit);
        return animals;
    }
}
