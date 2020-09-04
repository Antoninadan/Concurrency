package com.mainacad.method.semaphore;

public class SemaphoreRunner {
    public static void main(String[] args) {
        SemaphoreClass semaphoreClass = new SemaphoreClass(10);
        for (int i = 0; i < 16; i++) {
            SemaphoreThread semaphoreThread = new SemaphoreThread(semaphoreClass);
            Thread thread = new Thread(semaphoreThread);
            thread.start();
        }
    }
}
