package com.mainacad.service.consistent;

import java.util.ArrayList;
import java.util.List;

public class ConsistentRunner {
    public static void main(String[] args) {
        List<ThreadItem> threadList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            ThreadItem threadItem = new ThreadItem(Integer.toString(i));
            threadList.add(threadItem);
            threadItem.start();
            try {
                threadItem.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(ThreadItem each:threadList){
            System.out.println(each.getResult());

        }

    }
}
