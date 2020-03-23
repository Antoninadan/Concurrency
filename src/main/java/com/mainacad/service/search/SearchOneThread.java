package com.mainacad.service.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchOneThread extends Thread {
    List<Integer> listForSearch;
    Integer searched;
    Thread mainThread;

    public SearchOneThread(List<Integer> listForSearch, Thread mainThread) {
        this.listForSearch = listForSearch;
        this.mainThread = mainThread;
    }

    public Integer getSearched() {
        return searched;
    }

    @Override
    public void run() {
        searched = search();
        if (searched != null) {
            mainThread.interrupt();
            SaverOne.saveResult(searched);
        }
    }

    private Integer search() {
        for (Integer element : listForSearch) {
            if (Integer.toString(element).contains("6")) return element;
        }
        return null;
    }
}
