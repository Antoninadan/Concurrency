package com.mainacad.service.cyclicbarrier;

public class SingleThread  implements Runnable {
    private SynchClass synchClass;

    public SingleThread(SynchClass synchClass) {
        this.synchClass = synchClass;
    }

    @Override
    public void run() {
        synchClass.setNumber(10);
    }
}
