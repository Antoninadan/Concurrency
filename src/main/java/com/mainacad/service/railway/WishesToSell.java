package com.mainacad.service.railway;

import java.util.ArrayList;
import java.util.List;

public class WishesToSell {
    private List<Wish> list = new ArrayList<>();

    public void add(Person person, Ticket ticket){
        list.add(new Wish(person, ticket));
    }

    public void remove(Wish wish){
        list.remove(wish);
    }

    public boolean check(Wish wish){
        return list.contains(wish);
    }
}




