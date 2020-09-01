package com.mainacad.service.factory;

import javax.swing.plaf.nimbus.State;

public class StageInWork {
    private Stage stage;
    private String worker;

    public StageInWork(Stage stage, String worker) {
        this.stage = stage;
        this.worker = worker;
    }

    public Stage getStage() {
        return stage;
    }

    public String getWorker() {
        return worker;
    }
}
