package com.ekhu94;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    private static final int MONTHS_IN_A_YEAR = 12;
    private static final int PERCENTAGE = 100;

    public static void printMortgage() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal ($1K - $1M): ");
        double principal = scanner.nextDouble();
        while (principal < 1000 || principal > 1_000_000) {
            System.out.println("Enter a number between 1,000 and 1,000,000.");
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextDouble();
        }

        System.out.print("Annual Interest Rate: ");
        double interestRate = scanner.nextDouble();
        while (interestRate <= 0 || interestRate > 30) {
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
            System.out.print("Annual Interest Rate: ");
            interestRate = scanner.nextDouble();
        }

        System.out.print("Period (Years): ");
        int years = scanner.nextInt();
        while (years < 1 || years > 30) {
            System.out.println("Enter a value between 1 and 30.");
            System.out.print("Period (Years): ");
            years = scanner.nextInt();
        }
        int months = years * MONTHS_IN_A_YEAR;
        double monthlyInterestRate = interestRate / MONTHS_IN_A_YEAR / PERCENTAGE;
        double mortgage = calculateMortgage(principal, monthlyInterestRate, months);
        String result = NumberFormat.getCurrencyInstance().format(mortgage).trim();
        System.out.println("Mortgage: " + result);

        scanner.close();
    }

    private static double calculateMortgage(double principal, double interestRate, int months) {
        return principal * ((interestRate * Math.pow(1 + interestRate, months)) / (Math.pow(1 + interestRate, months) - 1));
    }
}
