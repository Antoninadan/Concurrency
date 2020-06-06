package com.mainacad.runner;

import com.mainacad.service.eggchicken.EggVoice;

public class EggChickenRunner {
    static EggVoice eggVoice;    //Побочный поток

    public static void main(String[] args) {
        eggVoice = new EggVoice();    //Создание потока
        System.out.println("Спор начат...");
        eggVoice.start();            //Запуск потока

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("курица!");
        }

        //Слово «курица» сказано 5 раз

        if (eggVoice.isAlive())    //Если оппонент еще не сказал последнее слово
        {
            try {
                eggVoice.join();    //Подождать пока оппонент закончит высказываться.
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
