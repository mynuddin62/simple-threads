package com.faith.theads;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FibonacciTask implements Runnable{
    private final long n;
    private final String id;

    public FibonacciTask(long n, String id) {
        this.n = n;
        this.id = id;
    }

    private BigDecimal fibonacci(long n) {
        if(n == 0) return BigDecimal.ZERO;
        else if(n == 1) return BigDecimal.ONE;
        else {
            return fibonacci(n -1).add(fibonacci(n - 2));
        }
    }

    @Override
    public void run() {
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        System.out.println("Starting Task " + id + " at " + isoFormatter.format(LocalDateTime.now()));
        fibonacci(n);
        System.out.println("Ending Task " + id + " at " + isoFormatter.format(LocalDateTime.now()));
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new FibonacciTask(45, "Fibonacci Task ~ 1"));
        Thread t2 = new Thread(new FibonacciTask(45, "Fibonacci Task ~ 2"));
        Thread t3 = new Thread(new FibonacciTask(45, "Fibonacci Task ~ 3"));
        Thread t4 = new Thread(new FibonacciTask(45, "Fibonacci Task ~ 4"));
        Thread t5 = new Thread(new FibonacciTask(45, "Fibonacci Task ~ 5"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

    }
}
