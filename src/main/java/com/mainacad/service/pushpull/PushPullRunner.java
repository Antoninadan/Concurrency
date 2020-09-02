package com.mainacad.service.pushpull;

import com.mainacad.service.pushpull.*;

public class PushPullRunner {
    public static void main(String[] args) {

        // difficult example, nah
//        Printer printer = new Printer();
//        PushPullThread pull = new PushPullThread("Pull thread started", printer, true);
//        PushPullThread push = new PushPullThread("Push thread started", printer, false);
//        pull.start();
//        push.start();

        // receiverThread - providerThread

        Action action = new Action();
        ProviderThread provider = new ProviderThread(action);
        ReceiverThread receiver = new ReceiverThread(action);

        provider.start();
        receiver.start();

    }
}
