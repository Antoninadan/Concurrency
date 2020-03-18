package com.mainacad.runner;

import com.mainacad.service.SearchService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchRunner {
    List<Integer> listOfTwos = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(21, 12, 3, 14, 25, 6, 7, 28, 9, 210, 112, 12, 213,
                14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7,
                14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7,
                14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7,
                14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7,
                14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7,
                14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7,
                14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7,
                14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7, 28, 9,
                210, 112, 12, 213, 14, 15, 216, 17, 182, 19, 20, 8, 9, 21, 12, 3, 14, 25, 6, 7,
                28, 9, 210, 112, 12, 213, 14, 15, 216, 17, 182, 19, 20, 8, 9);
//        21, 12, 25,  28, 210, 112, 12, 213, 216, 182, 20

        List<Integer> resultList = Collections.synchronizedList(new ArrayList<Integer>());

        int size = list.size();
        int parts = 3; // on what parts we can devide
        int[][] result = getIndexesOfParts(size, parts);

        System.out.println("size = " + size);
        System.out.println("parts = " + parts);

        long timeStart1 = System.currentTimeMillis();
        for (int i = 0; i < parts; i++) {
            List<Integer> listForSearch = new ArrayList<>();
            for (int j = result[i][0]; j <= result[i][1]; j++) {
                listForSearch.add(list.get(j));
            }
            SearchService searchService = new SearchService(listForSearch, resultList);
            searchService.start();
        }
        long timeEnd1 = System.currentTimeMillis();
        System.out.println((timeEnd1 - timeStart1) + " ms" + "- Multi method");
        System.out.println(resultList);

        parts = 1; // on what parts we can devide
        long timeStart2 = System.currentTimeMillis();
        for (int i = 0; i < parts; i++) {
            List<Integer> listForSearch = new ArrayList<>();
            for (int j = result[i][0]; j <= result[i][1]; j++) {
                listForSearch.add(list.get(j));
            }
            SearchService searchService = new SearchService(listForSearch, resultList);
            searchService.start();
        }
        long timeEnd2 = System.currentTimeMillis();
        System.out.println((timeEnd2 - timeStart2) + " ms" + "- Multi method");
        System.out.println(resultList);


    }


    private static int[][] getIndexesOfParts(int size, int parts) {
        int[][] result = new int[parts][2];
        int remains = getRemainsOfDividing(size, parts);
        int m = 0;

        for (int i = 1; i <= parts; i++) {
            if (m != (parts - 1)) {
                result[i - 1][0] = m * (size / parts);
                result[i - 1][1] = ((m + 1) * (size / parts) - 1);
            } else {
                result[i - 1][0] = m * (size / parts);
                result[i - 1][1] = (m + 1) * (size / parts) + remains - 1;
            }
            m++;
        }
        return result;
    }

    private static int getRemainsOfDividing(int size, int parts) {
        if (parts * (size / parts) == size) {
            return 0;
        } else {
            return size - parts * (size / parts);
        }
    }
}
