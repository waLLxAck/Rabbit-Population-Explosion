package com.sparta.engineering72.View;

import com.sparta.engineering72.Utility.ReportPacker;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;

public class Display {

    public static void display(ReportPacker reportPacker, int time, BufferedWriter bfTxt) throws IOException {
        Printer.printReportToConsole(reportPacker, time);
        TextFileWriter.writeReportToFile(bfTxt, reportPacker, time);
    }

    public static void displayReportChoice(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("Please choose how you want the report to be displayed:");
        System.out.println("    enter 0 for no report (data written to JSON file)");
        System.out.println("    enter 1 for a final report");
        System.out.println("    enter 2 for a month-by-month breakdown for the simulation");
        System.out.println("--------------------------------------------------------------");
    }

    public static void displayStartMessage() {
        System.out.println("\nWELCOME TO THE RABBIT SIMULATOR");
        System.out.println("-------------------------------");
        System.out.println("All required user inputs should be entered in the console when prompted");
        System.out.println("The final report from the simulation will also be displayed in the console");
        System.out.println("-------------------------------");
    }

    public static void displaySimulationStart(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("The Simulation starts off with 1 male and 1 female rabbit");
        System.out.println("The Simulation is starting now...");
        System.out.println("--------------------------------------------------------------\n");
    }

    public static void displaySimulationCompleted(){
        System.out.println("Simulation completed.");
        System.out.println("--------------------------------------------------------------\n");
    }

    public static void displayError() {
        System.err.println("Invalid input. Please enter a number with characters ranging from [0-9].");
    }

    public static void displayEnterNumberOf(String timeScale) {
        System.out.print("Enter a number of " + timeScale.toLowerCase() + ": ");
    }

}
