/*
Author: Aiden Olsen
Date: 03/06/2025

This program is for an Checkings/Savings-Account subclass example
 */

public class Exercise11_03 {
    public static void main(String[] args) {
        Account account1 = new SavingsAccount(23, 3445.56);
        Account account2 = new CheckingAccount(45, 34.23, 300.0);
        System.out.print(account1.toString());
        System.out.print(account2.toString());
        System.out.print("Withdrawing $245.87 from Account #45.\n");
        account2.withdraw(245.87);
        System.out.print(account2.toString());
        System.out.print("Withdrawing $245.87 from Account #45.\n");
        account2.withdraw(245.87);
        System.out.print(account2.toString());
    }


}

class SavingsAccount extends Account {
    //constructors
    public SavingsAccount() {
        this.accountType = "savings";
    }
    public SavingsAccount(int id, double balance) {
        this.accountType = "savings";
        this.id = id;
        this.balance = balance;
    }
}
class CheckingAccount extends Account {
    //attributes
    protected double overdraftLimit;

    //constructors
    public CheckingAccount() {
        this.accountType = "checking";
        this.canOverdraw = true;
    }
    public CheckingAccount(int id, double balance, double overdraftLimit) {
        this.accountType = "checking";
        this.canOverdraw = true;
        this.id = id;
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
    }
}

class Account {
    //attributes
    protected int id = 0;
    protected double balance = 0;
    protected double annualInterestRate = 0;
    protected java.util.Date dateCreated = new java.util.Date();
    protected boolean canOverdraw = false;
    protected String accountType = "default";

    //constructors
    public Account() {}

    //accessors
    public int getId() { return this.id; }
    public double getBalance() { return this.balance; }
    public double getAnnualInterestRate() { return this.annualInterestRate; }
    public java.util.Date getDateCreated() { return this.dateCreated; }

    //mutators
    public void setId(int id) { this.id = id; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setAnnualInterestRate(double annualInterestRate) { this.annualInterestRate = annualInterestRate; }

    //methods
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("\nAccount #%d (%s)\nCreated %s\n\n\tCurrent Balance :  $%.2f\n",
                this.getId(), this.accountType, this.getDateCreated().toString(), this.getBalance()));
        if (accountType == "checking")
            stringBuilder.append(String.format("\tOverdraft Limit :  $%.2f\n", ((CheckingAccount)this).overdraftLimit));
        stringBuilder.append(String.format("\tAnnual Int. Rate:  %.2f%%\n\n", this.getAnnualInterestRate()));
        return stringBuilder.toString();
    }
    public void deposit(double amount) {
        this.balance += amount;
        System.out.printf("Deposited $%.2f.\n", amount);
    }
    public void withdraw(double amount) {
        if (!((this.balance < amount) && this.canOverdraw && ((this.balance + ((CheckingAccount)this).overdraftLimit) >= amount))) {
            System.out.print("That's more than you can withdraw.\n");
            return;
        }
        this.balance -= amount;
        System.out.printf("Withdrew $%.2f.\n", amount);
    }
}