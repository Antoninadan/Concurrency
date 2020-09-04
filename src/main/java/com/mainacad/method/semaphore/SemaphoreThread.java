package com.mainacad.method.semaphore;

public class SemaphoreThread implements Runnable {
    private SemaphoreClass semaphoreClass;

    public SemaphoreThread(SemaphoreClass semaphoreClass) {
        super();
        this.semaphoreClass = semaphoreClass;
    }

    @Override
    public void run() {
        semaphoreClass.getNumber();
    }
}
