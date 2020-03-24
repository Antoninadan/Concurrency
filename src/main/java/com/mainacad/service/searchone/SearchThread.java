package com.mainacad.service.searchone;

import com.mainacad.service.search.SaverOneThread;

import java.util.List;

public class SearchThread extends Thread {
    List<Integer> listForSearch;
    Integer searched;
    Saver saver;

    public SearchThread(List<Integer> listForSearch, Saver saver) {
        this.listForSearch = listForSearch;
        this.saver = saver;
    }


    @Override
    public void run() throws IllegalThreadStateException {
        searched = search();
        if (searched != null) {
            System.out.println(Thread.currentThread().getName() + " search " + searched);
            saver.saveResult(searched);
        }
    }

    public Integer search() {
        for (Integer element : listForSearch) {
            if (Integer.toString(element).contains("6")) return element;
        }
        return null;
    }
}
