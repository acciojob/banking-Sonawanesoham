package com.driver;

public class Main {
    public static void main(String[] args) {
        try {
            CurrentAccount currentAccount = new CurrentAccount("John", 6000, "ABCDE");
            currentAccount.validateLicenseId();

            SavingsAccount savingsAccount = new SavingsAccount("Alice", 3000, 1000, 0.05);
            savingsAccount.withdraw(500);

            StudentAccount studentAccount = new StudentAccount("Bob", 1000, "XYZ School");
            studentAccount.deposit(500);

            System.out.println("Current Account Balance: " + currentAccount.getBalance());
            System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
            System.out.println("Student Account Balance: " + studentAccount.getBalance());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
