package com.ekhu94;

public class MortgageCalculator {

    private static final int MONTHS_IN_A_YEAR = 12;
    private static final int PERCENTAGE = 100;

    public static void run() {

        double principal = Console.getNumber("Principal ($1K - $1M): ", 1000, 1_000_000);

        double interestRate = Console.getNumber("Annual Interest Rate: ", 1, 30);

        int years = (int) Console.getNumber("Period (Years): ", 1, 30);

        double monthlyInterestRate = interestRate / MONTHS_IN_A_YEAR / PERCENTAGE;
        int months = years * MONTHS_IN_A_YEAR;
        double mortgage = calculateMortgage(principal, monthlyInterestRate, months);

        MortgageReport.printMortgage(mortgage);
        MortgageReport.printPaymentSchedule(principal, monthlyInterestRate, months);
    }

    private static double calculateMortgage(double principal, double monthlyInterestRate, int months) {
        return principal * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) / (Math.pow(1 + monthlyInterestRate, months) - 1));
    }

    public static double calculateBalance(double principal, double monthlyInterestRate, int months, int paymentsMade) {
        return principal * ((Math.pow(1 + monthlyInterestRate, months) - Math.pow(1 + monthlyInterestRate, paymentsMade)) / (Math.pow(1 + monthlyInterestRate, months) - 1));
    }

}
