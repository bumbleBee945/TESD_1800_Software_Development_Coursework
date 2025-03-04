/*
Author: Aiden Olsen
Date: 03/04/2025

This program is for an advanced Account class example
 */

import java.util.Scanner;

public class Exercise10_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account[] accountArray = new Account[10];
        for (int i = 0; i < 10; i++) //fill account array
            accountArray[i] = new Account(i, 100.0);
        String givenValue;
        int givenId;
        int usedId;
        int usedOption;
        int exitOptions;
        double usedDouble;
        while (true) { //main loop
            System.out.print("Enter an account ID (0-9): ");
            givenValue = input.nextLine();
            if (!givenValue.matches("[0-9]")) { //valid id checker (checks if it's one character, 0-9)
                System.out.print("That ID is invalid. It must be 0 to 9.\n\n");
                continue;
            }
            usedId = Integer.parseInt(givenValue);
            exitOptions = 0;
            System.out.printf("ID #%d accepted.\n", usedId);
            while (exitOptions == 0) { //option loop
                System.out.print("[1] View account\n[2] Withdraw money\n");
                System.out.print("[3] Deposit money\n[4] Exit to ID menu\n[-] ");
                givenValue = input.nextLine();
                if (!givenValue.matches("[1-4]")) {
                    System.out.print("That input is invalid. It must be 1, 2, 3, or 4.\n");
                    continue;
                }
                usedOption = Integer.parseInt(givenValue);
                switch (usedOption) {
                    case 1:
                        System.out.print("\n");
                        printAccount(accountArray[usedId]);
                        while (true) {
                            System.out.print("[1] Exit to account menu\n[-] ");
                            givenValue = input.nextLine();
                            if (!givenValue.matches("1")) {
                                System.out.print("That input is invalid. It must be 1.\n");
                                continue;
                            }
                            break;
                        }
                        break;
                    case 2:
                        while (true) { //amount loop
                            System.out.print("How much would you like to withdraw? $");
                            givenValue = input.nextLine(); //v checks if it's a positive double
                            if (!(givenValue.matches("[0-9]+(|.[0-9]+)") && (Double.parseDouble(givenValue) > 0.0))) {
                                System.out.print("That amount is invalid.\nIt must be at least 0.01, and contain only 0-9 and '.'\n");
                                continue;
                            }
                            usedDouble = Double.parseDouble(givenValue);
                            if (usedDouble > accountArray[usedId].getBalance())
                                System.out.printf("You don't have that much in your account.\nYou have $%.2f.\n", accountArray[usedId].getBalance());
                            else {
                                accountArray[usedId].withdraw(usedDouble);
                                System.out.printf("You've withdrawn $%.2f.\nYou now have $%.2f.\n", usedDouble, accountArray[usedId].getBalance());
                            }
                            while (true) { //repeat/return loop
                                System.out.print("[1] Withdraw more\n[2] Exit to account menu\n[-] ");
                                givenValue = input.nextLine();
                                if (!givenValue.matches("[1-2]")) {
                                    System.out.print("That input is invalid. It must be 1 or 2.\n");
                                    continue;
                                }
                                break;
                            }
                            switch (Integer.parseInt(givenValue)) {
                                case 1:
                                    continue;
                                case 2:
                                    break;
                            }
                            break;
                        }
                        break;
                    case 3:
                        while (true) { //amount loop
                            System.out.print("How much would you like to deposit? $");
                            givenValue = input.nextLine(); //v checks if it's a positive double
                            if (!(givenValue.matches("[0-9]+(|.[0-9]+)") && (Double.parseDouble(givenValue) > 0))) {
                                System.out.print("That amount is invalid.\nIt must be at least 0.01, and contain only 0-9 and '.'\n");
                                continue;
                            }
                            usedDouble = Double.parseDouble(givenValue);
                            accountArray[usedId].deposit(usedDouble);
                            System.out.printf("You've deposited $%.2f.\nYou now have $%.2f.\n", usedDouble, accountArray[usedId].getBalance());
                            while (true) { //repeat/return loop
                                System.out.print("[1] Deposit more\n[2] Exit to account menu\n[-] ");
                                givenValue = input.nextLine();
                                if (!givenValue.matches("[1-2]")) {
                                    System.out.print("That input is invalid. It must be 1 or 2.\n");
                                    continue;
                                }
                                break;
                            }
                            switch (Integer.parseInt(givenValue)) {
                                case 1:
                                    continue;
                                case 2:
                                    break;
                            }
                            break;
                        }
                        break;
                    case 4:
                        System.out.print("\n\n");
                        exitOptions = 1;
                        break;
                }
            }
        }
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