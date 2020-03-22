package com.mainacad.service.pushpull;

public class Printer {
    private boolean turn = true;

    public synchronized void printText(String text, boolean turn) {
        while (this.turn == turn) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        System.out.println(text + "  ");
        this.turn = !this.turn;

        notifyAll();
    }
}
