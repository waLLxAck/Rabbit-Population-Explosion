package com.sparta.engineering72.View;

import com.sparta.engineering72.Animal.Rabbit.RabbitFluffle;
import com.sparta.engineering72.Utility.ReportPacker;
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

    public static JSONObject populateJSONObject(ReportPacker reportPacker){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalRabbits", reportPacker.getTotalRabbits());
        jsonObject.put("maleRabbits", reportPacker.getMaleFoxes());
        jsonObject.put("femaleRabbits", reportPacker.getFemaleRabbits());
        jsonObject.put("totalFoxes", reportPacker.getTotalFoxes());
        jsonObject.put("maleFoxes", reportPacker.getMaleFoxes());
        jsonObject.put("femaleFoxes", reportPacker.getFemaleFoxes());
        jsonObject.put("rabbitAgeDeaths", reportPacker.getRabbitAgeDeaths());
        jsonObject.put("rabbitPreyDeaths", reportPacker.getRabbitPreyDeaths());
        jsonObject.put("foxDeaths", reportPacker.getFoxDeaths());
        return jsonObject;
    }

    public static void writeMonthlyReportToFile(BufferedWriter bufferedWriter, RabbitFluffle rabbitFluffle, int deathCount, int time) throws IOException {
        int years = time/12;
        int months = time % 12;
        bufferedWriter.write("\n==============================================================");
        bufferedWriter.write("\n Monthly report for " + years + " years and " + months + " months");
        bufferedWriter.write("\n==============================================================");
        bufferedWriter.write("\n == RABBIT POPULATION REPORT == ");
        bufferedWriter.write("\nThe total population of Rabbits: " + myFormatter.format(rabbitFluffle.getRabbitPopulationSize()));
        bufferedWriter.write("\nThe male population of Rabbits: " + myFormatter.format(rabbitFluffle.getMaleRabbitPopulation()));
        bufferedWriter.write("\nThe female population of Rabbits: " + myFormatter.format(rabbitFluffle.getFemaleRabbitPopulation()));
        bufferedWriter.write("\n == DEATH REPORT == ");
        bufferedWriter.write("\nThe total number of Rabbits that died: " + myFormatter.format(deathCount));
        bufferedWriter.write("\n==============================================================\n");
    }

    public static void printMonthlyReportToConsole(ReportPacker reportPacker, int time){
        printTimeElapsedMonthly(time);
        printRabbitPopulation(reportPacker);
        printRabbitDeaths(reportPacker);
    }

    public static void writeFinalReportToFile(BufferedWriter bufferedWriter, RabbitFluffle rabbitFluffle, int deathCount, int time) throws IOException {
        int years = time/12;
        int months = time % 12;
        bufferedWriter.write("\n\n==============================================================");
        bufferedWriter.write("\n The Simulation ran for " + years + " years and " + months + " months");
        bufferedWriter.write("\n==============================================================");
        bufferedWriter.write("\n == RABBIT POPULATION REPORT == ");
        bufferedWriter.write("\nThe total population of Rabbits: " + myFormatter.format(rabbitFluffle.getRabbitPopulationSize()));
        bufferedWriter.write("\nThe male population of Rabbits: " + myFormatter.format(rabbitFluffle.getMaleRabbitPopulation()));
        bufferedWriter.write("\nThe female population of Rabbits: " + myFormatter.format(rabbitFluffle.getFemaleRabbitPopulation()));
        bufferedWriter.write("\n == DEATH REPORT == ");
        bufferedWriter.write("\nThe total number of Rabbits that died: " + myFormatter.format(deathCount));
        bufferedWriter.write("\n==============================================================\n");
    }

    public static void printFinalReportToConsole(ReportPacker reportPacker, int time){
        printSimulationTime(time);
        printRabbitPopulation(reportPacker);
        printRabbitDeaths(reportPacker);
        printSimulationCompleted();
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
    }

    private static void printRabbitDeaths(ReportPacker reportPacker){
        System.out.println(" == DEATH REPORT == ");
        printDeathCount(reportPacker.getRabbitAgeDeaths());
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

    private static void printDeathCount(int number) {
        System.out.println("The total number of Rabbits that died: " + myFormatter.format(number));
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

    private static void printSimulationCompleted(){
        System.out.println("Simulation completed.");
        System.out.println("--------------------------------------------------------------\n");
    }
}
