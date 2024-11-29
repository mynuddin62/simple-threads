package com.faith;


import com.faith.theads.ExtendedThread;
import com.faith.theads.ThreadRunnable;

import static com.faith.theads.ThreadUtils.loopToNToPrintThreadNameInEveryStepWithSleep;

/**
 * Hello world!
 *
 */
public class App {
    private static final int loopCounter = 10;
    private static int sleepInSecond = 5;

    public static void main(String[] args) {

        /*Thread Creation By Different Types Start*/
        ExtendedThread extendedThread = new ExtendedThread(loopCounter, sleepInSecond);
        extendedThread.start();
        --sleepInSecond;

        Thread innerClassThread = new Thread(new Runnable() {
            @Override
            public void run() {
                loopToNToPrintThreadNameInEveryStepWithSleep(loopCounter,sleepInSecond);
            }
        }, "Inner Class Thread");
        innerClassThread.start();
        --sleepInSecond;

        Thread lambdaThread = new Thread(
                () -> loopToNToPrintThreadNameInEveryStepWithSleep(loopCounter,sleepInSecond),
                "Lambda Thread"
        );
        lambdaThread.start();
        --sleepInSecond;



        Thread runnableThread = new Thread(new ThreadRunnable(loopCounter, sleepInSecond));
        runnableThread.setName("Runnable");
        runnableThread.start();
        --sleepInSecond;

        Thread.currentThread().setName("Main");
        loopToNToPrintThreadNameInEveryStepWithSleep(loopCounter,sleepInSecond);
        /*Thread Creation By Different Types End*/



        /*Thread t = new Thread(() -> {
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
        t.interrupt();*/

    }
}
