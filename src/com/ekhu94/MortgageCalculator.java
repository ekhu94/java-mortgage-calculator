package com.ekhu94;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    public static void printMortgage() {

        double principal = getNumber("Principal ($1K - $1M): ", 1000, 1_000_000);

        double interestRate = getNumber("Annual Interest Rate: ", 1, 30);

        int years = (int) getNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, interestRate, years);
        String result = NumberFormat.getCurrencyInstance().format(mortgage).trim();
        System.out.println("Mortgage: " + result);
    }

    private static double getNumber(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
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

    private static double calculateMortgage(double principal, double interestRate, int years) {
        final int MONTHS_IN_A_YEAR = 12;
        final int PERCENTAGE = 100;
        int months = years * MONTHS_IN_A_YEAR;
        double monthlyInterestRate = interestRate / MONTHS_IN_A_YEAR / PERCENTAGE;
        return principal * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) / (Math.pow(1 + monthlyInterestRate, months) - 1));
    }
}
