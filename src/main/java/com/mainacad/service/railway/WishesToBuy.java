package com.mainacad.service.railway;

import com.mainacad.service.railway.model.Ticket;
import com.mainacad.service.railway.model.Wish;
import com.mainacad.service.railway.model.Wishes;

// бажання купити
public class WishesToBuy extends Wishes implements Runnable {
    private Action action;

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public void run() {
        while (true) {
            if (action.isNeedToRemoveTicketFromWishToBuy()) {
                Ticket newTicket = action.getNewWishToBuyTicket();
                Wish wishToBuy = findWishByTicket(newTicket).get();
                remove(wishToBuy);
            } else {

                // хтось виказав бажання продати
                Ticket newTicket = action.getNewWishToSellTicket();
                Wish wishToBuy = findWishByTicket(newTicket).get();
                Wish wishToSell = findWishByTicket(newTicket).get();

                // якщо знайшли  в цьому списку
                if (wishToBuy != null) {
                    remove(wishToBuy);
                    action.setNeedToRemoveTicketFromWishToSell(true);
                }
            }

            action.setNewWishToSellTicket(null);
        }
    }
}




