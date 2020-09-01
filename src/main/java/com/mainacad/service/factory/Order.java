package com.mainacad.service.factory;

import com.mainacad.settings.Settings;
import com.mainacad.util.FileUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Order extends Thread {
    private Product product;
    private LinkedList<StageInWork> stagesInWork;

    public Order(Product product, String... names) {
        this.product = product;
        stagesInWork = new LinkedList<>();

        for (int i = 0; i < product.getStages().size(); i++) {
            stagesInWork.add(new StageInWork(product.getStages().get(i), names[i]));
        }
    }

    @Override
    public void run() {
        String fileNamePrefix = product.getName();


        for (int i = 0; i < stagesInWork.size(); i++) {
            try {
                TimeUnit.SECONDS.sleep(stagesInWork.get(i).getStage().getSeconds());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String fileNameSuffix = stagesInWork.get(i).getWorker();
            List<String> text = Arrays.asList(new Date().toString());

           try {
                FileUtil.appendTo(text, Settings.FILES_DIR, fileNamePrefix + "_" + fileNameSuffix);
               System.out.println(fileNamePrefix + "_" + fileNameSuffix);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
