package com.mainacad.service.railway;

import com.mainacad.service.railway.model.Ticket;

public class Action {
    private Ticket newWishToBuyTicket = null; // switch purchise
    private Ticket newWishToSellTicket = null; // switch selling

    public Ticket getNewWishToBuyTicket() {
        return newWishToBuyTicket;
    }

    public void setNewWishToBuyTicket(Ticket newWishToBuyTicket) {
        this.newWishToBuyTicket = newWishToBuyTicket;
    }

    public Ticket getNewWishToSellTicket() {
        return newWishToSellTicket;
    }

    public void setNewWishToSellTicket(Ticket newWishToSellTicket) {
        this.newWishToSellTicket = newWishToSellTicket;
    }

    // покупка
    public synchronized void purchise() {
        while (newWishToBuyTicket == null) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
//        int result = this.value;
//        isValueGetting = false;
//        notifyAll();
//        System.out.println("Number accepted -> " + this.value + "\n");
//        return result;
    }


    // продажа
    public synchronized void selling(int value) {
        while (newWishToSellTicket == null) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

//        isValueGetting = true;
//        System.out.println("Send number -> " + this.value );
        notifyAll();
    }



}
