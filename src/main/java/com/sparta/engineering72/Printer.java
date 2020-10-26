package com.sparta.engineering72;

public class Printer {
    public static void print(Object object) {
        System.out.println(object);
    }
  
    public static void printEnterNumberPrompt() {
        System.out.print("Enter a number of months: ");
    }

    public static void printError() {
        System.err.println("Invalid input. Please enter a number with characters ranging from [0-9].");
    }
}
