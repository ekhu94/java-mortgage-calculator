package com.ekhu94;

import java.text.NumberFormat;

public class MortgageReport {
    public static void printMortgage(double mortgage) {
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    public static void printPaymentSchedule(double principal, double monthlyInterestRate, int months) {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (int payments = 1; payments <= months; payments++) {
            double balance = MortgageCalculator.calculateBalance(principal, monthlyInterestRate, months, payments);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance).trim());
        }
    }
}
