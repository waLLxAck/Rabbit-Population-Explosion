package com.sparta.engineering72.Simulation;

import com.sparta.engineering72.Animal.Animal;
import com.sparta.engineering72.Animal.Fox.FemaleFox;
import com.sparta.engineering72.Animal.Fox.FoxSkulk;
import com.sparta.engineering72.Animal.Fox.MaleFox;
import com.sparta.engineering72.Animal.Rabbit.FemaleRabbit;
import com.sparta.engineering72.Utility.Randomizer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoxLifeCycle implements LifeCycle {

    static ArrayList<FemaleFox> femaleFoxes = FoxSkulk.getFemaleFoxList();
    static ArrayList<MaleFox> maleFoxes = FoxSkulk.getMaleFoxList();
    public static int foxPregnancies = 0;
    public static int FoxDeathCount = 0;

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
        int maleFoxCount = 0;
        for (MaleFox fox : maleFoxes) {
            if (fox.isMature()) {
                maleFoxCount += fox.getCount();
            }
        }
        int femaleFoxCount = 0;
        for (FemaleFox fox : femaleFoxes) {
            if (fox.isMature()) {
                femaleFoxCount += fox.getCount();
            }
        }
        int potentialPregnancies = Math.min(maleFoxCount, femaleFoxCount);
        int totalPregnancies = 0;
        if (FemaleFox.getPregnancyChance() == 1.0d) {
            totalPregnancies = potentialPregnancies;
        } else {
            for (int i = 0; i < potentialPregnancies; i++) {
                if (Randomizer.getPregnancyChance(FemaleFox.getPregnancyChance()) == 1) {
                    totalPregnancies += 1;
                }
            }
        }
        foxPregnancies = totalPregnancies;
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
