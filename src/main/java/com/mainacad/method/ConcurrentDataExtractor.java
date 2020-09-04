package com.mainacad.method;

public class ConcurrentDataExtractor extends Thread{
    Long lastExtractionTime;

    public ConcurrentDataExtractor(Long lastExtractionTime) {
        this.lastExtractionTime = lastExtractionTime;
    }

    @Override
    public void run() {
        DataCollector.storeDataByTime(lastExtractionTime);
    }
}
