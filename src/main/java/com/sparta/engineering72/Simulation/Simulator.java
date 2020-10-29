package com.sparta.engineering72.Simulation;

import com.sparta.engineering72.Animal.Rabbit.FemaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.MaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.RabbitFluffle;
import com.sparta.engineering72.Log.Logger;
import com.sparta.engineering72.Utility.JSONHandler;
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
        try(BufferedWriter bufferedWriterTxt = new BufferedWriter(new FileWriter("resources/report.txt"))) {
            bufferedWriterTxt.write("\nSIMULATION REPORT\n");

            BufferedWriter bufferedWriterJson = new BufferedWriter(new FileWriter("resources/report.json"));

        RabbitLifeCycle.maleRabbits.add(new MaleRabbit());
        RabbitLifeCycle.femaleRabbits.add(new FemaleRabbit());

        Printer.printSimulationStart();
        RabbitLifeCycle rabbitLifeCycle = new RabbitLifeCycle();
        FoxLifeCycle foxLifeCycle = new FoxLifeCycle();

            ReportPacker reportPackerMonthly = null;
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
                    reportPackerMonthly = new ReportPacker(rabbitFluffle.getRabbitPopulationSize(),
                            rabbitFluffle.getMaleRabbitPopulation(), rabbitFluffle.getFemaleRabbitPopulation(),
                            0, 0, 0, deathCount, 0, 0);

                    Printer.printMonthlyReportToConsole(reportPackerMonthly, i);

                    Printer.writeMonthlyReportToFile(bufferedWriterTxt, rabbitFluffle, RabbitLifeCycle.naturalDeathCount, i);

                    JSONHandler.jsonArray = JSONHandler.populateJSONArray(JSONHandler.populateJSONObject(reportPackerMonthly));
                    if(i == time) Printer.writeJSONReport(bufferedWriterJson, JSONHandler.jsonArray);

                }
            }

        reportPackerFinal = new ReportPacker(rabbitFluffle.getRabbitPopulationSize(),
                rabbitFluffle.getFemaleRabbitPopulation(), rabbitFluffle.getMaleRabbitPopulation(),
                0, 0, 0, deathCount, 0, 0);

            if(reportChoice == 1) {
                Printer.printFinalReportToConsole(reportPackerFinal, time);
                Printer.writeFinalReportToFile(bufferedWriterTxt, rabbitFluffle, RabbitLifeCycle.naturalDeathCount, time);
                Printer.writeJSONReport(bufferedWriterJson, JSONHandler.populateJSONArray(JSONHandler.populateJSONObject(reportPackerFinal)));
            }

            bufferedWriterJson.close();

        } catch (IOException ioException) {
            Logger.logError(ioException);
        }

        return reportPackerFinal;
    }
}
