package com.mainacad.runner;

import com.mainacad.service.callable.FileLengtCounter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

//Программа, которая в параллельных потоках вычислит размер файлов в
//        каталоге, и вернет их сумму.
// FixedThreadPoolRunner
public class CallableRunner {

    public static void main(String[] args) {
        System.out.println(calculateFolderSize("C:/path"));
    }

    public static Long calculateFolderSize(String folderAdress) {
        File file = new File(folderAdress);
        File[] fileArray = file.listFiles();
        List<Future<Long>> result = new ArrayList<>();

        for (File fileElement : fileArray) {
            FutureTask<Long> futureTask = new FutureTask<>(new FileLengtCounter(fileElement.getAbsolutePath()));
            result.add(futureTask);
            Thread thread = new Thread(futureTask);
            thread.start();
        }

        Long totalSize = 0L;
        for (Future<Long> future : result) {
            try {
                totalSize += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return totalSize;
    }

}
