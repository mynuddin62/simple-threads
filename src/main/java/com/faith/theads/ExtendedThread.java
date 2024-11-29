package com.faith.theads;

import static com.faith.utility.ThreadUtils.loopToNToPrintThreadNameInEveryStepWithSleep;

public class ExtendedThread extends Thread {
    private final int loopCounter;
    private final int sleepInSecond;

    public ExtendedThread(int loopCounter, int sleepInSecond) {
        super("Extended Thread");
        this.loopCounter = loopCounter;
        this.sleepInSecond = sleepInSecond;
    }

    @Override
    public void run() {
        loopToNToPrintThreadNameInEveryStepWithSleep(loopCounter, sleepInSecond);
    }


}
