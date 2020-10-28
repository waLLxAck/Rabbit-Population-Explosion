package com.sparta.engineering72.Animal.Rabbit;

import com.sparta.engineering72.Animal.Animal;
import com.sparta.engineering72.Utility.Randomizer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FemaleRabbit extends Rabbit {
    public static double PREGNANCY_CHANCE = 0.5d; //TODO: Setters for user input
    private int age;
    private Gender gender;
    private boolean isPregnant;
    private int count;

    public FemaleRabbit(){
        super(Gender.FEMALE);
        this.gender=Gender.FEMALE;
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
        final List<BigInteger> listOfBigIntsMale = new ArrayList<>();
        final List<BigInteger> listOfBigIntsFemale = new ArrayList<>();
        int THREAD_COUNT = 10;

        List<Animal> animals = new ArrayList<>();

        MaleRabbit maleRabbit = new MaleRabbit();
        FemaleRabbit femaleRabbit = new FemaleRabbit();

        int[] randomGenders = Randomizer.getRandomGender(count);

        AtomicInteger countMaleOffspring = new AtomicInteger();
        AtomicInteger countFemaleOffspring = new AtomicInteger();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            listOfBigIntsMale.add(BigInteger.valueOf(0));
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            listOfBigIntsFemale.add(BigInteger.valueOf(0));
        }
        
        if (count>THREAD_COUNT){
            for (int i = 0; i < THREAD_COUNT; i++) {
                final int k = i;
                listOfBigIntsFemale.get(i);
                int lowerBound = (count/THREAD_COUNT * i);
                int upperBound = (count/THREAD_COUNT * (i+1));

                threads.add(new Thread(new Runnable() {
                    final int v = k;
                    @Override
                    public void run() {
                        int males = 0;
                        int females = 0;
                        for (int j = lowerBound; j < upperBound; j++) {
                            if (randomGenders[j] == 0) {
                                males++;
                            } else {
                                females++;
                            }
                        }
                        listOfBigIntsMale.set(v, BigInteger.valueOf(males));
                        listOfBigIntsFemale.set(v, BigInteger.valueOf(females));
                    }
                }));
            }

            for (Thread thread : threads) {
                thread.start();
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int sumOfMales = 0;
            int sumOfFemales = 0;

            for (BigInteger bigInt : listOfBigIntsMale) {
                sumOfMales += bigInt.intValue();
            }

            for (BigInteger bigInt : listOfBigIntsFemale) {
                sumOfFemales += bigInt.intValue();
            }

            maleRabbit.setCount(sumOfMales);
            femaleRabbit.setCount(sumOfFemales);

            animals.add(maleRabbit);
            animals.add(femaleRabbit);

            return animals;
        } else {
            for (int i = 0; i < count; i++) {
                if (randomGenders[i] == 0) {
                    countMaleOffspring.getAndIncrement();
                } else {
                    countFemaleOffspring.getAndIncrement();
                }
            }
            maleRabbit.setCount(countMaleOffspring.get());
            femaleRabbit.setCount(countFemaleOffspring.get());

            animals.add(maleRabbit);
            animals.add(femaleRabbit);
            return animals;
        }
    }
}
