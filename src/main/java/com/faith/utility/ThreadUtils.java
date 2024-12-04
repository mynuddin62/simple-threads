package com.faith.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public final class ThreadUtils {

    private ThreadUtils(){}

    public static void sleepToNSecond(Integer a) {
        try {
            int seconds= 1;
            if(a != null ) seconds = a;
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
        } catch (InterruptedException ignored) {}
    }

    public static void sleepToNMillis(Integer a) {
        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }

    public static void loopToNToPrintThreadNameInEveryStepWithSleep(int n, int sleepInSecond){
        for (int i = 0; i < n; i++) {
            System.out.println("[" + i + "] - Inside : " + Thread.currentThread().getName());
            sleepToNSecond(sleepInSecond);
        }
    }

    public static void printCurrentTime() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss a")));
    }
}
