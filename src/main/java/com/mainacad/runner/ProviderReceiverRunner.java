package com.mainacad.runner;

import com.mainacad.method.providerreceiver.Action;
import com.mainacad.method.providerreceiver.ProviderThread;
import com.mainacad.method.providerreceiver.ReceiverThread;

public class ProviderReceiverRunner {
    public static void main(String[] args) {
        Action action = new Action();
        ProviderThread provider = new ProviderThread(action);
        ReceiverThread receiver = new ReceiverThread(action);

        provider.start();
        receiver.start();
    }
}
