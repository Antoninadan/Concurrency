package com.mainacad.service.railway;

import java.util.ArrayList;
import java.util.List;

public class WishesToBuy extends Thread{
    private  Action action;
    private List<Wish> list = new ArrayList<>();

    public void add(Person person, Ticket ticket){
        list.add(new Wish(person, ticket));
    }

    public void remove(Wish wish){
        list.remove(wish);
    }

    public boolean checkWish(Wish wish){
        return list.contains(wish);
    }

    public Wish findWish(Ticket ticket){
        return list.stream().filter(x->x.isTicket(ticket)).findFirst();
    }
//
//    public Wish checkFirstWish(List<Wish> wish){
//        return list.contains(wish);
//    }


    @Override
    public void run() {
        Ticket newTicket = action.getNewTicket();
        if (checkWish())

    }
}




