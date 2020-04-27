package com.mainacad.runner;

import com.mainacad.service.schedule.TimeViewer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleRunner {

    public static void main(String[] args) {
        startTimeViewer();
        System.out.println("END");
    }

    public static void startTimeViewer() {
        ScheduledExecutorService exs = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> res = exs.scheduleAtFixedRate(new TimeViewer(), 10, 3,
                TimeUnit.SECONDS);
    }

}
