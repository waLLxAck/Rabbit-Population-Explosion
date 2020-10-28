package com.sparta.engineering72;

public class Starter {
    public static void start() {
        Printer.printStartMessage();
        Simulator.runSimulation(InputCollector.getUserInput());
    }
}
