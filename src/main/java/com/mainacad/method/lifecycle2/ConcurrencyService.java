package com.mainacad.method.lifecycle2;

import java.util.List;

public class ConcurrencyService extends Thread{
    private  List<String> logins;

    public ConcurrencyService(List<String> logins) {
        this.logins = logins;
    }

    @Override
    public void run() {
//        addStringToList();
        AdditionalService additionalService = new AdditionalService(logins);
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        additionalService.addText("+");
    }

}
