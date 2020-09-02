package com.mainacad.service.factory;

import com.mainacad.settings.Settings;
import com.mainacad.util.FileUtil;

import java.io.File;
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
        String fileNamePrefix = product.getName();

        for (int i = 0; i < stages.size(); i++) {
            Stage currentStage = stages.get(i);

            try {
                TimeUnit.SECONDS.sleep(currentStage.getSeconds());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String fileNameSuffix = worker;
            List<String> text = Arrays.asList(currentStage.getName());

            try {
                FileUtil.appendTo(text, Settings.FILES_DIR, fileNamePrefix + "_" + fileNameSuffix);

                System.out.println(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // TODO fix bug
    public String getCurrentState() {
        StringBuilder result = new StringBuilder();
        File[] files = FileUtil.findFiles(Settings.FILES_DIR, product.getName() + "_");

        File each = files[0];
        int startIndex = each.getName().lastIndexOf("_");
        String workerName = each.getName().substring(startIndex + 1);
        String stageName = null;


        try {
            List<String> stages = FileUtil.read(Settings.FILES_DIR, each.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        stages.forEach(x -> result.append(x.getName()).append(Settings.LINE_SEP));

        return result.toString();

    }

    public void cancel(String reason) {

    }

}
