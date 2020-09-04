package com.mainacad.method.railway;

import com.mainacad.method.railway.model.Wish;

public class A {
    private Wish newWishToSell;
    private Wish newWishToBuy;

    public Wish getNewWishToSell() {
        return newWishToSell;
    }

    public void setNewWishToSell(Wish newWishToSell) {
        this.newWishToSell = newWishToSell;
    }

    public Wish getNewWishToBuy() {
        return newWishToBuy;
    }

    public void setNewWishToBuy(Wish newWishToBuy) {
        this.newWishToBuy = newWishToBuy;
    }

    public synchronized void tryToSell(){
        while (newWishToSell == null) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        newWishToSell = null;
        notifyAll();
    }

    public synchronized void tryToBuy(){
        while (newWishToBuy == null) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        newWishToBuy = null;
        notifyAll();
    }


}
