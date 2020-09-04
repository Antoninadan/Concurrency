package com.mainacad.method.railway.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wishes {
    private List<Wish> list = new ArrayList<>();

    public void add(Wish wish) {
        list.add(wish);
    }

    public void remove(Wish wish) {
        list.remove(wish);
    }

    public Optional<Wish> findWishByTicket(Ticket ticket) {
        return list.stream().filter(x -> x.isTicket(ticket)).findFirst();
    }

    public void print(){
        list.stream().forEach(x -> System.out.println(x));
    }

}
