package com.sparta.engineering72.Animal.Fox;

import com.sparta.engineering72.Animal.Animal;
import com.sparta.engineering72.Settings.Settings;
import com.sparta.engineering72.Utility.Randomizer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FemaleFox extends Fox{
    public static double PREGNANCY_CHANCE = 0.5d;
    private boolean isPregnant;
    private long count;

    public FemaleFox() {
        super(Animal.Gender.FEMALE);
        age = 0;
        isPregnant = false;
        count = 1;
    }

    public boolean isPregnant(){
        return isPregnant;
    }

    public static double getPregnancyChance() {
        return PREGNANCY_CHANCE;
    }

    public static void setPregnancyChance(double pregnancyChance) {
        PREGNANCY_CHANCE = pregnancyChance;
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

    public static List<Animal> breedFoxes(long count){
        final int averageOffspringCount = 5;

        List<Animal> animals = new ArrayList<>();

        MaleFox malefox = new MaleFox();
        FemaleFox femalefox = new FemaleFox();

        long[] randomGenders;

        if (count > Settings.MAX_COUNT_THRESHOLD){
            long totalOffspring = count*averageOffspringCount;
            malefox.setCount(totalOffspring/2);
            femalefox.setCount(totalOffspring/2);
        } else {
            long countMaleOffspring = 0;
            long countFemaleOffspring = 0;

            long totalOffspring = 0;

            long[] childrenArray = Randomizer.getRandomFoxOffspring(count);

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

            malefox.setCount(countMaleOffspring);
            femalefox.setCount(countFemaleOffspring);
        }
        animals.add(malefox);
        animals.add(femalefox);
        return animals;
    }

}
