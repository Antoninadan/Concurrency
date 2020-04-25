//package com.mainacad.runner;
//
//import com.mainacad.service.dock.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DockRunner {
//
//    public static final Integer NUMBER_OF_SHIPS = 20;
//
//    public static void main(String[] args) {
//        List<Ship> ships = new ArrayList<>();
//        List<ShipThread> shipThreads = new ArrayList<>();
//
//        Regulator regulator = new Regulator();
//        for (int i =1; i<= NUMBER_OF_SHIPS; i++){
//            Ship ship = new Ship(Integer.toString(i));
//            ships.add(ship);
//            ShipThread shipThread = new ShipThread(ship, regulator);
//            shipThreads.add(shipThread);
//
//        }
//
//        shipThreads.forEach(it -> it.start());
//
//
//
//
//
//    }
//}
