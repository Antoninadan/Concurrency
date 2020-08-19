package com.mainacad.service.railway;

import com.mainacad.service.railway.model.Ticket;
import com.mainacad.service.railway.model.Wish;
import com.mainacad.service.railway.model.Wishes;

// бажання продати
public class WishesToSell extends Wishes implements Runnable {
    private Action action;

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public void run() {
        // хтось виказав бажання купити
        Ticket newTicket = action.getNewTicket();
        Wish wishToBuy = findWishByTicket(newTicket).get();
        Wish wishToSell = findWishByTicket(newTicket).get();


        // якщо знайшли  в цьому списку
        if (wishToBuy != null) {
            remove(wishToBuy);

            action.setNewTicket(null);
        }
    }

}




