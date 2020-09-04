package com.mainacad.method.consistent;

public class ThreadItem extends Thread {
    private String result;

    public String getResult() {
        return result;
    }

    public ThreadItem(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
String name = Thread.currentThread().getName();
        result=name;
    }
}
