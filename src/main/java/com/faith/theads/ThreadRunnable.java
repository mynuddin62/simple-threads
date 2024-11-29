package com.faith.theads;

import static com.faith.theads.ThreadUtils.loopToNToPrintThreadNameInEveryStepWithSleep;

public class ThreadRunnable implements Runnable{

    private final int loopCounter;
    private final int sleepInSecond;

    public ThreadRunnable(int loopCounter, int sleepInSecond) {
        this.loopCounter = loopCounter;
        this.sleepInSecond = sleepInSecond;
    }
    @Override
    public void run() {
        loopToNToPrintThreadNameInEveryStepWithSleep(loopCounter,sleepInSecond);
    }
}
