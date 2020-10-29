package com.sparta.engineering72.View;

import com.sparta.engineering72.Animal.Rabbit.RabbitFluffle;
import com.sparta.engineering72.Utility.ReportPacker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class Printer {

    static DecimalFormat myFormatter = new DecimalFormat("###,###,###");

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void printReportChoice(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("Please choose how you want the report to be displayed:");
        System.out.println("    enter 1 for a final report");
        System.out.println("    enter 2 for a month-by-month breakdown for the simulation");
        System.out.println("--------------------------------------------------------------");
    }

    public static void printStartMessage() {
        System.out.println("\nWELCOME TO THE RABBIT SIMULATOR");
        System.out.println("-------------------------------");
        System.out.println("All required user inputs should be entered in the console when prompted");
        System.out.println("The final report from the simulation will also be displayed in the console");
        System.out.println("-------------------------------");
    }

    public static void printSimulationStart(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("The Simulation starts off with 1 male and 1 female rabbit");
        System.out.println("The Simulation is starting now...");
        System.out.println("--------------------------------------------------------------\n");
    }

    public static void writeJSONReport(BufferedWriter bufferedWriter, JSONArray jsonArray) throws IOException {
        bufferedWriter.write(jsonArray.toJSONString());
    }

    public static void writeReportToFile(BufferedWriter bufferedWriter, ReportPacker reportPacker, int time) throws IOException {
        int years = time/12;
        int months = time % 12;
        bufferedWriter.write("\n\n==============================================================");
        bufferedWriter.write("\n The Simulation ran for " + years + " years and " + months + " months");
        bufferedWriter.write("\n==============================================================");
        bufferedWriter.write("\n == RABBIT POPULATION REPORT == ");
        bufferedWriter.write("\nThe total population of Rabbits: " + myFormatter.format(reportPacker.getTotalRabbits()));
        bufferedWriter.write("\nThe male population of Rabbits: " + myFormatter.format(reportPacker.getMaleRabbits()));
        bufferedWriter.write("\nThe female population of Rabbits: " + myFormatter.format(reportPacker.getFemaleRabbits()));
        bufferedWriter.write("\n--------------------------------------------------------------");
        bufferedWriter.write("\n == FOX POPULATION REPORT == ");
        bufferedWriter.write("\nThe total population of Foxes: " + myFormatter.format(reportPacker.getTotalFoxes()));
        bufferedWriter.write("\nThe male population of Foxes: " + myFormatter.format(reportPacker.getMaleFoxes()));
        bufferedWriter.write("\nThe female population of Foxes: " + myFormatter.format(reportPacker.getFemaleFoxes()));
        bufferedWriter.write("\n--------------------------------------------------------------");
        bufferedWriter.write("\n == DEATH REPORT == ");
        bufferedWriter.write("\nThe total number of Rabbits that died: " + myFormatter.format(reportPacker.getRabbitAgeDeaths()));
        bufferedWriter.write("\nThe total number of Rabbits that were eaten: " + myFormatter.format(reportPacker.getRabbitPreyDeaths()));
        bufferedWriter.write("\nThe total number of Foxes that died: " + myFormatter.format(reportPacker.getFoxDeaths()));
        bufferedWriter.write("\n==============================================================\n");
    }

    public static void printReportToConsole(ReportPacker reportPacker, int time){
        printSimulationTime(time);
        printRabbitPopulation(reportPacker);
        printFoxPopulation(reportPacker);
        printRabbitDeaths(reportPacker);
    }

    public static void printSimulationCompleted(){
        System.out.println("Simulation completed.");
        System.out.println("--------------------------------------------------------------\n");
    }

    private static void printTimeElapsedMonthly(int number){
        int years = number/12;
        int months = number % 12;
        System.out.println("==============================================================");
        System.out.printf("Monthly report for %d years and %d months\n", years, months);
        System.out.println("==============================================================");
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

    private static void printFinalPopulation(long number) {
        System.out.println("The total population of Rabbits: " + myFormatter.format(number));
    }

    private static void printMalePopulation(long number) {
        System.out.println("The male population of Rabbits: " + myFormatter.format(number));
    }

    private static void printFemalePopulation(long number) {
        System.out.println("The female population of Rabbits: " + myFormatter.format(number));
    }

    private static void printRabbitAgeDeathCount(long number) {
        System.out.println("The total number of Rabbits that died: " + myFormatter.format(number));
    }

    private static void printRabbitPreyDeathCount(long number) {
        System.out.println("The total number of Rabbits that were eaten: " + myFormatter.format(number));
    }

    private static void printFoxDeathCount(long number) {
        System.out.println("The total number of Foxes that died: " + myFormatter.format(number));
    }

    public static void printEnterNumberPrompt() {
        System.out.print("Enter a number: ");
    }

    public static void printError() {
        System.err.println("Invalid input. Please enter a number with characters ranging from [0-9].");
    }

    public static void printEnterNumberOf(String timeScale) {
        System.out.print("Enter a number of " + timeScale.toLowerCase() + ": ");
    }

}
