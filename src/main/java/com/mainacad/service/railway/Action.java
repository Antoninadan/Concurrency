package com.mainacad.service.railway;

public class Action {
    private int value;
    private boolean isNewTicket = false; // switch
    private boolean stop = false;

    public synchronized void purchise() {
        while (isNewTicket == false) {
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


    public synchronized void selling(int value) {
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
