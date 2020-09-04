package com.mainacad.method.search2;

import java.util.List;

public class InterruptThread extends Thread {
    private List<ThreadItemI> threads;

    public InterruptThread(List<ThreadItemI> threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        threads.forEach(it -> it.interrupt());
    }
}
