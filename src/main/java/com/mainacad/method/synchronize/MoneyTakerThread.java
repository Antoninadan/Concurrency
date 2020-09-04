package com.mainacad.method.synchronize;

public class MoneyTakerThread implements Runnable{
    private Account account;
    private String login;
    private long password;
    private int sum;

    public MoneyTakerThread(Account account) {
        this.account = account;
    }

    public void getMoneyFromAccount(String login, long password, int sum) {
        this.password = password;
        this.login = login;
        this.sum = sum;
        Thread threat = new Thread(this);
        threat.start();
    }

    public void run() {
        account.takeMoney(this.login, this.password, this.sum);
    }

}
