package com.sparta.engineering72;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCollector {
    public static int getUserInput() {
        int numberOfYears = -1;
        int numberOfMonths = -1;
        int totalMonths;
        do {
            if (numberOfYears < 0) {
                numberOfYears = getTime("Years");
                continue;
            }
            if (numberOfMonths < 0 || (numberOfYears == 0 && numberOfMonths <= 0)) {
                numberOfMonths = getTime("Months");
                continue;
            }
            totalMonths = numberOfMonths+numberOfYears*12;
            return totalMonths;

        } while (true);
    }

    private static int getTime(String timeScale) {
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
