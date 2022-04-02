package com.mainacad.method.createthread;

public class CreateSimpleExtThreadApp {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

}

class MyThread extends Thread {
    public void run() {
        System.out.println("Mой поток запущен...");
    }
}