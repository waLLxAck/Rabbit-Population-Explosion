package com.sparta.engineering72.Simulation;

import com.sparta.engineering72.Animal.Animal;
import com.sparta.engineering72.Animal.Rabbit.FemaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.MaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.RabbitFluffle;
import com.sparta.engineering72.Settings.Settings;
import com.sparta.engineering72.Utility.Randomizer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RabbitLifeCycle implements LifeCycle {

    static ArrayList<FemaleRabbit> femaleRabbits = RabbitFluffle.getFemaleRabbitList();
    static ArrayList<MaleRabbit> maleRabbits = RabbitFluffle.getMaleRabbitList();
    public static long pregnancies = 0;
    public static long naturalDeathCount = 0;

    @Override
    public void naturalDeath() {
        Iterator<MaleRabbit> maleRabbitIterator = maleRabbits.iterator();
        while (maleRabbitIterator.hasNext()) {
            MaleRabbit rabbit = maleRabbitIterator.next();
            if (rabbit.isReadyToDie()) {
                naturalDeathCount += rabbit.getCount();
                maleRabbitIterator.remove();
            }
        }

        Iterator<FemaleRabbit> femaleRabbitIterator = femaleRabbits.iterator();

        while(femaleRabbitIterator.hasNext()) {
            FemaleRabbit rabbit = femaleRabbitIterator.next();
            if (rabbit.isReadyToDie()){
                naturalDeathCount += rabbit.getCount();
                femaleRabbitIterator.remove();
            }
        }
    }

    @Override
    public void breed() {
        if (pregnancies > 0) {
            List<Animal> animals = FemaleRabbit.breed(pregnancies);
            for (Animal animal : animals) {
                if (animal.getGender() == Animal.Gender.MALE) {
                    maleRabbits.add((MaleRabbit) animal);
                } else {
                    femaleRabbits.add((FemaleRabbit) animal);
                }
            }
            pregnancies = 0;
        }
        getPregnancies();
    }
    private void getPregnancies() {
        long maleRabbitCount = 0;
        for (MaleRabbit rabbit : maleRabbits) {
            if (rabbit.isMature()) {
                maleRabbitCount += rabbit.getCount();
            }
        }
        long femaleRabbitCount = 0;
        for (FemaleRabbit rabbit : femaleRabbits) {
            if (rabbit.isMature()) {
                femaleRabbitCount += rabbit.getCount();
            }
        }
        long potentialPregnancies = Math.min(maleRabbitCount, femaleRabbitCount);
        long totalPregnancies = 0;
        if (FemaleRabbit.getPregnancyChance() == 1.0d) {
            totalPregnancies = potentialPregnancies;
        } else {
            if (potentialPregnancies > Settings.MAX_COUNT_THRESHOLD) {
                totalPregnancies = (long) (potentialPregnancies*FemaleRabbit.getPregnancyChance());
            } else {
                for (long i = 0; i < potentialPregnancies; i++) {
                    if (Randomizer.getPregnancyChance(FemaleRabbit.getPregnancyChance()) == 1) {
                        totalPregnancies += 1;
                    }
                }
            }
        }
        pregnancies = totalPregnancies;
    }

    @Override
    public void age() {
        for (MaleRabbit rabbit: maleRabbits) {
            rabbit.incrementAge();
        }
        for (FemaleRabbit rabbit: femaleRabbits) {
            rabbit.incrementAge();
        }
    }
}
