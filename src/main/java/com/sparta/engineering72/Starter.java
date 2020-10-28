package com.sparta.engineering72;

import java.io.IOException;

public class Starter {
    public static void start() {
        try {
            Printer.printStartMessage();
            Simulator.runSimulation(InputCollector.getUserInput());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
