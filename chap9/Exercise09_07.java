/*
Author: Aiden Olsen
Date: 02/28/2025

This program is for an Account class example
 */

public class Exercise09_07 {
    public static void main(String[] args) {
        Account account1 = new Account(1122, 20000.0);
        account1.setAnnualInterestRate(4.5);
        account1.withdraw(2500.0);
        account1.deposit(3000.0);
        printAccount(account1);
    }

    public static void printAccount(Account account) {
        System.out.printf("\nAccount #%d\n", account.getId());
        System.out.printf("Created %s\n\n", account.getDateCreated().toString());
        System.out.printf("\tCurrent Balance :  $%.2f\n", account.getBalance());
        System.out.printf("\tAnnual Int. Rate:  %.2f%%\n", account.getAnnualInterestRate());
        System.out.printf("\tMonthly Interest: +$%.2f\n\n", account.getMonthlyInterest());
    }
}

class Account {
    // Attributes
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private java.util.Date dateCreated = new java.util.Date();

    // Constructors
    public Account() {
    }
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    // Accessor methods for id/bal/air/date
    public int getId() { return this.id; }
    public double getBalance() { return this.balance; }
    public double getAnnualInterestRate() { return this.annualInterestRate; }
    public java.util.Date getDateCreated() { return this.dateCreated; }

    // Mutator methods for id/bal/air
    public void setId(int id) { this.id = id; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setAnnualInterestRate(double annualInterestRate) { this.annualInterestRate = annualInterestRate; }

    // Action methods for monthly interest and money manipulation
    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12.0;
    }
    public double getMonthlyInterest() {
        return balance * (this.annualInterestRate / 1200.0);
    }
    public void deposit(double amount) {
        this.balance += amount;
        System.out.printf("Deposited $%.2f.\n", amount);
    }
    public void withdraw(double amount) {
        this.balance -= amount;
        System.out.printf("Withdrew $%.2f.\n", amount);
    }
}