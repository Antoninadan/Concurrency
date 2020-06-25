package com.mainacad.runner;

import com.mainacad.service.notifyall.Message;
import com.mainacad.service.notifyall.Notifier;
import com.mainacad.service.notifyall.Waiter;

public class NotifyAllRunner {
    public static void main(String[] args) {
        Message msg = new Message("обработать");

        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("Стартовали все потоки");
    }
}
