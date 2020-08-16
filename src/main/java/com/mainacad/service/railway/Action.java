package com.mainacad.service.railway;

public class Action {
    private Ticket newTicket = null; // switch

    public Ticket getNewTicket() {
        return newTicket;
    }

    public void setNewTicket(Ticket newTicket) {
        this.newTicket = newTicket;
    }

    // покупка
    public synchronized void purchise() {
        while (newTicket != null) {
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


    // продажа
    public synchronized void selling(int value) {
        while (newTicket != null) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        isValueGetting = true;
        System.out.println("Send number -> " + this.value );
        notifyAll();
    }



}
