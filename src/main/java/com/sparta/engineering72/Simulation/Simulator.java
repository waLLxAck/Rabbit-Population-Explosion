package com.sparta.engineering72.Simulation;
import com.sparta.engineering72.Animal.Fox.FemaleFox;
import com.sparta.engineering72.Animal.Fox.FoxSkulk;
import com.sparta.engineering72.Animal.Fox.MaleFox;
import com.sparta.engineering72.Animal.Rabbit.FemaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.MaleRabbit;
import com.sparta.engineering72.Animal.Rabbit.RabbitFluffle;
import com.sparta.engineering72.Log.Logger;
import com.sparta.engineering72.View.Display;
import com.sparta.engineering72.View.JSONHandler;
import com.sparta.engineering72.Utility.ReportPacker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Simulator {
    public static RabbitFluffle rabbitFluffle = new RabbitFluffle();
    public static FoxSkulk foxSkulk = new FoxSkulk();
    public static ReportPacker runSimulation(int time, int reportChoice) {

        ReportPacker reportPackerFinal = null;
        try(BufferedWriter bufferedWriterTxt = new BufferedWriter(new FileWriter("resources/report.txt"));
            BufferedWriter bufferedWriterJson = new BufferedWriter(new FileWriter("resources/report.json"))) {
            bufferedWriterTxt.write("\nSIMULATION REPORT\n");

            RabbitLifeCycle.maleRabbits.add(new MaleRabbit());
            RabbitLifeCycle.femaleRabbits.add(new FemaleRabbit());
            FoxLifeCycle.maleFoxes.add(new MaleFox());
            FoxLifeCycle.femaleFoxes.add(new FemaleFox());

            Display.displaySimulationStart();

            RabbitLifeCycle rabbitLifeCycle = new RabbitLifeCycle();
            FoxLifeCycle foxLifeCycle = new FoxLifeCycle();

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
                ReportPacker reportPackerMonthly = new ReportPacker(rabbitFluffle.getRabbitPopulationSize(),
                        rabbitFluffle.getMaleRabbitPopulation(), rabbitFluffle.getFemaleRabbitPopulation(),
                        foxSkulk.getFoxPopulationSize(), foxSkulk.getMaleFoxPopulation(), foxSkulk.getFemaleFoxPopulation(),
                        RabbitLifeCycle.naturalDeathCount, FoxLifeCycle.rabbitsHunted, FoxLifeCycle.FoxDeathCount);
                JSONHandler.jsonArray = JSONHandler.populateJSON(reportPackerMonthly);

                if(reportChoice == 2) Display.display(reportPackerMonthly, i, bufferedWriterTxt);
            }

            reportPackerFinal = new ReportPacker(rabbitFluffle.getRabbitPopulationSize(),
                    rabbitFluffle.getFemaleRabbitPopulation(), rabbitFluffle.getMaleRabbitPopulation(),
                    foxSkulk.getFoxPopulationSize(), foxSkulk.getMaleFoxPopulation(), foxSkulk.getFemaleFoxPopulation(),
                    RabbitLifeCycle.naturalDeathCount, FoxLifeCycle.rabbitsHunted, FoxLifeCycle.FoxDeathCount);

            JSONHandler.jsonArray = JSONHandler.populateJSON(reportPackerFinal);
            JSONHandler.writeJSONReport(bufferedWriterJson, JSONHandler.jsonArray);

            if(reportChoice == 1) Display.display(reportPackerFinal, time, bufferedWriterTxt);

            Display.displaySimulationCompleted();

        } catch (IOException ioException) {
            Logger.logError(ioException);
        }

        return reportPackerFinal;
    }

    public static ReportPacker resetAllStaticValues(int time, int reportChoice){
        rabbitFluffle = new RabbitFluffle();
        foxSkulk = new FoxSkulk();
        RabbitLifeCycle.naturalDeathCount = 0;
        RabbitLifeCycle.pregnancies = 0;
        RabbitLifeCycle.maleRabbits = new ArrayList<>();
        RabbitLifeCycle.femaleRabbits = new ArrayList<>();
        FoxLifeCycle.rabbitsHunted = 0;
        FoxLifeCycle.FoxDeathCount = 0;
        FoxLifeCycle.foxPregnancies = 0;
        FoxLifeCycle.maleFoxes = new ArrayList<>();
        FoxLifeCycle.femaleFoxes = new ArrayList<>();

        return runSimulation(time, reportChoice);

    }

}