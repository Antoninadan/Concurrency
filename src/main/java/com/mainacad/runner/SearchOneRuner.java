package com.mainacad.runner;

import com.mainacad.service.searchone.SearchService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchOneRuner {

    public static void main(String[] args) throws InterruptedException, IllegalThreadStateException {
        List<Integer> list = Arrays.asList(21, 12, 333, 14, 25, 1, 7, 28, 9, 210, 112, 333, 213,
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
                28, 9, 210, 112, 12, 65, 14, 15, 5, 17, 182, 19, 20, 8, 9,
                210, 112, 12, 213, 14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 1, 7,
                14, 15, 5, 17, 182, 19, 20, 8, 9, 21, 12, 2, 14, 25, 1, 7, 28, 9);


        System.out.println("\n" + "First one");
        long timeStart3 = System.currentTimeMillis();
        Integer searched = SearchService.searchOne(list, 5);
        long timeEnd3 = System.currentTimeMillis();
        System.out.println((timeEnd3 - timeStart3) + " ms" + "- method");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!" + searched);


        System.out.println("FINISH!!!!!!!!!");
    }

}
