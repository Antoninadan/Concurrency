package com.mainacad.runner;

import com.mainacad.method.callable.FileLengtCounter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// CallableRunner
// FixedThreadPoolRunner
public class MultiThreadWithFixedThreadPoolRunner {

    public static void main(String[] args) {
        System.out.println(calculateFolderSize("C:/path"));
    }

    public static Long calculateFolderSize(String folderAdress) {
        File file = new File(folderAdress);
        File[] fileArray = file.listFiles();
        List<Future<Long>> result = new ArrayList<>();

        // thread pool for 3
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        ArrayList<Callable<Long>> tasks = new ArrayList<>();
        for (File fileElement : fileArray) {
            tasks.add(new FileLengtCounter(fileElement.getAbsolutePath()));
        }

        try {
            result = executorService.invokeAll(tasks);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
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
