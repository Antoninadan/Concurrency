package com.mainacad.service;

import java.util.List;

public class AdditionalService {
    private volatile List<String> logins;

    public synchronized void addText(String text){
        logins.add(text);
    }

    public AdditionalService(List<String> logins) {
        this.logins = logins;
    }

    public AdditionalService() {
    }
}
