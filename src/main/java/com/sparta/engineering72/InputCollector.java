package com.sparta.engineering72;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCollector {
    public static int getUserInput() {
        int numberOfMonths = -1;
        int numberOfYears = -1;
        do {
            if (numberOfMonths < 0) {
                numberOfMonths = getInteger("Months");
                continue;
            }
            if (numberOfYears < 0) {
                numberOfYears = getInteger("Years");
                continue;
            }
            if (numberOfMonths > 0 && numberOfYears > 0) {
                int totalMonths = numberOfMonths+numberOfYears*12;
                Printer.print(totalMonths);
                return totalMonths;
            }
        } while (true);
    }

    private static int getInteger(String timeScale) {
        Scanner input = new Scanner(System.in);
        int numberOfMonths;
        Printer.printEnterNumberOf(timeScale);
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
        }
        return -1;
    }
}
