package com.sparta.engineering72.Animal.Fox;

import com.sparta.engineering72.Animal.Animal;
import com.sparta.engineering72.Utility.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class FemaleFox extends Fox{
    public static double PREGNANCY_CHANCE = 0.5d;
    private boolean isPregnant;
    private int count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static List<Animal> breedFoxes(int count){
        List<Animal> animals = new ArrayList<>();

        MaleFox maleFox = new MaleFox();
        FemaleFox femaleFox = new FemaleFox();

        int countMaleOffspring = 0;
        int countFemaleOffspring = 0;

//        for (int i = 0; i < count; i++) {
//            int numberOfOffsprings = Randomizer.getRandomFoxOffspring();
//            for(int j = 0; j < numberOfOffsprings; j++) {
//                if (Randomizer.getRandomGender() == 0) {
//                    countMaleOffspring++;
//                } else {
//                    countFemaleOffspring++;
//                }
//            }
//        }

        maleFox.setCount(countMaleOffspring);
        femaleFox.setCount(countFemaleOffspring);

        animals.add(maleFox);
        animals.add(femaleFox);
        return animals;

    }

}
