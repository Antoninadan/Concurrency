package com.mainacad.method.railway.model;

public class Wish {
    private int index;
    private Person person;
    private Ticket ticket;

    public Wish(int index, Person person, Ticket ticket) {
        this.index = index;
        this.person = person;
        this.ticket = ticket;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean isTicket(Ticket ticket){
        return this.ticket == ticket;
    }

    public boolean isIndex(int index){
        return this.index == index;
    }

    @Override
    public String toString() {
        return "[" + person.toString() + " (" + ticket.toString() + ")]";
    }
}


