package com.mainacad.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService extends Thread {
    List<Integer> listForSearch;
    List<Integer> resultList;


    public SearchService(List<Integer> listForSearch, List<Integer> resultList) {
        this.listForSearch = listForSearch;
        this.resultList = resultList;
    }

    @Override
    public void run() {
        resultList.addAll(search());
    }

    private List<Integer> search() {
        return listForSearch.stream().filter(it -> Integer.toString(it).contains("2")).collect(Collectors.toList());
    }
}
