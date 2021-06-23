package com.ekhu94;

public class Main {

    private static final int MONTHS_IN_A_YEAR = 12;
    private static final int PERCENTAGE = 100;

    public static void main(String[] args) {
        double principal = Console.getNumber("Principal ($1K - $1M): ", 1000, 1_000_000);

        double interestRate = Console.getNumber("Annual Interest Rate: ", 1, 30);

        int years = (int) Console.getNumber("Period (Years): ", 1, 30);

        double monthlyInterestRate = interestRate / MONTHS_IN_A_YEAR / PERCENTAGE;
        int months = years * MONTHS_IN_A_YEAR;
        var calculator = new MortgageCalculator(principal, monthlyInterestRate, months);
        var report = new MortgageReport(calculator);
        double mortgage = calculator.calculateMortgage();

        report.printMortgage();
        report.printPaymentSchedule();
    }
}
