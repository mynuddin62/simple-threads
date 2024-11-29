package com.faith.theads;

import java.util.concurrent.TimeUnit;

public class ThreadLifeCycle {
    //@lombok.SneakyThrows
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->  {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "My Thread # 1");
        t1.start();

        Thread t2 = new Thread(() ->  {
            while (!Thread.interrupted()) {
                System.out.println("Running");
            }
        }, "My Thread # 2");
        t2.start();

        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.interrupt();
    }
}
