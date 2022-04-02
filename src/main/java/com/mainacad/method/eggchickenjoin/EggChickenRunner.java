package com.mainacad.method.eggchickenjoin;

public class EggChickenRunner {
    static EggVoiceThread eggVoiceThread;    //Побочный поток

    public static void main(String[] args) {
        eggVoiceThread = new EggVoiceThread();
        System.out.println("Спор начат...");
        eggVoiceThread.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("курица!");
        }

        //Слово «курица» сказано 5 раз

        if (eggVoiceThread.isAlive())    //Если оппонент еще не сказал последнее слово
        {
            try {
                eggVoiceThread.join();    //Подождать пока оппонент закончит высказываться.
            } catch (InterruptedException e) {
            }
            System.out.println("Первым появилось яйцо!");
        } else    //если оппонент уже закончил высказываться
        {
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }
}
