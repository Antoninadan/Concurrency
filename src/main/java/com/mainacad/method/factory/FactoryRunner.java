package com.mainacad.method.factory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class FactoryRunner {
    public static void main(String[] args) throws IOException {
        Stage stage1 = new Stage("planning", 30L);
        Stage stage2 = new Stage("assembly", 2L);
        Stage stage3 = new Stage("color", 4L);
        Stage stage4 = new Stage("polish", 6L);
        Stage stage5 = new Stage("last polish", 5L);
        Stage stage6 = new Stage("cooking", 3L);
        Stage stage7 = new Stage("decorating", 2L);
        Stage stage8 = new Stage("testing", 4L);
        Stage stage9 = new Stage("do bugs", 6L);
        Stage stage10 = new Stage("fix", 5L);


        LinkedList<Stage> stagesProduct1 = new LinkedList<>();
        stagesProduct1.add(stage2);
        stagesProduct1.add(stage1);
        stagesProduct1.add(stage3);
        stagesProduct1.add(stage4);
        stagesProduct1.add(stage5);

        LinkedList<Stage> stagesProduct2 = new LinkedList<>();
        stagesProduct2.add(stage6);
        stagesProduct2.add(stage7);
        stagesProduct2.add(stage8);

        LinkedList<Stage> stagesProduct3 = new LinkedList<>();
        stagesProduct3.add(stage9);
        stagesProduct3.add(stage10);

        Product product1 = new Product("car", stagesProduct1);
        Product product2 = new Product("cake", stagesProduct2);
        Product product3 = new Product("program", stagesProduct3);

        Order orderProduct1 = new Order(product1, "Petya");
        Order orderProduct2 = new Order(product2, "Ivan");
        Order orderProduct3 = new Order(product3, "Fedir");

        orderProduct1.start();
        orderProduct2.start();
        orderProduct3.start();


        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(orderProduct1.getCurrentState());
//        orderProduct1.cancel("Reason to cancel producing car");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(orderProduct2.getCurrentState());
        orderProduct2.cancel("Reason to cancel producing cake");

//        System.out.println(orderProduct3.getCurrentState());
    }
}
