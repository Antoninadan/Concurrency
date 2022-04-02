package com.mainacad.runner;

import com.mainacad.method.deamon.MyThreadClass;

public class JoinRunner {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println("currentThread = " + currentThread.getName());

        MyThreadClass threadOne = new MyThreadClass("one");
        MyThreadClass threadTwo = new MyThreadClass("two");

        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish main program");
    }

}
