package com.ekhu94;

import java.text.NumberFormat;

public class MortgageCalculator {

    public static final int MONTHS_IN_A_YEAR = 12;
    public static final int PERCENTAGE = 100;

    private double principal;
    private double annualInterestRate;
    private int years;

    public MortgageCalculator(double principal, double annualInterestRate, int years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateMortgage() {
        return principal * ((getMonthlyInterestRate() * Math.pow(1 + getMonthlyInterestRate(), getMonths())) / (Math.pow(1 + getMonthlyInterestRate(), getMonths()) - 1));
    }

    public double calculateBalance(int paymentsMade) {
        return principal * ((Math.pow(1 + getMonthlyInterestRate(), getMonths()) - Math.pow(1 + getMonthlyInterestRate(), paymentsMade)) / (Math.pow(1 + getMonthlyInterestRate(), getMonths()) - 1));
    }

    public double[] getRemainingBalances() {
        var balances = new double[getMonths()];
        for (int payments = 1; payments <= getMonths(); payments++) {
            balances[payments - 1] = calculateBalance(payments);
        }
        return balances;
    }

    public int getMonths() {
        return years * MONTHS_IN_A_YEAR;
    }

    private double getMonthlyInterestRate() {
        return annualInterestRate / MONTHS_IN_A_YEAR / PERCENTAGE;
    }
}
