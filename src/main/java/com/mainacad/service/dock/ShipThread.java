package com.mainacad.service.dock;

public class ShipThread extends Thread {
     private Ship ship;
    private Regulator regulator;

    public ShipThread(Ship ship, Regulator regulator) {
        this.ship = ship;
        this.regulator = regulator;
    }

    @Override
    public void run() {
        System.out.println("Ship " + ship.getName() + "ready");
     regulator.catchDock(ship);

    }
}
