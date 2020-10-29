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
    public static int deathCount = 0;

    public static void runSimulation(int time, int reportChoice) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources/report.txt"))) {
            bufferedWriter.write("\nSIMULATION REPORT\n");

        RabbitLifeCycle.maleRabbits.add(new MaleRabbit());
        RabbitLifeCycle.femaleRabbits.add(new FemaleRabbit());

        //Simulation starts with 1 male 1 female rabbit print
        Printer.printSimulationStart();
        RabbitLifeCycle rabbitLifeCycle = new RabbitLifeCycle();
        FoxLifeCycle foxLifeCycle = new FoxLifeCycle();

        for (int i = 0; i <= time; i++) {
            foxLifeCycle.naturalDeath();
            rabbitLifeCycle.naturalDeath();
            rabbitLifeCycle.breed();
            if (i % 12 == 0) {
                foxLifeCycle.breed();
            }
            rabbitLifeCycle.age();
            foxLifeCycle.age();

            RabbitFluffle.femaleRabbitList = RabbitLifeCycle.femaleRabbits;
            RabbitFluffle.maleRabbitList = RabbitLifeCycle.maleRabbits;

            if(reportChoice == 2) {
                Printer.printMonthlyReport(rabbitFluffle, RabbitLifeCycle.naturalDeathCount, i);
                Printer.writeMonthlyReportToFile(bufferedWriter, rabbitFluffle, RabbitLifeCycle.naturalDeathCount, i);
            }
        }
        if(reportChoice == 1) {
            Printer.printFinalReport(rabbitFluffle, RabbitLifeCycle.naturalDeathCount, time);
            Printer.writeFinalReportToFile(bufferedWriter, rabbitFluffle, RabbitLifeCycle.naturalDeathCount, time);
        }

        } catch (IOException ioException) {
            Logger.logError(ioException);
        }
    }
}
