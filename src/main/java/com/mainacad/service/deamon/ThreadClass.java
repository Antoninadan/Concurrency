package com.mainacad.service.deamon;

// 307
public class ThreadClass extends Thread {

    public ThreadClass(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }

    }
}
