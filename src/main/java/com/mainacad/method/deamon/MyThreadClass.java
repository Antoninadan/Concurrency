package com.mainacad.method.deamon;

// 307
public class MyThreadClass extends Thread {

    public MyThreadClass(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }

    }
}
