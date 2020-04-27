package com.mainacad.runner;

import java.util.concurrent.TimeUnit;

public class TimeUnitRunner {
    public static void main(String[] args) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long t = timeUnit.convert(1, TimeUnit.HOURS);
        System.out.println(t);
    }

}
