package com.mainacad.method.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class SynchClass {
    private CountDownLatch cdLatch = new CountDownLatch(5);
    private int number = 0;

    public int getNumber() {
        try {
            System.out.println("I am waiting");
            cdLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I have return");
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        cdLatch.countDown();
        System.out.println(cdLatch.getCount() + " left");
    }
}
