package com.mainacad.service.railway;

import java.util.ArrayList;
import java.util.List;

public class FreeTickets{

    private List<Ticket> list = new ArrayList<>();

    public void add(Ticket ticket){
        list.add(ticket);
    }

    public void remove(Ticket ticket){
        list.remove(ticket);
    }

    public boolean checkTicket(Ticket ticket){
        return list.contains(ticket);
    }
}




