package com.mainacad.method.schedule;

import java.text.SimpleDateFormat;

public class TimeViewer implements Runnable {

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
    }
}
