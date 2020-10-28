package com.sparta.engineering72.View;

import com.sparta.engineering72.Animal.Rabbit.RabbitFluffle;

import java.io.BufferedWriter;
import java.io.IOException;

public class Printer {
    public static void print(Object object) {
        System.out.println(object);
    }

    public static void printReportChoice(){
        System.out.println("Please choose how you want the report to be displayed:");
        System.out.println("Enter 1 for a Final report");
        System.out.println("Enter 2 for a month by month breakdown for the simulation");
    }

    public static void printStartMessage() {
        System.out.println("\nWELCOME TO THE RABBIT SIMULATOR");
        System.out.println("-------------------------------");
        System.out.println("All required user inputs should be entered in the console when prompted");
        System.out.println("The final report from the simulation will also be displayed in the console");
        System.out.println("-------------------------------");
    }

    public static void printSimulationStart(){
        System.out.println("-------------------------------");
        System.out.println("The Simulation starts off with 1 male and 1 female rabbit");
        System.out.println("The Simulation is starting now...");
        System.out.println("-------------------------------\n");
    }

    private static void printSimulationCompleted(){
        System.out.println("Simulation completed.");
        System.out.println("-------------------------------");
    }

    public static void printMonthlyReport(RabbitFluffle rabbitFluffle, int deathCount, int time){
        printTimeElapsedMonthly(time);
        printRabbitPopulation(rabbitFluffle);
        printRabbitDeaths(deathCount);
    }

    public static void writeMonthlyReportToFile(BufferedWriter bufferedWriter, RabbitFluffle rabbitFluffle, int deathCount, int time) throws IOException {
        int years = time/12;
        int months = time % 12;
        bufferedWriter.write("\n==============================================================");
        bufferedWriter.write("\n Monthly report for " + years + " years and " + months + " months");
        bufferedWriter.write("\n==============================================================");
        bufferedWriter.write("\n == RABBIT POPULATION REPORT == ");
        bufferedWriter.write("\nThe total population of Rabbits: " + rabbitFluffle.getRabbitPopulationSize());
        bufferedWriter.write("\nThe male population of Rabbits: " + rabbitFluffle.getMaleRabbitPopulation());
        bufferedWriter.write("\nThe female population of Rabbits: " + rabbitFluffle.getFemaleRabbitPopulation());
        bufferedWriter.write("\n == DEATH REPORT == ");
        bufferedWriter.write("\nThe total number of Rabbits that died: " + deathCount);
        bufferedWriter.write("\n-------------------------------");
    }

    public static void writeFinalReportToFile(BufferedWriter bufferedWriter, RabbitFluffle rabbitFluffle, int deathCount, int time) throws IOException {
        int years = time/12;
        int months = time % 12;
        bufferedWriter.write("\n\n==============================================================");
        bufferedWriter.write("\n The Simulation ran for " + years + " years and " + months + " months");
        bufferedWriter.write("\n==============================================================");
        bufferedWriter.write("\n == RABBIT POPULATION REPORT == ");
        bufferedWriter.write("\nThe total population of Rabbits: " + rabbitFluffle.getRabbitPopulationSize());
        bufferedWriter.write("\nThe male population of Rabbits: " + rabbitFluffle.getMaleRabbitPopulation());
        bufferedWriter.write("\nThe female population of Rabbits: " + rabbitFluffle.getFemaleRabbitPopulation());
        bufferedWriter.write("\n == DEATH REPORT == ");
        bufferedWriter.write("\nThe total number of Rabbits that died: " + deathCount);
        bufferedWriter.write("\n-------------------------------");
    }

    public static void printFinalReport(RabbitFluffle rabbitFluffle, int deathCount, int time){
        printSimulationTime(time);
        printRabbitPopulation(rabbitFluffle);
        printRabbitDeaths(deathCount);
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

    private static void printRabbitPopulation(RabbitFluffle rabbitFluffle){
        System.out.println(" == RABBIT POPULATION REPORT == ");
        printFinalPopulation(rabbitFluffle.getRabbitPopulationSize());
        printMalePopulation(rabbitFluffle.getMaleRabbitPopulation());
        printFemalePopulation(rabbitFluffle.getFemaleRabbitPopulation());
    }

    private static void printRabbitDeaths(int number){
        System.out.println(" == DEATH REPORT == ");
        printDeathCount(number);
        System.out.println("-------------------------------\n");
    }

    private static void printFinalPopulation(int number) {
        System.out.println("The total population of Rabbits: " +number);
    }

    private static void printMalePopulation(int number) {
        System.out.println("The male population of Rabbits: " +number);
    }

    private static void printFemalePopulation(int number) {
        System.out.println("The female population of Rabbits: " +number);
    }

    private static void printDeathCount(int number) {
        System.out.println("The total number of Rabbits that died: " + number);
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
