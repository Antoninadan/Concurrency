package com.mainacad.service.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SynchClass {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    private int number;

    public SynchClass(int number) {
        this.number = number;
    }

    public void setNumber(int number) {
        try {
            System.out.println(Thread.currentThread().getName() + " set - wait");
            cyclicBarrier.await();
            Thread.sleep(1000);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " set - go");
        this.number = number;
    }

    public int getNumber() {
        try {
            System.out.println(Thread.currentThread().getName() + " get - wait");
            cyclicBarrier.await();
            Thread.sleep(1000);
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " get - go");
        return number;
    }
}
