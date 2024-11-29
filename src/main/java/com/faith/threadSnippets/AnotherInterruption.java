package com.faith.threadSnippets;

public class AnotherInterruption {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread sleeping...");
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                System.out.println("Interrupted while sleeping!");
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        thread.start();

        try {
            Thread.sleep(2000); // Main thread waits for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt(); // Interrupt the sleeping thread
    }
}

