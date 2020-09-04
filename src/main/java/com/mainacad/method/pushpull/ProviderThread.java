package com.mainacad.method.pushpull;

import java.util.Random;

// push
public class ProviderThread extends Thread{
    private Action action;
    private Random rn = new Random();

    public ProviderThread(Action action) {
        this.action = action;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int randomNumber = rn.nextInt(100);
            action.setValue(randomNumber);
        }
        action.setStop(true);
    }
}
