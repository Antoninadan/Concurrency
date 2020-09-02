package com.mainacad.service.atomic;

import com.mainacad.service.atomic.AtomicClass;
import com.mainacad.service.atomic.AtomicThread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicRunner {
    public static void main(String[] args) {
        AtomicClass atomicClass = new AtomicClass(new AtomicInteger(0));

        for (int i =0; i<10; i++) {
            AtomicThread atomicThread = new AtomicThread(atomicClass);
            atomicThread.run();
        }
    }
}
