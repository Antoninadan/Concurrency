package com.mainacad.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchThread extends Thread {
    List<Integer> listForSearch;

    public SearchThread(List<Integer> listForSearch) {
        this.listForSearch = listForSearch;
    }

    @Override
    public void run() {
        synchronized (SearchService.resultList)
        {SearchService.resultList.addAll(search());}
//        System.out.println(search());
//        System.out.println();
    }

    private List<Integer> search() {
        return listForSearch.stream().filter(it -> Integer.toString(it).contains("6")).collect(Collectors.toList());
    }
}
