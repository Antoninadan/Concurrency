package com.mainacad.runner;

import com.mainacad.service.shop.Producer;
import com.mainacad.service.shop.Store;
import com.mainacad.service.shop.Consumer;

public class ShopRunner {
    public static void main(String[] args) {

        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
