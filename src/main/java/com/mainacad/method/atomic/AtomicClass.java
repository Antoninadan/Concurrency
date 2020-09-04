package com.mainacad.method.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClass {
    private AtomicInteger volume;

    public AtomicClass(AtomicInteger volume) {
        this.volume = volume;
    }

    public AtomicInteger getVolume() {
        return volume;
    }

    public void setVolume(AtomicInteger volume) {
        this.volume = volume;
    }
}
