package com.sparta.engineering72.Animal.Rabbit;

import com.sparta.engineering72.Animal.Animal;
import com.sparta.engineering72.Settings.Settings;
import com.sparta.engineering72.Utility.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class FemaleRabbit extends Rabbit {
    public static double PREGNANCY_CHANCE = 0.5d; //TODO: Setters for user input
    private boolean isPregnant;
    private long count;

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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public static double getPregnancyChance() {
        return PREGNANCY_CHANCE;
    }

    public static void setPregnancyChance(double getPregnantChance) {
        PREGNANCY_CHANCE = getPregnantChance;
    }

    public static List<Animal> breed(long count) {
        final int averageOffspringCount = 7;

        List<Animal> animals = new ArrayList<>();

        MaleRabbit maleRabbit = new MaleRabbit();
        FemaleRabbit femaleRabbit = new FemaleRabbit();

        long[] randomGenders;

        if (count > Settings.MAX_COUNT_THRESHOLD){
            long totalOffspring = count*averageOffspringCount;
            maleRabbit.setCount(totalOffspring/2);
            femaleRabbit.setCount(totalOffspring/2);
        } else {
            long countMaleOffspring = 0;
            long countFemaleOffspring = 0;

            long totalOffspring = 0;

            long[] childrenArray = Randomizer.getRandomRabbitOffspring(count);

            for (long child : childrenArray) {
                totalOffspring += child;
            }

            randomGenders = Randomizer.getRandomGender(totalOffspring);

            for(int j = 0; j < totalOffspring; j++) {
                if (randomGenders[j] == 1) {
                    countMaleOffspring++;
                } else {
                    countFemaleOffspring++;
                }
            }

            maleRabbit.setCount(countMaleOffspring);
            femaleRabbit.setCount(countFemaleOffspring);
        }
        animals.add(maleRabbit);
        animals.add(femaleRabbit);
        return animals;
    }
}
