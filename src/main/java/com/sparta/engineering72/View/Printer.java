package com.sparta.engineering72.View;

public class Printer {
    public static void print(Object object) {
        System.out.println(object);
    }

    public static void printStartMessage() {
        System.out.println("The Simulation will now begin");
        System.out.println("All required user inputs should be entered in the console when prompted");
        System.out.println("The final report from the simulation will also be displayed in the console");
    }

    public static void printSimulationTime(int number) {
        int years = number/12;
        int months = number % 12;
        System.out.printf("The Simulation ran for %d years and %d months", years, months);
    }

    public static void printFinalPopulation(int number) {
        System.out.println("The total population of Rabbits at the end of the simulation: " +number);
    }

    public static void printMalePopulation(int number) {
        System.out.println("The male population of Rabbits at the end of the simulation: " +number);
    }

    public static void printFemalePopulation(int number) {
        System.out.println("The female population of Rabbits at the end of the simulation: " +number);
    }

    public static void printDeathCount(int number) {
        System.out.println("The total number of Rabbits that died: " + number);
    }

    public static void printEnterNumberPrompt() {
        System.out.print("Enter a number: ");
    }

    public static void printError() {
        System.err.println("Invalid input. Please enter a number with characters ranging from [0-9].");
    }

    public static void printEnterNumberOf(String timeScale) {
        System.out.print("Enter a number of "+timeScale.toLowerCase()+": ");
    }
}
