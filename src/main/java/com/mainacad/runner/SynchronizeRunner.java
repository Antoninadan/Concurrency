package com.mainacad.runner;

import com.mainacad.service.synchronize.Account;
import com.mainacad.service.synchronize.MoneyTakerThread;

public class SynchronizeRunner {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        Account account = new Account(200, "login", 123);
        MoneyTakerThread stOne = new MoneyTakerThread(account);
        MoneyTakerThread stTwo = new MoneyTakerThread(account);
        stOne.getMoneyFromAccount("login", 123, 150);
        stTwo.getMoneyFromAccount("login", 123, 150);
    }

}
