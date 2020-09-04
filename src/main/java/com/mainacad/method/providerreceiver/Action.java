package com.mainacad.method.providerreceiver;

public class Action {
    private int value;
    private boolean isValueGetting = false; // switch
    private boolean stop = false;

    public synchronized int getValue() {
        while (isValueGetting == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        int result = this.value;
        isValueGetting = false;
        notifyAll();
        System.out.println("Number accepted -> " + this.value + "\n");
        return result;
    }


    public synchronized void setValue(int value) {
        while (isValueGetting == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.value = value;
        isValueGetting = true;
        System.out.println("Send number -> " + this.value );
        notifyAll();
    }


    public boolean isStop() {
        return stop;
    }


    public	void setStop(boolean stop) {
        this.stop = stop;
    }
}
