package com.sparta.engineering72.View;
import com.sparta.engineering72.Utility.ReportPacker;

import java.text.DecimalFormat;

public class Printer {

    static DecimalFormat myFormatter = new DecimalFormat("###,###,###");

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void printReportToConsole(ReportPacker reportPacker, int time){
        printSimulationTime(time);
        printRabbitPopulation(reportPacker);
        printFoxPopulation(reportPacker);
        printRabbitDeaths(reportPacker);
    }

    private static void printSimulationTime(int number) {
        int years = number/12;
        int months = number % 12;
        System.out.println("==============================================================");
        System.out.printf("The Simulation ran for %d years and %d months\n", years, months);
        System.out.println("==============================================================");
    }

    private static void printRabbitPopulation(ReportPacker reportPacker){
        System.out.println(" == RABBIT POPULATION REPORT == ");
        printFinalPopulation(reportPacker.getTotalRabbits());
        printMalePopulation(reportPacker.getMaleRabbits());
        printFemalePopulation(reportPacker.getFemaleRabbits());
        System.out.println("--------------------------------------------------------------");
    }

    private static void printFoxPopulation(ReportPacker reportPacker){
        System.out.println(" == FOX POPULATION REPORT == ");
        printFinalPopulation(reportPacker.getTotalFoxes());
        printMalePopulation(reportPacker.getMaleFoxes());
        printFemalePopulation(reportPacker.getFemaleFoxes());
        System.out.println("--------------------------------------------------------------");
    }

    private static void printRabbitDeaths(ReportPacker reportPacker){
        System.out.println(" == DEATH REPORT == ");
        printRabbitAgeDeathCount(reportPacker.getRabbitAgeDeaths());
        printRabbitPreyDeathCount(reportPacker.getRabbitPreyDeaths());
        printFoxDeathCount(reportPacker.getFoxDeaths());
        System.out.println("==============================================================\n");
    }

    private static void printFinalPopulation(int number) {
        System.out.println("The total population of Rabbits: " + myFormatter.format(number));
    }

    private static void printMalePopulation(int number) {
        System.out.println("The male population of Rabbits: " + myFormatter.format(number));
    }

    private static void printFemalePopulation(int number) {
        System.out.println("The female population of Rabbits: " + myFormatter.format(number));
    }

    private static void printRabbitAgeDeathCount(int number) {
        System.out.println("The total number of Rabbits that died: " + myFormatter.format(number));
    }

    private static void printRabbitPreyDeathCount(int number) {
        System.out.println("The total number of Rabbits that were eaten: " + myFormatter.format(number));
    }

    private static void printFoxDeathCount(int number) {
        System.out.println("The total number of Foxes that died: " + myFormatter.format(number));
    }

    public static void printEnterNumberPrompt() {
        System.out.print("Enter a number: ");
    }


}
