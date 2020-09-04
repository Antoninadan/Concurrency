package com.mainacad.method;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentDataCreator extends Thread{

    @Override
    public void run() {

        Long currentTime = System.currentTimeMillis();
        // atomic common!!!!!!!!!!!!!!!
        DataCollector.addDataByKey(new AtomicLong(currentTime), new Date(currentTime).toString());
    }
}
