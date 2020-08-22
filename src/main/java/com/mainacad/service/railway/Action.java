package com.mainacad.service.railway;

import com.mainacad.service.railway.model.Ticket;

public class Action {
    private Ticket newWishToBuyTicket = null; // switch purchise
    private Ticket newWishToSellTicket = null; // switch selling
    private boolean isNeedToRemoveTicketFromWishToSell = false;
    private boolean isNeedToRemoveTicketFromWishToBuy = false;

    public Ticket getNewWishToBuyTicket() {
        return newWishToBuyTicket;
    }

    public Ticket getNewWishToSellTicket() {
        return newWishToSellTicket;
    }

    public boolean isNeedToRemoveTicketFromWishToSell() {
        return isNeedToRemoveTicketFromWishToSell;
    }

    public boolean isNeedToRemoveTicketFromWishToBuy() {
        return isNeedToRemoveTicketFromWishToBuy;
    }

    public void setNeedToRemoveTicketFromWishToSell(boolean needToRemoveTicketFromWishToSell) {
        isNeedToRemoveTicketFromWishToSell = needToRemoveTicketFromWishToSell;
    }

    public void setNeedToRemoveTicketFromWishToBuy(boolean needToRemoveTicketFromWishToBuy) {
        isNeedToRemoveTicketFromWishToBuy = needToRemoveTicketFromWishToBuy;
    }

    // покупка
    public synchronized void setNewWishToBuyTicket(Ticket newWishToBuyTicket) {
        this.newWishToBuyTicket = newWishToBuyTicket;
        while (newWishToBuyTicket == null) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        notifyAll();
    }


    // продажа
    public synchronized void setNewWishToSellTicket(Ticket newWishToSellTicket) {
        this.newWishToSellTicket = newWishToSellTicket;
        while (newWishToSellTicket == null) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        notifyAll();
    }

}
