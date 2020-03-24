package com.mainacad.service.search;

import java.util.List;

public class SearchOneThread extends Thread {
    List<Integer> listForSearch;
    Integer searched;
    SaverOneThread spreadThread;

    public SearchOneThread(List<Integer> listForSearch, SaverOneThread spreadThread) {
        this.listForSearch = listForSearch;
        this.spreadThread = spreadThread;
    }


    @Override
    public void run() throws IllegalThreadStateException{
//        System.out.println(spreadThread.getState());
        searched = search();

        if (searched != null) {
            spreadThread.saveResult(searched);
            if (spreadThread.getState().equals(Thread.State.NEW)) {
                spreadThread.start();
                System.out.println(Thread.currentThread().getName() + " run the spread");
            }
            System.out.println(Thread.currentThread().getName() + " search " + searched);
        }
    }

    public Integer search() {
        for (Integer element : listForSearch) {
            if (Integer.toString(element).contains("6")) return element;
        }
        return null;
    }
}
