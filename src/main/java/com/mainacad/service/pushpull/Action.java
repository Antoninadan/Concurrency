package com.mainacad.service.pushpull;

public class Action {
    private int value;
    private boolean turn = false; // switch
    private boolean stop = false;

    public Action() {
        super();
    }


    public synchronized int getValue() {
        while (turn == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        int temp = this.value;
        turn = false;
        notifyAll();
        System.out.println("Number accepted -> " + this.value);
        return temp;
    }


    public synchronized void setValue(int value) {
        while (turn == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.value = value;
        turn = true;
        System.out.println("Send number -> " + this.value);
        notifyAll();
    }


    public boolean isStop() {
        return stop;
    }


    public	void setStop(boolean stop) {
        this.stop = stop;
    }
}
