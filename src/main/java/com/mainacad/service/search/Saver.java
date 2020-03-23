package com.mainacad.service.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Saver {
    static List<Integer> resultList = Collections.synchronizedList(new ArrayList<>());

    public static synchronized List<Integer> saveResults(List<Integer> searched){
        resultList.addAll(searched);
        return  resultList;
    }
}
