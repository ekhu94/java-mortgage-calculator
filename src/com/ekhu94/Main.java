package com.ekhu94;

public class Main {

    public static void main(String[] args) {
        double principal = Console.getNumber("Principal ($1K - $1M): ", 1000, 1_000_000);

        double interestRate = Console.getNumber("Annual Interest Rate: ", 1, 30);

        int years = (int) Console.getNumber("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, interestRate, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }
}
