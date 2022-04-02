package com.mainacad.method.interrupt;

public class Clock extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        clock.start();

        Thread.sleep(10000);
        clock.interrupt();
    }

    public void run() {
        Thread current = Thread.currentThread();

        while (current.isInterrupted() == false)
        {
            try {
                Thread.sleep(1000);
                int i = 1;
            } catch (InterruptedException e) {
                System.out.println("Работа потока была прервана");
                System.out.println(current.isInterrupted());
                break;
            }
            System.out.println("Tik");

        }
    }
}