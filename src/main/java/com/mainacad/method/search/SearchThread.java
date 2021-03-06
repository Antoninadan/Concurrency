package com.mainacad.method.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchThread extends Thread {
    List<Integer> listForSearch;
    List<Integer> searched = new ArrayList<>();

    public SearchThread(List<Integer> listForSearch) {
        this.listForSearch = listForSearch;
    }

    public List<Integer> getSearched() {
        return searched;
    }

    @Override
    public void run() {
        searched.addAll(search());
        Saver.saveResults(searched);
    }

    private List<Integer> search() {
        return listForSearch.stream().filter(it -> Integer.toString(it).contains("6")).collect(Collectors.toList());
    }
}
