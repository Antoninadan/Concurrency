package com.mainacad.method.railway2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CashBox {
    private static final Scanner scanner = new Scanner(System.in);
    private static volatile List<String> tickets = new LinkedList<>();


    public static void main(String[] args) {


        while (true) {
            menu();
            String key = scanner.next();
            try {
                switch (key) {
                    case "1": {
                        String ticket = getInfoFromUser("Please, type name of ticket that you want to sell");

                        String sellerName = getInfoFromUser("Please, type name of seller");

                        Seller seller = new Seller(ticket, tickets);

                        Thread threadSeller = new Thread(seller, sellerName);

                        threadSeller.start();
                        break;
                    }
                    case "2": {
                        String ticket = getInfoFromUser("Please, type name of ticket that you want to buy");

                        String passerName = getInfoFromUser("Please, type name of buyer");

                        Buyer buyer = new Buyer(ticket, tickets);

                        Thread threadBuyer = new Thread(buyer, passerName);

                        threadBuyer.start();
                        break;
                    }
                    case "3": {
                        return;
                    }
                    default:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }

    }

    private static String getInfoFromUser(String message) {
        System.out.println(message);
        return new Scanner(System.in).next();
    }

    public static void menu() {
        System.out.println("1) If you want to sell ticket.\n" +
                            "2) If you want to buy ticket.\n" +
                            "3) Exit.");
    }
}
