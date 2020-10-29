package com.sparta.engineering72.Simulation;

import com.sparta.engineering72.Animal.Animal;
import com.sparta.engineering72.Animal.Fox.FemaleFox;
import com.sparta.engineering72.Animal.Fox.Fox;
import com.sparta.engineering72.Animal.Fox.FoxSkulk;
import com.sparta.engineering72.Animal.Fox.MaleFox;
import com.sparta.engineering72.Animal.Rabbit.FemaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.MaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.RabbitFluffle;
import com.sparta.engineering72.Settings.Settings;
import com.sparta.engineering72.Utility.Randomizer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoxLifeCycle implements LifeCycle {

    static ArrayList<FemaleFox> femaleFoxes = FoxSkulk.getFemaleFoxList();
    static ArrayList<MaleFox> maleFoxes = FoxSkulk.getMaleFoxList();
    public static long foxPregnancies = 0;
    public static long FoxDeathCount = 0;
    public static long rabbitsHunted = 0;

    @Override
    public void naturalDeath() {
        Iterator<MaleFox> maleFoxIterator = maleFoxes.iterator();
        while (maleFoxIterator.hasNext()) {
            MaleFox fox = maleFoxIterator.next();
            if (fox.isReadyToDie()) {
                FoxDeathCount += fox.getCount();
                maleFoxIterator.remove();
            }
        }

        Iterator<FemaleFox> femaleFoxIterator = femaleFoxes.iterator();

        while(femaleFoxIterator.hasNext()) {
            FemaleFox fox = femaleFoxIterator.next();
            if (fox.isReadyToDie()){
                FoxDeathCount += fox.getCount();
                femaleFoxIterator.remove();
            }
        }
    }

    @Override
    public void breed() {
        if (foxPregnancies > 0) {
            List<Animal> animals = FemaleFox.breedFoxes(foxPregnancies);
            for (Animal animal : animals) {
                if (animal.getGender() == Animal.Gender.MALE) {
                    maleFoxes.add((MaleFox) animal);
                } else {
                    femaleFoxes.add((FemaleFox) animal);
                }
            }
            foxPregnancies = 0;
        }
    }

    public void getPregnancies() {
        long maleFoxCount = 0;
        for (MaleFox fox : maleFoxes) {
            if (fox.isMature()) {
                maleFoxCount += fox.getCount();
            }
        }
        long femaleFoxCount = 0;
        for (FemaleFox fox : femaleFoxes) {
            if (fox.isMature()) {
                femaleFoxCount += fox.getCount();
            }
        }
        long potentialPregnancies = Math.min(maleFoxCount, femaleFoxCount);
        long totalPregnancies = 0;
        if (FemaleFox.getPregnancyChance() == 1.0d) {
            totalPregnancies = potentialPregnancies;
        } else if (potentialPregnancies > Settings.MAX_COUNT_THRESHOLD) {
            totalPregnancies = (long) (potentialPregnancies*FemaleFox.getPregnancyChance());
        } else {
            for (long i = 0; i < potentialPregnancies; i++) {
                if (Randomizer.getPregnancyChance(FemaleFox.getPregnancyChance()) == 1) {
                    totalPregnancies += 1;
                }
            }
        }
        foxPregnancies = totalPregnancies;
    }

    public void hunt(int time) {
        RabbitFluffle fluffle = new RabbitFluffle();
        FoxSkulk skulk = new FoxSkulk();
        long foxPopulation = skulk.getFoxPopulationSize();
        if (time < 60) {
            foxPopulation -= 2;
        }
        long rabbitsEaten = 0;
        long rabbitPopulation = fluffle.getRabbitPopulationSize();
        if (foxPopulation > Settings.MAX_COUNT_THRESHOLD) {
            rabbitsEaten = (long) (foxPopulation*10.5);
        } else {
            for (long i = 0; i < foxPopulation; i++) {
                rabbitsEaten += Randomizer.getRandomHunt();
            }
        }
        long rabbitsToHunt = Math.min(rabbitsEaten, rabbitPopulation);
        rabbitsHunted += Math.min(rabbitsEaten, rabbitPopulation);
        ArrayList<MaleRabbit> maleRabbits = RabbitFluffle.getMaleRabbitList();
        ArrayList<FemaleRabbit> femaleRabbits = RabbitFluffle.getFemaleRabbitList();
        long idRange = maleRabbits.size() + femaleRabbits.size();
        while (rabbitsToHunt > 0) {
            long id = Randomizer.getRandomId(idRange);
            if (id >= maleRabbits.size()) {
                FemaleRabbit femaleRabbit = femaleRabbits.get((int) id - maleRabbits.size());
                long count = femaleRabbit.getCount();
                if (count >= rabbitsToHunt) {
                    count -= rabbitsToHunt;
                    if (count == 0) {
                        femaleRabbits.remove((int) id - maleRabbits.size());
                    }
                    idRange--;
                    rabbitsToHunt = 0;
                } else {
                    rabbitsToHunt -= count;
                    femaleRabbits.remove((int) id - maleRabbits.size());
                    idRange--;
                }
            } else {
                MaleRabbit maleRabbit = maleRabbits.get((int) id);
                long count = maleRabbit.getCount();
                if (count >= rabbitsToHunt) {
                    count -= rabbitsToHunt;
                    if (count == 0) {
                        maleRabbits.remove((int) id);
                    }
                    idRange--;
                    rabbitsToHunt = 0;
                } else {
                    rabbitsToHunt -= count;
                    maleRabbits.remove((int) id);
                    idRange--;
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
