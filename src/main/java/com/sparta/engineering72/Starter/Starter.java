package com.sparta.engineering72.Starter;

import com.sparta.engineering72.Input.InputCollector;
import com.sparta.engineering72.Simulation.Simulator;
import com.sparta.engineering72.View.Printer;

public class Starter {
    public static void start() {
        Printer.printStartMessage();
        Simulator.runSimulation(InputCollector.getUserInput(), InputCollector.getReportChoice());
    }
}
