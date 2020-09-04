package com.mainacad.method.countdownlatch;

//Используется для перевода потока в режим ожидания до тех пор, пока не наступит
//        определенное количество событий.

public class CountDownLatchRunner {
    public static void main(String[] args) {
        SynchClass synchClass = new SynchClass();
        SingleThread singleThread = new SingleThread(synchClass);
        Thread thread = new Thread(singleThread);
        thread.start();

        for (int i = 0; i < 5; i++) {
            synchClass.setNumber(12);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
