package com.mainacad.runner;

import com.mainacad.service.SearchService;
import com.mainacad.service.SearchThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchRunner {
    List<Integer> listOfTwos = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(21, 12, 3, 14, 25, 1, 7, 28, 9, 210, 112, 12, 213,
                14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7,
                14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7,
                14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7, 28, 9,
                210, 112, 12, 213, 14, 61, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7,
                14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7,
                14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 62, 14, 25, 1, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7,
                14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7,
                14, 15, 5, 17, 63, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 64, 3, 14, 25, 1, 7,
                14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7,
                28, 9, 210, 112, 12, 65, 14, 15, 5, 17, 182, 19, 20, 8, 9);

        // BUGS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        List<Integer> resultList;
        long timeStart1 = System.currentTimeMillis();
        resultList = SearchService.search(list, 1);
        long timeEnd1 = System.currentTimeMillis();
        System.out.println((timeEnd1 - timeStart1) + " ms" + "- Multi method");
        System.out.println(resultList);

        long timeStart2 = System.currentTimeMillis();
        resultList = SearchService.search(list, 5);
        long timeEnd2 = System.currentTimeMillis();
        System.out.println((timeEnd2 - timeStart2) + " ms" + "- Multi method");
        System.out.println(resultList);
    }
}
