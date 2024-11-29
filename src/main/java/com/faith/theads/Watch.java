package com.faith.theads;

import java.util.concurrent.TimeUnit;

import static com.faith.utility.ThreadUtils.printCurrentTime;
import static com.faith.utility.ThreadUtils.sleepToNSecond;

public class Watch implements Runnable {
    private boolean running = true;

    public void shutdown() {
        this.running = false;
    }

    @Override
    public void run() {
        while (running) {
            printCurrentTime();
            sleepToNSecond(1);
        }
    }

    public static void main(String[] args) {
        /*Making Watch*/
        Watch watch = new Watch();
        Thread watchThread = new Thread(watch, "Watch Thread");
        watchThread.start();

        try {
            Thread.currentThread().sleep(TimeUnit.SECONDS.toMillis(1));
            //watch.shutdown();
        }
        catch (InterruptedException ignored) {
            //throw new RuntimeException(e);
        }
    }
}
