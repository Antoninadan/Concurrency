package com.mainacad.service.factory;

public class Stage {
    private String name;
    private long seconds;

    public Stage(String name, long seconds) {
        this.name = name;
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }

    public long getSeconds() {
        return seconds;
    }
}
