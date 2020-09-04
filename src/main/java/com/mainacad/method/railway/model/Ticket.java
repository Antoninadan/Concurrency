package com.mainacad.method.railway.model;

public class Ticket {
    private City source;
    private City destination;
    private Person soldBy;

    public Ticket(City source, City destination) {
        this.source = source;
        this.destination = destination;
        this.soldBy = null;
    }

    public Person getSoldBy() {
        return soldBy;
    }

    @Override
    public String toString() {
        return source + " - " + destination;
    }

    public void setSoldBy(Person soldBy) {
        this.soldBy = soldBy;
    }
}
