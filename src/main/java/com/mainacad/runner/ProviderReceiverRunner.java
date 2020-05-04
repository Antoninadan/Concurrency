package com.mainacad.runner;

import com.mainacad.service.providerreceiver.Action;
import com.mainacad.service.providerreceiver.ProviderThread;
import com.mainacad.service.providerreceiver.ReceiverThread;

public class ProviderReceiverRunner {
    public static void main(String[] args) {
        Action action = new Action();
        ProviderThread provider = new ProviderThread(action);
        ReceiverThread receiver = new ReceiverThread(action);

        provider.start();
        receiver.start();
    }
}
