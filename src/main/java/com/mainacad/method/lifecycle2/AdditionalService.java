package com.mainacad.method.lifecycle2;

import java.util.List;

public class AdditionalService {
    private volatile List<String> logins;

    public AdditionalService() {
    }

    public AdditionalService(List<String> logins) {
        this.logins = logins;
    }

    public synchronized void addText(String text) {
        logins.add(text);
    }

}
