package com.mainacad.method.railway2;

import java.util.List;

public class Seller implements Runnable {
    private volatile List<String> tickets;
    private String ticketName;

    public Seller(String ticket, List<String> tickets) {
        this.tickets = tickets;
        this.ticketName = ticket;
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
        String name = Thread.currentThread().getName();

        synchronized (tickets) {

            while (tickets.size() > 3) {

                System.out.println("Dear " + name + " cashbox is full");
                tickets.wait();
            }

            System.out.println("Ticket " + ticketName + " was sold by " + name);

            tickets.add(ticketName);

            tickets.notifyAll();
        }

//        Thread.sleep(1000);

           /* if (tickets.contains(ticket)) {
                IntStream.range(0, tickets.size()).forEach(i -> {
                    String tick = tickets.get(i);
                    if (tick != null && tick.equals(ticket)) {
                        tickets.remove(i);
                    }
                });
                System.out.println("Ticket " + ticket + " is sold for " + name);
                tickets.notifyAll();
            }*/


    }
}
