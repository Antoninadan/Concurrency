package com.mainacad.method.sleep;

public class SleepApp implements Runnable{
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Thread t0 = new Thread(new SleepApp());
        t0.start();

        Thread t1 = new Thread(new SleepApp());
        t1.start();
    }
}
