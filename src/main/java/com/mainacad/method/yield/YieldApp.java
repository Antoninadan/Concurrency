package com.mainacad.method.yield;

public class YieldApp extends Thread {

    public static void main(String[] args) {
        new YieldApp();
        new YieldApp();
        new YieldApp();
    }

    public YieldApp() {
        this.start();
    }

    public void run() {

        System.out.println(Thread.currentThread().getName() + " уступает свое место другим");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " has finished executing.");
    }

}