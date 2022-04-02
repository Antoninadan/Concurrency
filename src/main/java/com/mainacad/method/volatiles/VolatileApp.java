package com.mainacad.method.volatiles;

public class VolatileApp {
    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread clockThread = new Thread(clock);
        clockThread.start();

        Thread.sleep(10000);
        clock.cancel();
    }


}

class Clock implements Runnable {
    private volatile boolean isCancel = false;
//    private  boolean isCancel = false;

    public void cancel() {
        this.isCancel = true;
    }

    public void run() {
        int count = 1;
        while (!this.isCancel) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count++);
        }
    }
}

