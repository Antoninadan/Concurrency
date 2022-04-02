package com.mainacad.method.shopnotifywait;

import com.mainacad.method.shopnotifywait.Consumer;
import com.mainacad.method.shopnotifywait.Producer;
import com.mainacad.method.shopnotifywait.Store;

public class NotifyWaitRunner {
    public static void main(String[] args) {

        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
