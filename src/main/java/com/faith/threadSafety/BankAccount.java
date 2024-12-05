package com.faith.threadSafety;

public class BankAccount {
    private volatile long balance;

    public BankAccount(long balance) {
        this.balance = balance;
    }

    public void withdraw(long amount){
        System.out.println("Withdrawing " + amount);
        long newBalance = balance - amount;
        System.out.println("New balance is: " + newBalance);
        balance = newBalance;
    }

    public void deposit(long amount){
        System.out.println("Depositing " + amount);
        long newBalance = balance + amount;
        System.out.println("New balance is: " + newBalance);
        balance = newBalance;
    }

    public long getBalance(){
        return balance;
    }

}
