package com.mainacad.method.railway2;

import java.util.List;
import java.util.Objects;

public class Buyer implements Runnable {
    private volatile List<String> tickets;
    private String ticketName;

    public Buyer(String ticketName, List<String> tickets) {
        this.tickets = tickets;
        this.ticketName = ticketName;
    }

    @Override
    public void run() {
        try {
            sellTicket();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sellTicket() throws InterruptedException {
        synchronized (tickets) {
            while (Objects.nonNull(ticketName) && !tickets.contains(ticketName)) {
                System.out.println("Dear, there isn't ticket " + ticketName);
                tickets.wait();
            }

        }

        System.out.println("Ticket " + ticketName + " was bought by " + Thread.currentThread().getName());

        tickets.remove(ticketName);

        ticketName = null;

    }
}
