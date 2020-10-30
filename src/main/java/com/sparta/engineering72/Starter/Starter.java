package com.sparta.engineering72.Starter;

import com.sparta.engineering72.Input.InputCollector;
import com.sparta.engineering72.Simulation.Simulator;
import com.sparta.engineering72.SimulatorGUI;
import com.sparta.engineering72.View.Display;

public class Starter {
    public static void start() {

        chooseApplicationStart(InputCollector.getApplicationChoice());
    }

    private static void chooseApplicationStart(int input) {

        if (input == 1) {
            Display.displayStartMessage();
            Simulator.runSimulation(InputCollector.getUserInput(), InputCollector.getReportChoice());
        } else if (input == 2) {
            new SimulatorGUI("Rabbit Simulator");
        }
    }
}
