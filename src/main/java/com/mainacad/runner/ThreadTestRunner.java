package com.mainacad.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTestRunner {

    public static void main(String[] args) throws InterruptedException {
        work();
    }

    public static synchronized void work() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        List<Thread> threads = new ArrayList<>();
//        Thread markerThread = new Thread("marker");
//        markerThread.start();

        for (int i = 0; i <= 4; i++) {
            Thread thread = new Thread("my thread " + Integer.toString(i)) {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.getName());
                }
            };

            thread.setDaemon(true);
            threads.add(thread);
//            thread.join();
            thread.start();
        }

//        ReentrantLock lock = new ReentrantLock();
//
//        lock.lock();

        currentThread.interrupt();
//        markerThread.interrupt();
    }



}
