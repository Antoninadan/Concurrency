package com.mainacad.service.searchone;

import com.mainacad.service.searchone.SearchThread;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Saver {
    private static Integer result;
    private Condition conditionFinishSearch;
    private List<SearchThread> threads;

    public Saver(Condition conditionFinishSearch, List<SearchThread> threads) {
        this.conditionFinishSearch = conditionFinishSearch;
        this.threads = threads;
    }

    public static Integer getResult() {
        return result;
    }

    public synchronized Integer saveResult(Integer searched) {
        this.result = searched;
        threads.forEach(it -> it.interrupt());
        System.out.println("saver resu " + result);
//        conditionFinishSearch.signalAll();
        return result;
    }
}
