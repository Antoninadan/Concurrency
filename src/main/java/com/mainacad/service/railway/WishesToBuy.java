package com.mainacad.service.railway;

import com.mainacad.service.railway.model.Ticket;
import com.mainacad.service.railway.model.Wish;
import com.mainacad.service.railway.model.Wishes;

import java.util.Optional;

// бажання купити
public class WishesToBuy extends Wishes implements Runnable {
    private Action action;

    public WishesToBuy(Action action) {
        this.action = action;
    }

    @Override
    public void print() {
        System.out.println("Wishes to buy:");
        super.print();
        System.out.println();
    }

    @Override
    public void add(Wish wish) {
        super.add(wish);
        action.setNewWishToBuyTicket(wish.getTicket());
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
                Optional<Wish> newWish = findWishByTicket(newTicket);

                // якщо знайшли  в цьому списку
                if (newWish.isPresent()) {
                    remove(newWish.get());
                    action.setNeedToRemoveTicketFromWishToSell(true);
                    System.out.println("realized " + newWish);
                }
            }

            action.setNewWishToSellTicket(null);
        }
    }
}




