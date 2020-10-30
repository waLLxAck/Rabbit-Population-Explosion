package com.sparta.engineering72.Simulation;

import com.sparta.engineering72.Animal.Animal;
import com.sparta.engineering72.Animal.Fox.FemaleFox;
import com.sparta.engineering72.Animal.Fox.FoxSkulk;
import com.sparta.engineering72.Animal.Fox.MaleFox;
import com.sparta.engineering72.Animal.Rabbit.FemaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.MaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.RabbitFluffle;
import com.sparta.engineering72.Settings.Settings;
import com.sparta.engineering72.Utility.Randomizer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoxLifeCycle implements LifeCycle {

    static ArrayList<FemaleFox> femaleFoxes = FoxSkulk.getFemaleFoxList();
    static ArrayList<MaleFox> maleFoxes = FoxSkulk.getMaleFoxList();
    public static BigInteger foxPregnancies = BigInteger.valueOf(0);
    public static BigInteger FoxDeathCount = BigInteger.valueOf(0);
    public static BigInteger rabbitsHunted = BigInteger.valueOf(0);

    @Override
    public void naturalDeath() {
        Iterator<MaleFox> maleFoxIterator = maleFoxes.iterator();
        while (maleFoxIterator.hasNext()) {
            MaleFox fox = maleFoxIterator.next();
            if (fox.isReadyToDie()) {
                FoxDeathCount.add(fox.getCount());
                maleFoxIterator.remove();
            }
        }

        Iterator<FemaleFox> femaleFoxIterator = femaleFoxes.iterator();

        while(femaleFoxIterator.hasNext()) {
            FemaleFox fox = femaleFoxIterator.next();
            if (fox.isReadyToDie()){
                FoxDeathCount.add(fox.getCount());
                femaleFoxIterator.remove();
            }
        }
    }

    @Override
    public void breed() {
        if (foxPregnancies.compareTo(BigInteger.valueOf(0)) > 0) {
            List<Animal> animals = FemaleFox.breedFoxes(BigInteger.valueOf(foxPregnancies));
            for (Animal animal : animals) {
                if (animal.getGender() == Animal.Gender.MALE) {
                    maleFoxes.add((MaleFox) animal);
                } else {
                    femaleFoxes.add((FemaleFox) animal);
                }
            }
            foxPregnancies = BigInteger.valueOf(0);
        }
    }

    public void getPregnancies() {
        BigInteger maleFoxCount = BigInteger.valueOf(0);
        for (MaleFox fox : maleFoxes) {
            if (fox.isMature()) {
                maleFoxCount.add(fox.getCount());
            }
        }
        BigInteger femaleFoxCount = BigInteger.valueOf(0);
        for (FemaleFox fox : femaleFoxes) {
            if (fox.isMature()) {
                femaleFoxCount.add(fox.getCount());
            }
        }
        BigInteger potentialPregnancies = maleFoxCount.min(femaleFoxCount);
        BigInteger totalPregnancies = BigInteger.valueOf(0);
        if (FemaleFox.getPregnancyChance() == 1.0d) {
            totalPregnancies = potentialPregnancies;
        } else if (potentialPregnancies.compareTo(Settings.MAX_COUNT_THRESHOLD) > 0) {
            // what with this?
            totalPregnancies = (long) (potentialPregnancies*FemaleFox.getPregnancyChance());
        } else {
            int potentialPregnanciesInt = potentialPregnancies.intValue();
            for (int i = 0; i < potentialPregnanciesInt; i++) {
                if (Randomizer.getPregnancyChance(FemaleFox.getPregnancyChance()) == 1) {
                    totalPregnancies.add(BigInteger.valueOf(1));
                }
            }
        }
        foxPregnancies = totalPregnancies;
    }

    public void hunt(int time) {
        RabbitFluffle fluffle = new RabbitFluffle();
        FoxSkulk skulk = new FoxSkulk();
        BigInteger foxPopulation = BigInteger.valueOf(skulk.getFoxPopulationSize());
        if (time < 60) {
            foxPopulation.subtract(BigInteger.valueOf(2));
        }
        BigInteger rabbitsEaten = BigInteger.valueOf(0);
        BigInteger rabbitPopulation = BigInteger.valueOf(fluffle.getRabbitPopulationSize());
        if (foxPopulation.compareTo(Settings.MAX_COUNT_THRESHOLD) > 0) {
            // what do i do with this
            rabbitsEaten = (BigInteger) (foxPopulation.doubleValue() * 10.5);
        } else {
            int foxPopulationInt = foxPopulation.intValue();
            for (int i = 0; i < foxPopulationInt; i++) {
                rabbitsEaten.add(Randomizer.getRandomHunt());
            }
        }
        BigInteger rabbitsToHunt = rabbitsEaten.min(rabbitPopulation);
        rabbitsHunted.add(rabbitsEaten.min(rabbitPopulation));
        ArrayList<MaleRabbit> maleRabbits = RabbitFluffle.getMaleRabbitList();
        ArrayList<FemaleRabbit> femaleRabbits = RabbitFluffle.getFemaleRabbitList();
        BigInteger idRange = BigInteger.valueOf(maleRabbits.size()).add(BigInteger.valueOf(femaleRabbits.size()));
        while (rabbitsToHunt.compareTo(BigInteger.valueOf(0)) > 0) {
            BigInteger id = Randomizer.getRandomId(idRange);
            if (id.compareTo(BigInteger.valueOf(maleRabbits.size())) > 0) {
                // what with this
                FemaleRabbit femaleRabbit = femaleRabbits.get((int) id - maleRabbits.size());
                BigInteger count = BigInteger.valueOf(femaleRabbit.getCount());
                if (count.compareTo(rabbitsToHunt) > 0) {
                    count.subtract(rabbitsToHunt);
                    if (count.intValue() == 0) {
                        femaleRabbits.remove((int) id - maleRabbits.size());
                    }
                    idRange.subtract(BigInteger.valueOf(1));
                    rabbitsToHunt = BigInteger.valueOf(0);
                } else {
                    rabbitsToHunt.subtract(count);
                    femaleRabbits.remove((int) id - maleRabbits.size());
                    idRange.subtract(BigInteger.valueOf(1));
                }
            } else {
                MaleRabbit maleRabbit = maleRabbits.get((int) id);
                BigInteger count = BigInteger.valueOf(maleRabbit.getCount());
                if (count.compareTo(rabbitsToHunt) > 0) {
                    count.subtract(rabbitsToHunt);
                    if (count.intValue() == 0) {
                        maleRabbits.remove((int) id);
                    }
                    idRange.subtract(BigInteger.valueOf(1));
                    rabbitsToHunt = BigInteger.valueOf(0);
                } else {
                    rabbitsToHunt.subtract(count);
                    maleRabbits.remove((int) id);
                    idRange.subtract(BigInteger.valueOf(1));
                }
            }
        }
    }

    @Override
    public void age() {
        for (MaleFox fox: maleFoxes) {
            fox.incrementAge();
        }
        for (FemaleFox fox: femaleFoxes) {
            fox.incrementAge();
        }
    }
}