package com.faith.theads;

public class SharedObject {
    private volatile boolean flag = false;

    public void setFlagTrue() {
        System.out.println("Setting Flag to True ...");
        this.flag = true;
    }

    public void printFlag() {
        while(!flag);
//        {
//            System.out.println("Flag is False Here ... ");
//        }
        System.out.println("Flag is true!");
    }
}
