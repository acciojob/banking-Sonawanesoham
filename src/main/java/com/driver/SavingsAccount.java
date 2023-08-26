package com.driver;

public class SavingsAccount extends BankAccount {
    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance, 0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceeded");
        }
        if (amount > getBalance()) {
            throw new Exception("Insufficient Balance");
        }
        setBalance(getBalance() - amount);
    }

    public double getSimpleInterest(int years) {
        return getBalance() + (getBalance() * rate * years);
    }

    public double getCompoundInterest(int times, int years) {
        return getBalance() * Math.pow(1 + (rate / times), times * years);
    }
}

