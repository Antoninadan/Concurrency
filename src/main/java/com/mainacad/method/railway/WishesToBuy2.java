package com.mainacad.method.railway;

import com.mainacad.method.railway.model.Ticket;
import com.mainacad.method.railway.model.Wish;
import com.mainacad.method.railway.model.Wishes;

import java.util.Optional;

// бажання купити
public class WishesToBuy2 extends Wishes implements Runnable {
    private A action;

    public WishesToBuy2(A action) {
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
    }

    @Override
    public void run() {
        while (true) {
            action.tryToBuy();
        }
    }
}




