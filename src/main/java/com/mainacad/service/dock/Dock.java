package com.mainacad.service.dock;

import java.util.Date;

public class Dock {
    private String name;
    private Date lastCatch;

    public Dock(String name, Date lastCatch) {
        this.name = name;
        this.lastCatch = lastCatch;
    }

    public Date getLastCatch() {
        return lastCatch;
    }

    public void setLastCatch(Date lastCatch) {
        this.lastCatch = lastCatch;
    }

    public String getName() {
        return name;
    }
}
