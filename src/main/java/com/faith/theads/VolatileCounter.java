package com.faith.theads;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileCounter {
    //private int count = 0;
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        //count++;
        counter.incrementAndGet();
    }

    public int getCount() {
        //return count;
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCounter vc = new VolatileCounter();

        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++){
                vc.increment();
            }
        }, "Writer Thread");

        Thread readerThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++){
                vc.increment();
            }
        }, "Reader Thread");

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();


        System.out.println(vc.getCount());
    }

}
