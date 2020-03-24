package com.mainacad.service.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangeThread implements Runnable {
    private Exchanger<String> exChanger;
    private String text;
    private long time;

    public ExchangeThread(Exchanger<String> exChanger, String text, long time) {
        this.exChanger = exChanger;
        this.text = text;
        this.time = time;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - My text - " + this.text);
        try {
            Thread.sleep(time);
            this.text = exChanger.exchange(text);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " - New text - " + this.text);
    }
}
