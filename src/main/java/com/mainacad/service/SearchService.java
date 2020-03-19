package com.mainacad.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchService {
    public static List<Integer> resultList =  Collections.synchronizedList(new ArrayList<>());

    public static List<Integer> search(List<Integer> Integers, int parts) {
        List<List<Integer>> listOfLists = divideList(Integers, parts);

        for (List<Integer> listForSearch:listOfLists) {
            SearchThread SearchThread = new SearchThread(listForSearch);
            SearchThread.start();
        }
        return resultList;
    }

    public static <T> List<List<T>> divideList(List<T> list, int parts) {
        int size = list.size();
        int[][] indexesOfParts = getIndexesOfParts(size, parts);
        List<List<T>> result = new ArrayList<>();

        for (int i = 0; i < parts; i++) {
            List<T> listForSearch = new ArrayList<>();
            for (int j = indexesOfParts[i][0]; j <= indexesOfParts[i][1]; j++) {
                listForSearch.add(list.get(j));
            }
            result.add(listForSearch);
        }
        return result;
    }

    public static int[][] getIndexesOfParts(int size, int parts) {
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

    public static int getRemainsOfDividing(int size, int parts) {
        if (parts * (size / parts) == size) {
            return 0;
        } else {
            return size - parts * (size / parts);
        }
    }
}

