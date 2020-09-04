package com.mainacad.method.search2;

import com.mainacad.util.DivideUtil;

import java.util.ArrayList;
import java.util.List;


public class MultiSearchI {
    List<Integer> list;
    int parts;

    public MultiSearchI(List<Integer> list, int parts) {
        this.list = list;
        this.parts = parts;
    }

    public Integer findOneSimilarTo(Integer criterion) {
        List<ThreadItemI> threads = new ArrayList<>();
        DispatcherI dispatcherI = new DispatcherI(threads);

        int size = list.size();
        int[][] indexesOfParts = DivideUtil.getIndexesPerParts(size, parts);
        for (int i = 0; i < parts; i++) {
            ThreadItemI threadItem = new ThreadItemI(list.subList(indexesOfParts[i][0], indexesOfParts[i][1] + 1),
                    criterion, dispatcherI);
            threads.add(threadItem);
        }
        threads.forEach(it -> it.start());
        return dispatcherI.getResult();
    }

}
