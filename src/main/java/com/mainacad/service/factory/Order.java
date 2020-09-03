package com.mainacad.service.factory;

import com.mainacad.settings.Settings;
import com.mainacad.util.FileUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Order extends Thread {
    private Product product;
    private String worker;
    private LinkedList<Stage> stages;

    public Order(Product product, String worker) {
        this.product = product;
        this.worker = worker;

        stages = new LinkedList<>();

        for (int i = 0; i < product.getStages().size(); i++) {
            stages.add(product.getStages().get(i));
        }
    }

    @Override
    public void run() {

        try {

                for (int i = 0; i < stages.size(); i++) {
                    Stage currentStage = stages.get(i);

                    TimeUnit.SECONDS.sleep(currentStage.getSeconds());

                    List<String> text = Arrays.asList(currentStage.getName());

                    try {
                        FileUtil.appendTo(text, Settings.FILES_DIR, getFileName());

                        System.out.println(text);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getCurrentState() {

        StringBuilder result = new StringBuilder();
        result.append("Worker ").append(worker).append(":").append(Settings.LINE_SEP);
        try {
            List<String> stages = FileUtil.read(Settings.FILES_DIR, getFileName());
            stages.forEach(x -> result.append(x).append(Settings.LINE_SEP));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public void cancel(String reason) {
        this.interrupt();

        List<String> text = Arrays.asList(reason);
        try {
            FileUtil.appendTo(text, Settings.FILES_DIR, getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return product.getName() + "_" + worker;
    }

}
