package com.faith.theads;

import static com.faith.theads.ThreadUtils.printCurrentTime;
import static com.faith.theads.ThreadUtils.sleepToNSecond;

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
}
