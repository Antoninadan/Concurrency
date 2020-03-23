package com.mainacad.runner;

import com.mainacad.service.deamon.ThreadClass;

public class DeamondRunner {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println("currentThread = " + currentThread.getName());

        ThreadClass threadOne = new ThreadClass("one");

        threadOne.setDaemon(true);
        threadOne.start();

        System.out.println("Finish main program");
        currentThread.interrupt();
    }

}
