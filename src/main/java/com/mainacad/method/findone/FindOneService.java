package com.mainacad.method.findone;

import java.util.ArrayList;
import java.util.List;

public class FindOneService {
    public static Integer findOne(List<Integer> Integers, int parts) {
        List<List<Integer>> listOfLists = ListDivider.divideList(Integers, parts);
        List<FindOneThread> threads = new ArrayList<>();
        Regulator regulator = new Regulator(threads);

        for (List<Integer> listForSearch : listOfLists) {
            FindOneThread findOneThread = new FindOneThread(listForSearch, regulator);
            threads.add(findOneThread);
        }
        threads.forEach(it -> it.start());
        return regulator.getResult();
    }
}

