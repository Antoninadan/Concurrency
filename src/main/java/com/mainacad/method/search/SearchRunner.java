package com.mainacad.method.search;

import com.mainacad.method.search.SearchOneService;
import com.mainacad.method.search.SearchService;

import java.util.*;

public class SearchRunner {
    List<Integer> listOfTwos = Collections.synchronizedList(new ArrayList<>());

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
        Integer searched = SearchOneService.searchOne(list,5);
        long timeEnd3 = System.currentTimeMillis();
        System.out.println((timeEnd3 - timeStart3) + " ms" + "- method");
        System.out.println(searched);


        System.out.println("FINISH!!!!!!!!!");
//
//        // Comparator
//        Collections.sort(list);
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            public int compare(Integer objOne, Integer objTwo) {
//                return objOne.compareTo(objTwo);
//            }
//        };
//        int index = Collections.binarySearch(list, 333, comparator);
//        System.out.println("index = " + index);

        List<Integer> resultList;
        long timeStart1 = System.currentTimeMillis();
        resultList = SearchService.search(list, 1);
        long timeEnd1 = System.currentTimeMillis();
        System.out.println((timeEnd1 - timeStart1) + " ms" + "- method");
        System.out.println(resultList);

        long timeStart2 = System.currentTimeMillis();
        resultList = SearchService.search(list, 5);
        long timeEnd2 = System.currentTimeMillis();
        System.out.println((timeEnd2 - timeStart2) + " ms" + "- Multi method");
        System.out.println(resultList);

    }
}
