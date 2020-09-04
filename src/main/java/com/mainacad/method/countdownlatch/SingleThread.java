package com.mainacad.method.countdownlatch;

public class SingleThread implements Runnable {
    private SynchClass sClass;

    public SingleThread(SynchClass sClass) {
        this.sClass = sClass;
    }

    @Override
    public void run() {
        sClass.getNumber();
    }
}
