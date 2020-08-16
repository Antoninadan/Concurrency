package com.mainacad.service.railway;

public class Wish {
    private Person person;
    private Ticket ticket;

    public Wish(Person person, Ticket ticket) {
        this.person = person;
        this.ticket = ticket;
    }

    public boolean isTicket(Ticket ticket){
        return this.ticket == ticket;
    }
}


