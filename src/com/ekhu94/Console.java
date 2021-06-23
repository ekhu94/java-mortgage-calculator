package com.ekhu94;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double getNumber(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public static double getNumber(String prompt, int min, int max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Value should be between " + min + " and " + max + ".");
        }
        return value;
    }
}
