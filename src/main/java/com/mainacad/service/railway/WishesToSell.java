package com.mainacad.service.railway;

import com.mainacad.service.railway.model.Ticket;
import com.mainacad.service.railway.model.Wish;
import com.mainacad.service.railway.model.Wishes;

import java.util.Optional;

// бажання продати
public class WishesToSell extends Wishes implements Runnable {
    private Action action;

    public void setAction(Action action) {
        this.action = action;
    }

    public WishesToSell(Action action) {
        this.action = action;
    }

    @Override
    public void print() {
        System.out.println("Wishes to sell:");
        super.print();
        System.out.println();
    }


    @Override
    public void run() {
        while (true) {
            if (action.isNeedToRemoveTicketFromWishToSell()) {
                Ticket newTicket = action.getNewWishToSellTicket();
                Wish wishToSell = findWishByTicket(newTicket).get();
                remove(wishToSell);
            } else {

                // хтось виказав бажання купити
                Ticket newTicket = action.getNewWishToSellTicket();
                Optional<Wish> newWish = findWishByTicket(newTicket);

                // якщо знайшли  в цьому списку
                if (newWish.isPresent()) {
                    remove(newWish.get());
                    action.setNeedToRemoveTicketFromWishToBuy(true);
                }
            }

            action.setNewWishToSellTicket(null);
        }
    }
}




