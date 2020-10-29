package com.sparta.engineering72.Animal.Rabbit;

import com.sparta.engineering72.Animal.Animal;
import com.sparta.engineering72.Utility.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class FemaleRabbit extends Rabbit {
    public static double PREGNANCY_CHANCE = 0.5d; //TODO: Setters for user input
    private int age;
    private Animal.Gender gender;
    private boolean isPregnant;
    private int count;

    public FemaleRabbit(){
        super(Animal.Gender.FEMALE);
        this.gender= Animal.Gender.FEMALE;
        age = 0;
        isPregnant = false;
        count = 1;
    }

    public boolean isPregnant(){
        return isPregnant;
    }

    public void getPregnant(){
        isPregnant = true;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static double getPregnancyChance() {
        return PREGNANCY_CHANCE;
    }

    public static void setPregnancyChance(double getPregnantChance) {
        PREGNANCY_CHANCE = getPregnantChance;
    }

    public static List<Animal> breed(int count) {
        List<Animal> animals = new ArrayList<>();

        MaleRabbit maleRabbit = new MaleRabbit();
        FemaleRabbit femaleRabbit = new FemaleRabbit();

        int countMaleOffspring = 0;
        int countFemaleOffspring = 0;

        for (int i = 0; i < count; i++) {
            int numberOfOffsprings = Randomizer.getRandomRabbitOffspring();
            for(int j = 0; j < numberOfOffsprings; j++) {
                if (Randomizer.getRandomGender() == 0) {
                    countMaleOffspring++;
                } else {
                    countFemaleOffspring++;
                }
            }
        }

        maleRabbit.setCount(countMaleOffspring);
        femaleRabbit.setCount(countFemaleOffspring);

        animals.add(maleRabbit);
        animals.add(femaleRabbit);
        return animals;
    }
}
