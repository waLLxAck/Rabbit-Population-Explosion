package com.sparta.engineering72.Starter;

import com.sparta.engineering72.Input.InputCollector;
import com.sparta.engineering72.Simulation.Simulator;
import com.sparta.engineering72.View.Display;
import com.sparta.engineering72.View.Printer;

public class Starter {
    public static void start() {
        Display.displayStartMessage();
        Simulator.runSimulation(InputCollector.getUserInput(), InputCollector.getReportChoice());
    }
}
