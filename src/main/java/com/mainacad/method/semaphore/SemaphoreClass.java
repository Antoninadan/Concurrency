package com.mainacad.method.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreClass {
    private int number;
    private Semaphore semaphore = new Semaphore(5,true);

    public SemaphoreClass(int number) {
        this.number = number;
    }

    public int getNumber() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "work");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        semaphore.release();
        return number;
    }

}
