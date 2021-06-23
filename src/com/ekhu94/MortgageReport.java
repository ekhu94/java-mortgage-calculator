package com.ekhu94;

import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }
    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (int payments = 1; payments <= calculator.getMonths(); payments++) {
            double balance = calculator.calculateBalance(payments);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance).trim());
        }
    }
}
