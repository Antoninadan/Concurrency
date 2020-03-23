package com.mainacad.runner;

import com.mainacad.service.deamon.ThreadClass;

public class JoinRunner {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println("currentThread = " + currentThread.getName());

        ThreadClass threadOne = new ThreadClass("one");
        ThreadClass threadTwo = new ThreadClass("two");

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
