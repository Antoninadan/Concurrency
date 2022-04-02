package com.mainacad.method.createthread;

public class CreateSimpleRunnableApp {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Hello, World!");
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}