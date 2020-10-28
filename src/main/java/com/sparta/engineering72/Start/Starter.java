package com.sparta.engineering72.Start;

import com.sparta.engineering72.UserInput.InputCollector;
import com.sparta.engineering72.View.Printer;
import com.sparta.engineering72.Animal.Rabbit.Simulator;

public class Starter {
    public static void start() {
        Printer.printStartMessage();
        Simulator.runSimulation(InputCollector.getUserInput());
    }
}
