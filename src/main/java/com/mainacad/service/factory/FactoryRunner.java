package com.mainacad.service.factory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class FactoryRunner {
    public static void main(String[] args) {
        Stage stage1 = new Stage("first", 3L);
        Stage stage2 = new Stage("second", 6L);
        Stage stage3 = new Stage("third", 12L);
        Stage stage4 = new Stage("four", 10L);
        Stage stage5 = new Stage("five", 5L);

        LinkedList<Stage> stagesProduct1 = new LinkedList<>();
        stagesProduct1.add(stage2);
        stagesProduct1.add(stage1);
        stagesProduct1.add(stage3);

        LinkedList<Stage> stagesProduct2 = new LinkedList<>();
        stagesProduct2.add(stage1);
        stagesProduct2.add(stage3);
        stagesProduct2.add(stage5);

        LinkedList<Stage> stagesProduct3 = new LinkedList<>();
        stagesProduct3.add(stage5);
        stagesProduct3.add(stage4);

        Product product1 = new Product("car", stagesProduct1);
        Product product2 = new Product("box", stagesProduct2);
        Product product3 = new Product("moto", stagesProduct3);

        Order orderProduct1 = new Order(product1, "Petya", "Vasya", "Masha");
        Order orderProduct2 = new Order(product2, "Ivan", "Vasya", "Ganna");
        Order orderProduct3 = new Order(product3,  "Fedir", "Nina");

        orderProduct1.start();

        try {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("4 seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
