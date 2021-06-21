package com.ekhu94;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    private static final int MONTHS_IN_A_YEAR = 12;
    private static final int PERCENTAGE = 100;

    public static void run() {

        double principal = getNumber("Principal ($1K - $1M): ", 1000, 1_000_000);

        double interestRate = getNumber("Annual Interest Rate: ", 1, 30);

        int years = (int) getNumber("Period (Years): ", 1, 30);

        double monthlyInterestRate = interestRate / MONTHS_IN_A_YEAR / PERCENTAGE;
        int months = years * MONTHS_IN_A_YEAR;
        double mortgage = calculateMortgage(principal, monthlyInterestRate, months);

        printMortgage(mortgage);
        printPaymentSchedule(principal, monthlyInterestRate, months);
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

    private static double calculateMortgage(double principal, double monthlyInterestRate, int months) {
        return principal * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) / (Math.pow(1 + monthlyInterestRate, months) - 1));
    }

    private static double calculateBalance(double principal, double monthlyInterestRate, int months, int paymentsMade) {
        return principal * ((Math.pow(1 + monthlyInterestRate, months) - Math.pow(1 + monthlyInterestRate, paymentsMade)) / (Math.pow(1 + monthlyInterestRate, months) - 1));
    }

    private static void printMortgage(double mortgage) {
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    private static void printPaymentSchedule(double principal, double monthlyInterestRate, int months) {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (int payments = 1; payments <= months; payments++) {
            double balance = calculateBalance(principal, monthlyInterestRate, months, payments);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance).trim());
        }
    }
}
