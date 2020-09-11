package com.mainacad.method.createthread;

import java.util.concurrent.TimeUnit;

public class CreateThreadRunner {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println("I'm new thread");
        };

        Thread thread = new Thread(new MyRunnable());
        thread.start();
        thread.interrupt();

//        System.out.println(thread.isInterrupted());

//        Thread.;
//        thread.start();
    }
}


class MyRunnable implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Before (thread.isInterrupted()) -> " + thread.isInterrupted());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Catch (thread.isInterrupted()) -> " + thread.isInterrupted());

            thread.interrupt();

            System.out.println("Catch2 (thread.isInterrupted()) -> " + thread.isInterrupted());//true

            System.out.println("Catch3 (thread.interrupted()) -> " + thread.interrupted());//true

            System.out.println("Catch4 (thread.isInterrupted()) -> " + thread.isInterrupted());//false



//            e.printStackTrace();
        }

        System.out.println("Hello world");
    }
}

