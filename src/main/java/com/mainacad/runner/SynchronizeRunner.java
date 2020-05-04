package com.mainacad.runner;

import com.mainacad.service.synchronize.Account;
import com.mainacad.service.synchronize.MoneyTakerThread;

public class SynchronizeRunner {
    public static void main(String[] args) {
        Account account = new Account(200, "login", 123);
        MoneyTakerThread moneyTakerThreadOne = new MoneyTakerThread(account);
        MoneyTakerThread moneyTakerThreadTwo = new MoneyTakerThread(account);
        moneyTakerThreadOne.getMoneyFromAccount("login", 123, 150);
        moneyTakerThreadTwo.getMoneyFromAccount("login", 123, 150);
        System.out.println();

        Account accountTwo = new Account(200, "login", 123);
        MoneyTakerThread moneyTakerThreadThree = new MoneyTakerThread(accountTwo);
        MoneyTakerThread moneyTakerThreadFour = new MoneyTakerThread(accountTwo);
        moneyTakerThreadThree.getMoneyFromAccount("login", 123, 150);
        moneyTakerThreadFour.getMoneyFromAccount("login", 123, 150);


    }

}
