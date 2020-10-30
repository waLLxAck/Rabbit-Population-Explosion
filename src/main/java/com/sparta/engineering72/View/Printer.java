package com.sparta.engineering72.View;
import com.sparta.engineering72.Utility.ReportPacker;

import java.math.BigInteger;
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
        printFinalPopulation(BigInteger.valueOf(reportPacker.getTotalRabbits()),"Rabbits");
        printMalePopulation(BigInteger.valueOf(reportPacker.getMaleRabbits()),"Rabbits");
        printFemalePopulation(BigInteger.valueOf(reportPacker.getFemaleRabbits()),"Rabbits");
        System.out.println("--------------------------------------------------------------");
    }

    private static void printFoxPopulation(ReportPacker reportPacker){
        System.out.println(" == FOX POPULATION REPORT == ");
        printFinalPopulation(BigInteger.valueOf(reportPacker.getTotalFoxes()),"Foxes");
        printMalePopulation(BigInteger.valueOf(reportPacker.getMaleFoxes()),"Foxes");
        printFemalePopulation(BigInteger.valueOf(reportPacker.getFemaleFoxes()),"Foxes");
        System.out.println("--------------------------------------------------------------");
    }

    private static void printRabbitDeaths(ReportPacker reportPacker){
        System.out.println(" == DEATH REPORT == ");
        printRabbitAgeDeathCount(BigInteger.valueOf(reportPacker.getRabbitAgeDeaths()));
        printRabbitPreyDeathCount(BigInteger.valueOf(reportPacker.getRabbitPreyDeaths()));
        printFoxDeathCount(BigInteger.valueOf(reportPacker.getFoxDeaths()));
        System.out.println("==============================================================\n");
    }

    private static void printFinalPopulation(BigInteger number, String animal) {
        System.out.println("The total population of "+animal+": " + myFormatter.format(number));
    }

    private static void printMalePopulation(BigInteger number, String animal) {
        System.out.println("The male population of "+animal+": " + myFormatter.format(number));
    }

    private static void printFemalePopulation(BigInteger number, String animal) {
        System.out.println("The female population of "+animal+": " + myFormatter.format(number));
    }

    private static void printRabbitAgeDeathCount(BigInteger number) {
        System.out.println("The total number of Rabbits that died of old age: " + myFormatter.format(number));
    }

    private static void printRabbitPreyDeathCount(BigInteger number) {
        System.out.println("The total number of Rabbits that were eaten: " + myFormatter.format(number));
    }

    private static void printFoxDeathCount(BigInteger number) {
        System.out.println("The total number of Foxes that died of old age: " + myFormatter.format(number));
    }

    public static void printEnterNumberPrompt() {
        System.out.print("Enter a number: ");
    }
}