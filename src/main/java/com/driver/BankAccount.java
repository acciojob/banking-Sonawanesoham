package com.driver;

import java.util.Arrays;
import java.util.Random;

public class BankAccount {
    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        if (digits <= 0 || sum < 0 || sum > 9 * digits) {
            throw new Exception("Account Number cannot be generated");
        }

        Random random = new Random();
        int[] accountNumber = new int[digits];

        for (int i = 0; i < digits - 1; i++) {
            int maxDigit = Math.min(9, sum - (digits - 1 - i));
            int digit = random.nextInt(maxDigit + 1);
            accountNumber[i] = digit;
            sum -= digit;
        }

        if (sum > 9) {
            throw new Exception("Account Number cannot be generated");
        }

        accountNumber[digits - 1] = sum;

        StringBuilder accountNumberStr = new StringBuilder();
        for (int digit : accountNumber) {
            accountNumberStr.append(digit);
        }

        return accountNumberStr.toString();
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }

    // Getter and Setter for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
