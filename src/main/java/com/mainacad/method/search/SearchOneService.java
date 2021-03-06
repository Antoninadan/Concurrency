package com.mainacad.method.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchOneService {
    public static Integer searchOne(List<Integer> Integers, int parts) throws InterruptedException {
        List<List<Integer>> listOfLists = divideList(Integers, parts);
        List<SearchOneThread> threads = new ArrayList<>();
        Thread currentThread = Thread.currentThread();
        Thread markerThread = new Thread("marker");
        SaverOneThread saverOneThread = new SaverOneThread(currentThread);
        Integer result = null;

        System.out.println(currentThread.getName());

        for (List<Integer> listForSearch : listOfLists) {
            SearchOneThread searchOneThread = new SearchOneThread(listForSearch, saverOneThread);
            threads.add(searchOneThread);
            searchOneThread.setDaemon(true);
            searchOneThread.start();
        }

        return result;
    }

    private static Thread checkForInterraptedThread(List<SearchThread> threads) {
        Thread result = null;
        while (result == null) {
            for (Thread element : threads) {
                if (element.isInterrupted())
                    result = element;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

        private static void waitingForFinishAllThreads (List < SearchThread > threads) {
            while (
                    threads.stream().filter(thread -> (thread.isAlive()
                            || thread.getState() == Thread.State.NEW
                            || thread.isInterrupted())).
                            collect(Collectors.toList()).size() != 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static <T > List < List < T >> divideList(List < T > list, int parts){
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

        public static int[][] getIndexesOfParts ( int size, int parts){
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

        public static int getRemainsOfDividing ( int size, int parts){
            if (parts * (size / parts) == size) {
                return 0;
            } else {
                return size - parts * (size / parts);
            }
        }
    }

