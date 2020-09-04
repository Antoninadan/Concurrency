package com.mainacad.method.callable;

import java.io.File;
import java.util.concurrent.Callable;

public class FileLengtCounter implements Callable<Long> {
    private String fileAdress;

    public FileLengtCounter(String fileAdress) {
        this.fileAdress = fileAdress;
    }

    @Override
    public Long call() throws Exception {
        File file = new File(fileAdress);
        if (!file.exists() || !file.isFile()) {
            return 0L;
        }
        return file.length();
    }
}
