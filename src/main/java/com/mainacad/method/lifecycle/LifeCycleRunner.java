package com.mainacad.method.lifecycle;

public class LifeCycleRunner {
    public static void main(String[] args) {
        Thread firstThread = new FirstThread();
        System.out.println("not started = " + firstThread.getState());

        firstThread.start();

        System.out.println("after run = " + firstThread.getState());

        try {
            firstThread.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after wait = " + firstThread.getState());

    }

}
