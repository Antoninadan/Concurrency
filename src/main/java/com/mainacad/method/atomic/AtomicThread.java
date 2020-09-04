package com.mainacad.method.atomic;

public class AtomicThread implements Runnable{
    private AtomicClass atomicClass;

    public AtomicThread(AtomicClass atomicClass) {
        this.atomicClass = atomicClass;
    }

    @Override
    public void run() {
       int increment = atomicClass.getVolume().getAndIncrement();
        System.out.println(" " + increment);
    }
}
