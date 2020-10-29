package com.sparta.engineering72.Simulation;

import com.sparta.engineering72.Animal.Rabbit.FemaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.MaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.RabbitFluffle;
import com.sparta.engineering72.Log.Logger;
import com.sparta.engineering72.Utility.ReportPacker;
import com.sparta.engineering72.View.Printer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Simulator {
    public static RabbitFluffle rabbitFluffle = new RabbitFluffle();
    public static int deathCount = 0;

    public static ReportPacker runSimulation(int time, int reportChoice) {
        ReportPacker reportPackerFinal = null;
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources/report.txt"))) {
            bufferedWriter.write("\nSIMULATION REPORT\n");

        RabbitLifeCycle.maleRabbits.add(new MaleRabbit());
        RabbitLifeCycle.femaleRabbits.add(new FemaleRabbit());

        //Simulation starts with 1 male 1 female rabbit print
        Printer.printSimulationStart();
        RabbitLifeCycle rabbitLifeCycle = new RabbitLifeCycle();
        FoxLifeCycle foxLifeCycle = new FoxLifeCycle();

        ReportPacker reportPackerMonthly = null;
        for (int i = 0; i <= time; i++) {
            foxLifeCycle.naturalDeath();
            rabbitLifeCycle.naturalDeath();
            rabbitLifeCycle.breed();
            foxLifeCycle.breed();
            if (i % 12 == 0) {
                foxLifeCycle.getPregnancies();
            }
            rabbitLifeCycle.age();
            foxLifeCycle.age();

            RabbitFluffle.femaleRabbitList = RabbitLifeCycle.femaleRabbits;
            RabbitFluffle.maleRabbitList = RabbitLifeCycle.maleRabbits;

            if(reportChoice == 2) {
                reportPackerMonthly = new ReportPacker(rabbitFluffle.getRabbitPopulationSize(),
                        rabbitFluffle.getMaleRabbitPopulation(), rabbitFluffle.getFemaleRabbitPopulation(),
                        0, 0, 0, RabbitLifeCycle.naturalDeathCount, 0, 0);
                Printer.printMonthlyReportToConsole(reportPackerMonthly, i);
                Printer.writeMonthlyReportToFile(bufferedWriter, rabbitFluffle, RabbitLifeCycle.naturalDeathCount, i);
            }
        }

        reportPackerFinal = new ReportPacker(rabbitFluffle.getRabbitPopulationSize(),
                rabbitFluffle.getFemaleRabbitPopulation(), rabbitFluffle.getMaleRabbitPopulation(),
                0, 0, 0, RabbitLifeCycle.naturalDeathCount, 0, 0);

            if(reportChoice == 1) {
            Printer.printFinalReportToConsole(reportPackerFinal, time);
            Printer.writeFinalReportToFile(bufferedWriter, rabbitFluffle, RabbitLifeCycle.naturalDeathCount, time);
        }


        } catch (IOException ioException) {
            Logger.logError(ioException);
        }

        return reportPackerFinal;
    }
}
