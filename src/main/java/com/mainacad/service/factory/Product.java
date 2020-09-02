package com.mainacad.service.factory;

import java.util.LinkedList;

public class Product {
    private String name;
    private LinkedList<Stage> stages;

    public Product(String name, LinkedList<Stage> stages) {
        this.name = name;
        this.stages = stages;
    }

    public LinkedList<Stage> getStages() {
        return stages;
    }

    public String getName() {
        return name;
    }


}
