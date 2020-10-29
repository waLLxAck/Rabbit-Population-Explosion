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

        final List<BigInteger> listOfBigIntsMale = new ArrayList<>();
        final List<BigInteger> listOfBigIntsFemale = new ArrayList<>();
        int THREAD_COUNT = 10;
        List<Animal> animals = new ArrayList<>();
        MaleFox malefox = new MaleFox();
        FemaleFox femalefox = new FemaleFox();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            listOfBigIntsMale.add(BigInteger.valueOf(0));
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            listOfBigIntsFemale.add(BigInteger.valueOf(0));
        }

        long[] randomGenders;

        if (count > Settings.MAX_COUNT_THRESHOLD){
            long totalOffspring = count*averageOffspringCount;
            long totalOffspring2 = totalOffspring/2;
            malefox.setCount(totalOffspring2);
            femalefox.setCount(totalOffspring2);
        } else {
            long countMaleOffspring = 0;
            long countFemaleOffspring = 0;

            long totalOffspring = 0;

            long[] childrenArray = Randomizer.getRandomFoxOffspring(count);

            for (long child : childrenArray) {
                totalOffspring += child;
            }

            randomGenders = Randomizer.getRandomGender(totalOffspring);

//            for (int i = 0; i < THREAD_COUNT; i++) {
//                final int k = i;
//
//                int lowerBound = (totalOffspring/THREAD_COUNT * i);
//                int upperBound = (totalOffspring/THREAD_COUNT * (i+1));
//                threads.add(new Thread(new Runnable() {
//                    final int v = k;
//                    @Override
//                    public void run() {
//                        int males = 0;
//                        int females = 0;
//                        for (int j = lowerBound; j < upperBound; j++) {
//                            for (int i = 0; i < upperBound-lowerBound; i++) {
//                                if (randomGenders[j] == 0) {
//                                    males++;
//                                } else {
//                                    females++;
//                                }
//                            }
//                        }
//                        listOfBigIntsMale.set(v, BigInteger.valueOf(males));
//                        listOfBigIntsFemale.set(v, BigInteger.valueOf(females));
//                    }
//                }));
//            }
//            for (Thread thread : threads) {
//                thread.start();
//            }
//            for (Thread thread : threads) {
//                try {
//                    thread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            int sumOfMales = 0;
//            int sumOfFemales = 0;
//            for (BigInteger bigInt : listOfBigIntsMale) {
//                sumOfMales += bigInt.intValue();
//            }
//            for (BigInteger bigInt : listOfBigIntsFemale) {
//                sumOfFemales += bigInt.intValue();
//            }
//            malefox.setCount(sumOfMales);
//            femalefox.setCount(sumOfFemales);

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
