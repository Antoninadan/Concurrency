package com.mainacad.runner;

import com.mainacad.service.callable.FileLengtCounter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// CallableRunner
//
public class FixedThreadPoolRunner {

    public static void main(String[] args) {
        System.out.println(calculateFolderSize("C:/path"));
    }

    public static Long calculateFolderSize(String folderAdress) {
        File file = new File(folderAdress);
        File[] fileArray = file.listFiles();
        List<Future<Long>> result = new ArrayList<>();

        // thread pool for 3
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (File fileElement : fileArray) {
            result.add(executorService.submit(new FileLengtCounter(fileElement.getAbsolutePath())));
        }

        Long totalSize = 0L;
        for (Future<Long> future : result) {
            try {
                totalSize += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        return totalSize;
    }
}
