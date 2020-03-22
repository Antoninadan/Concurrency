package com.mainacad.service.pushpull;

public class PushPullThread extends Thread{
    private String text;
    private Printer action;
    private boolean turn;

    public PushPullThread(String text, Printer action, boolean turn) {
        this.text = text;
        this.action = action;
        this.turn = turn;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 4; i++) {
            action.printText(text, turn);
        }

    }
}
