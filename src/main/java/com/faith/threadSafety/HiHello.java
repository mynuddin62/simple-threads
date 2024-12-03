package com.faith.threadSafety;

public class HiHello {
    static boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while(!flag){

            }
            System.out.println("Hello");
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            flag = true;
            System.out.println("Hi");
        });
        t2.start();
    }
}
