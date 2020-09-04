package com.mainacad.method.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerRunner {
    public static void main(String[] args) {
        Exchanger<String> exChanger = new Exchanger<>();
        ExchangeThread stOne = new ExchangeThread(exChanger, "Hello", 1000);
        ExchangeThread stTwo = new ExchangeThread(exChanger, "World", 3000);
        Thread thOne = new Thread(stOne);
        Thread thTwo = new Thread(stTwo);
        thOne.start();
        thTwo.start();
    }

}
