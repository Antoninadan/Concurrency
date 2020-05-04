package com.mainacad.runner;

import com.mainacad.service.cyclicbarrier.SingleThread;
import com.mainacad.service.cyclicbarrier.SynchClass;

public class CyclicBarrierRunner {
    public static void main(String[] args) {
        SynchClass synchClass = new SynchClass(5);
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new SingleThread(synchClass));
            thread.start();
        }
        System.out.println(synchClass.getNumber());
    }

}
