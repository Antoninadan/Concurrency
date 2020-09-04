package com.mainacad.method.join;

import com.mainacad.util.TimeFixUtil;

import java.io.IOException;


public class JoinRunner {
    public static void main(String[] args) throws IOException {
        String pathName = "files";
        String fileName = "story.txt";
        String input = "Year";
        Reader reader = new Reader(pathName, fileName, input);


        TimeFixUtil timeFixUtil = new TimeFixUtil();
        timeFixUtil.elapsedTime();

        for (int i =1; i<= 5; i++) {
            Worker worker = new Worker(reader);
            Thread workerThread = new Thread(worker);
            workerThread.start();
        }
        System.out.println("not join time = " + timeFixUtil.elapsedTime());



        TimeFixUtil timeFixUtil2 = new TimeFixUtil();
        timeFixUtil2.elapsedTime();

        for (int i =1; i<= 5; i++) {
            Worker worker = new Worker(reader);
            Thread workerThread = new Thread(worker);
            workerThread.start();
            try {
                workerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("join time = " + timeFixUtil2.elapsedTime());

    }


}
