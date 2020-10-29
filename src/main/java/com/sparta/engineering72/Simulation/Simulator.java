package com.sparta.engineering72.Simulation;

import com.sparta.engineering72.Animal.Fox.FemaleFox;
import com.sparta.engineering72.Animal.Fox.Fox;
import com.sparta.engineering72.Animal.Fox.FoxSkulk;
import com.sparta.engineering72.Animal.Fox.MaleFox;
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
    public static FoxSkulk foxSkulk = new FoxSkulk();
    public static long deathCount = 0;

    public static ReportPacker runSimulation(int time, int reportChoice) {
        ReportPacker reportPackerFinal = null;
        try(BufferedWriter bufferedWriterTxt = new BufferedWriter(new FileWriter("resources/report.txt"));
           BufferedWriter bufferedWriterJson = new BufferedWriter(new FileWriter("resources/report.json"))) {
            bufferedWriterTxt.write("\nSIMULATION REPORT\n");
          
        RabbitLifeCycle.maleRabbits.add(new MaleRabbit());
        RabbitLifeCycle.femaleRabbits.add(new FemaleRabbit());

        FoxLifeCycle.maleFoxes.add(new MaleFox());
        FoxLifeCycle.femaleFoxes.add(new FemaleFox());

        Printer.printSimulationStart();
        RabbitLifeCycle rabbitLifeCycle = new RabbitLifeCycle();
        FoxLifeCycle foxLifeCycle = new FoxLifeCycle();

        ReportPacker reportPackerMonthly = null;
        for (int i = 0; i <= time; i++) {
            foxLifeCycle.naturalDeath();
            rabbitLifeCycle.naturalDeath();
            foxLifeCycle.hunt(i);
            rabbitLifeCycle.breed();
            foxLifeCycle.breed();
            if (i % 12 == 0) {
                foxLifeCycle.getPregnancies();
            }
            rabbitLifeCycle.age();
            foxLifeCycle.age();

            RabbitFluffle.femaleRabbitList = RabbitLifeCycle.femaleRabbits;
            RabbitFluffle.maleRabbitList = RabbitLifeCycle.maleRabbits;

            FoxSkulk.maleFoxList = FoxLifeCycle.maleFoxes;
            FoxSkulk.femaleFoxList = FoxLifeCycle.femaleFoxes;

                if(reportChoice == 2) {
                    reportPackerMonthly = new ReportPacker(rabbitFluffle.getRabbitPopulationSize(),
                            rabbitFluffle.getMaleRabbitPopulation(), rabbitFluffle.getFemaleRabbitPopulation(),
                            foxSkulk.getFoxPopulationSize(), foxSkulk.getMaleFoxPopulation(), foxSkulk.getFemaleFoxPopulation(), RabbitLifeCycle.naturalDeathCount, FoxLifeCycle.rabbitsHunted, FoxLifeCycle.FoxDeathCount);

                    Printer.printReportToConsole(reportPackerMonthly, i);
                    Printer.writeReportToFile(bufferedWriterTxt, reportPackerMonthly, i);

                    JSONHandler.jsonArray = JSONHandler.populateJSONArray(JSONHandler.populateJSONObject(reportPackerMonthly));
                    if(i == time) Printer.writeJSONReport(bufferedWriterJson, JSONHandler.jsonArray);
                }
            }

        reportPackerFinal = new ReportPacker(rabbitFluffle.getRabbitPopulationSize(),
                rabbitFluffle.getFemaleRabbitPopulation(), rabbitFluffle.getMaleRabbitPopulation(),
                foxSkulk.getFoxPopulationSize(), foxSkulk.getMaleFoxPopulation(), foxSkulk.getFemaleFoxPopulation(), RabbitLifeCycle.naturalDeathCount, FoxLifeCycle.rabbitsHunted, FoxLifeCycle.FoxDeathCount);

            if(reportChoice == 1) {
                Printer.printReportToConsole(reportPackerFinal, time);
                Printer.writeReportToFile(bufferedWriterTxt, reportPackerFinal, time);
                Printer.writeJSONReport(bufferedWriterJson, JSONHandler.populateJSONArray(JSONHandler.populateJSONObject(reportPackerFinal)));
            }

            Printer.printSimulationCompleted();

        } catch (IOException ioException) {
            Logger.logError(ioException);
        }

        return reportPackerFinal;
    }
}
