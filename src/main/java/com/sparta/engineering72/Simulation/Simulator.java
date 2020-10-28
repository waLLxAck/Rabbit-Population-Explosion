package com.sparta.engineering72.Simulation;

import com.sparta.engineering72.Animal.Animal;
import com.sparta.engineering72.Animal.Rabbit.FemaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.MaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.RabbitFluffle;
import com.sparta.engineering72.Log.Logger;
import com.sparta.engineering72.Utility.Randomizer;
import com.sparta.engineering72.View.Printer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Simulator {
    public static RabbitFluffle rabbitFluffle = new RabbitFluffle();
    static ArrayList<FemaleRabbit> femaleRabbits = RabbitFluffle.getFemaleRabbitList();
    static ArrayList<MaleRabbit> maleRabbits = RabbitFluffle.getMaleRabbitList();
    static int pregnancies = 0;
    public static int deathCount = 0;
    static boolean oneMaleAndMature = false;

    public static void runSimulation(int time, int reportChoice) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources/report.txt"))) {
            bufferedWriter.write("\nSIMULATION REPORT\n");

        maleRabbits.add(new MaleRabbit());
        femaleRabbits.add(new FemaleRabbit());

        //Simulation starts with 1 male 1 female rabbit print
        Printer.printSimulationStart();

        for (int i = 0; i <= time; i++) {
            Iterator<MaleRabbit> maleRabbitIterator = maleRabbits.iterator();

            while(maleRabbitIterator.hasNext()) {
                MaleRabbit rabbit = maleRabbitIterator.next();
                if (rabbit.isReadyToDie()){
                    deathCount += rabbit.getCount();
                    maleRabbitIterator.remove();
                } else if (rabbit.isMature()) {
                    oneMaleAndMature = true;
                }
            }
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
            pregnancies = getPregnancies();

            Iterator<FemaleRabbit> femaleRabbitIterator = femaleRabbits.iterator();

            while(femaleRabbitIterator.hasNext()) {
                FemaleRabbit rabbit = femaleRabbitIterator.next();
                if (rabbit.isReadyToDie()){
                    deathCount += rabbit.getCount();
                    femaleRabbitIterator.remove();
                } else if (rabbit.isMature()) {
                    oneMaleAndMature = true;
                }
            }

            for (MaleRabbit rabbit: maleRabbits) {
                rabbit.incrementAge();
            }
            for (FemaleRabbit rabbit: femaleRabbits) {
                rabbit.incrementAge();
            }

            RabbitFluffle.femaleRabbitList = femaleRabbits;
            RabbitFluffle.maleRabbitList = maleRabbits;

            if(reportChoice == 2) {
                Printer.printMonthlyReport(rabbitFluffle, deathCount, i);
                Printer.writeMonthlyReportToFile(bufferedWriter, rabbitFluffle, deathCount, i);
            }
        }
        if(reportChoice == 1) {
            Printer.printFinalReport(rabbitFluffle, deathCount, time);
            Printer.writeFinalReportToFile(bufferedWriter, rabbitFluffle, deathCount, time);
        }

        } catch (IOException ioException) {
            Logger.logError(ioException);
        }
    }
    public static int getPregnancies() {
        int maleRabbitCount = 0;
        for (MaleRabbit rabbit : maleRabbits) {
            if (rabbit.isMature()) {
                maleRabbitCount += rabbit.getCount();
            }
        }
        int femaleRabbitCount = 0;
        for (FemaleRabbit rabbit : femaleRabbits) {
            if (rabbit.isMature()) {
                femaleRabbitCount += rabbit.getCount();
            }
        }
        int potentialPregnancies = Math.min(maleRabbitCount, femaleRabbitCount);
        int totalPregnancies = 0;
        for (int i = 0; i < potentialPregnancies; i++) {
            if (Randomizer.getPregnancyChance(FemaleRabbit.getPregnancyChance()) == 1){
                totalPregnancies += 1;
            }
        }
        return totalPregnancies;
    }
}
