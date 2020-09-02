package com.mainacad.service.factory;

import com.mainacad.settings.Settings;
import com.mainacad.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FactoryRunner {
    public static void main(String[] args) throws IOException {
        Stage stage1 = new Stage("planning", 3L);
        Stage stage2 = new Stage("assembly", 2L);
        Stage stage3 = new Stage("color", 4L);
        Stage stage4 = new Stage("polish", 6L);
        Stage stage5 = new Stage("five", 5L);

        LinkedList<Stage> stagesProduct1 = new LinkedList<>();
        stagesProduct1.add(stage2);
        stagesProduct1.add(stage1);
        stagesProduct1.add(stage3);
        stagesProduct1.add(stage4);
        stagesProduct1.add(stage5);

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

        Order orderProduct1 = new Order(product1, "Petya");
        Order orderProduct2 = new Order(product2, "Ivan");
        Order orderProduct3 = new Order(product3,  "Fedir");

        orderProduct1.start();

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(orderProduct1.getCurrentState());


    }
}
