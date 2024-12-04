package com.faith.threadSafety;

import static com.faith.utility.ThreadUtils.sleepToNMillis;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);
        Thread depositThread = new Thread(()-> {
            for (int i = 0; i < 100; i++){
                bankAccount.deposit(100);
                sleepToNMillis(1);
            }
        });

        Thread withdrawThread = new Thread(()-> {
            for (int i = 0; i < 100; i++){
                bankAccount.withdraw(100);
                sleepToNMillis(1);
            }
        });

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Current balance available in account: " + bankAccount.getBalance());
    }
}
