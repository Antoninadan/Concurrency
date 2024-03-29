package com.mainacad.method.notifyall;

public class NotifyAllRunner {
    public static void main(String[] args) {
        Message msg = new Message("обработать");

        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter1").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter2").start();

        Notifier notifier = new Notifier(msg);

        new Thread(notifier, "notifier").start();

        System.out.println("Стартовали все потоки");
    }
}
