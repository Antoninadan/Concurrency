package com.mainacad.method.deamon;

public class DeamondRunner {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println("currentThread = " + currentThread.getName());

        MyThreadClass threadOne = new MyThreadClass("one");
        threadOne.setDaemon(true);
        threadOne.start();

        System.out.println("Finish main program");
        currentThread.interrupt();
    }

}
