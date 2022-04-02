package com.mainacad.method.lifecycle;

public class LifeCycleRunner {
    public static void main(String[] args) throws InterruptedException {
//        waitSimple();
        waitTimeout();
    }

    static void waitSimple() throws InterruptedException {
        Thread firstThread = new FirstThread();
        System.out.println("not started = " + firstThread.getState());

        firstThread.start();

        System.out.println("after run = " + firstThread.getState());

        synchronized (firstThread) {
            try {
                firstThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after wait = " + firstThread.getState());
        }
    }

    // dont work
    static void waitTimeout() throws InterruptedException {
        Thread firstThread = new FirstThread();
        System.out.println("not started = " + firstThread.getState());

        firstThread.start();

        System.out.println("after run = " + firstThread.getState());

        synchronized (firstThread) {

            try {
                firstThread.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("at once after wait = " + firstThread.getState());
        }

        Thread.sleep(20000);
        System.out.println("after 200 ms = " + firstThread.getState());
    }
}
