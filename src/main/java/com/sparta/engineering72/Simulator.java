package com.sparta.engineering72;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Simulator {
    static RabbitFluffle rabbitFluffle = new RabbitFluffle();
    static ArrayList<FemaleRabbit> femaleRabbits = RabbitFluffle.getFemaleRabbitList();
    static ArrayList<MaleRabbit> maleRabbits = RabbitFluffle.getMaleRabbitList();
    static ArrayList<Animal> rabbitsToAdd = new ArrayList<>();
    static ArrayList<Animal> rabbitsToRemove = new ArrayList<>();
    static int pregnancies = 0;
    static boolean oneMaleAndMature = false;

    public static void runSimulation(int time) {
        rabbitFluffle.addMaleRabbit(new MaleRabbit());
        rabbitFluffle.addFemaleRabbit(new FemaleRabbit());

        //Simulation starts with 1 male 1 female rabbit print

        for (int i = 0; i < time; i++) {
            for (Rabbit rabbit: maleRabbits) {
                if (rabbit.isReadyToDie()){
                    rabbitsToRemove.add(rabbit);
                } else if (rabbit.isMature()) {
                    oneMaleAndMature = true;
                }
                rabbit.incrementAge();
            }
            if (pregnancies > 0) {
                List<Animal> animals = FemaleRabbit.breed(pregnancies);
                for (Animal animal : animals) {
                    if (animal.getGender() == Animal.Gender.MALE) {
                        rabbitFluffle.addMaleRabbit(animal);
                    } else {
                        rabbitFluffle.addFemaleRabbit(animal);
                    }
                }
                pregnancies = 0;
            }
            pregnancies = getPregnancies();
            for (Rabbit rabbit: femaleRabbits) {
                if (rabbit.isReadyToDie()){
                    rabbitsToRemove.add(rabbit);
                }
//                if (((FemaleRabbit) rabbit).isPregnant()) {
//                    rabbitsToAdd.addAll((((FemaleRabbit) rabbit).breed())); //FIXME
//                }
//                if (rabbit.isMature() && oneMaleAndMature) {
//                    ((FemaleRabbit) rabbit).getPregnant();
//                }
                rabbit.incrementAge();
            }
//            rabbitFluffle.addRabbits(rabbitsToAdd); //FIXME: !!!!
//            rabbitFluffle.removeRabbits(rabbitsToRemove);

            femaleRabbits = RabbitFluffle.getFemaleRabbitList();
            maleRabbits = RabbitFluffle.getMaleRabbitList();
        }



        Printer.printFinalPopulation(rabbitFluffle.getRabbitPopulationSize());
//        Printer.printDeathCount();
        Printer.printMalePopulation(rabbitFluffle.getMaleRabbitPopulation());
        Printer.printFemalePopulation(rabbitFluffle.getFemaleRabbitPopulation());
        Printer.printSimulationTime(time);
    }
    public static int getPregnancies() {
        int maleRabbitCount = 0;
        for (Rabbit rabbit : maleRabbits) {
            if (rabbit.isMature()) {
                maleRabbitCount += rabbit.getCount();
            }
        }
        int femaleRabbitCount = 0;
        for (Rabbit rabbit : maleRabbits) {
            if (rabbit.isMature()) {
                femaleRabbitCount += rabbit.getCount();
            }
        }
        int potentialPregnancies = Math.min(maleRabbitCount, femaleRabbitCount);
        int totalPregnancies = 0;
        for (int i = 0; i < potentialPregnancies; i++) {
            totalPregnancies += Randomiser.getPregnancyChance();
        }
        return totalPregnancies;
    }
}
