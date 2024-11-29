package com.faith.threadSnippets;

public class InterruptSnippets {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread going to sleep...");
                Thread.sleep(5000); // Block for 5 seconds
            } catch (InterruptedException e) {
                System.out.println("Interrupted during sleep. Re-interrupting the thread.");
                Thread.currentThread().interrupt(); // Re-set interrupted status
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is interrupted. Exiting gracefully.");
            }
        });

        t.start();
        t.interrupt();
    }
}
