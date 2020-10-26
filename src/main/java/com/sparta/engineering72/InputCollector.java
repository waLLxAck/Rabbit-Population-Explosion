package com.sparta.engineering72;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCollector {
    public static int getUserInput() {
        int numberOfMonths;
        Scanner input = new Scanner(System.in);
        Printer.printEnterNumberPrompt();
        do {
            try {
                numberOfMonths = input.nextInt();
                if (numberOfMonths < 0) {
                    throw new InputMismatchException("Invalid input");
                }
                return numberOfMonths;
            } catch (InputMismatchException ime) {
                Logger.logError(ime, "Invalid input");
                Printer.printError();
                Sleeper.sleep(100);
                Printer.printEnterNumberPrompt();
                input = new Scanner(System.in);
            }
        } while (true);
    }
}
