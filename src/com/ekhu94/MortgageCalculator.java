package com.ekhu94;

public class MortgageCalculator {

    private double principal;
    private double monthlyInterestRate;
    private int months;

    public MortgageCalculator(double principal, double monthlyInterestRate, int months) {
        this.principal = principal;
        this.monthlyInterestRate = monthlyInterestRate;
        this.months = months;
    }

    public double calculateMortgage() {
        return principal * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) / (Math.pow(1 + monthlyInterestRate, months) - 1));
    }

    public double calculateBalance(int paymentsMade) {
        return principal * ((Math.pow(1 + monthlyInterestRate, months) - Math.pow(1 + monthlyInterestRate, paymentsMade)) / (Math.pow(1 + monthlyInterestRate, months) - 1));
    }

    public int getMonths() {
        return months;
    }
}
