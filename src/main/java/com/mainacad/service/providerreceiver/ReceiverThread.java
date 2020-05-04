package com.mainacad.service.providerreceiver;

import com.mainacad.service.providerreceiver.Action;

public class ReceiverThread extends Thread{
    private Action action;

    public ReceiverThread(Action action) {
        this.action = action;
    }

    @Override
    public void run() {
        while (actionNotStop()) {
            action.getValue();
        }
    }

    private boolean actionNotStop(){
        if (!action.isStop()) return true;
        else return false;
    }
}
