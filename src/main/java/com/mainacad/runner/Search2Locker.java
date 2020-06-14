package com.mainacad.runner;

import com.mainacad.service.search2.LinearSearchI;
import com.mainacad.service.search2.MultiSearchI;
import com.mainacad.settings.Settings;
import com.mainacad.util.FileUtil;
import com.mainacad.util.TimeFixUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// Find one record from file which equals to criterion
// Uses ReentrantLock
public class Search2Locker {
    public static void main(String[] args) throws IOException {
        List<String> readedFileStrings = FileUtil.read(Settings.FILES_DIR, "integers.txt");
        Integer criterion = 7777;
        List<Integer> saved = new ArrayList<>();
        for (String each : readedFileStrings) {
            saved.add(Integer.valueOf(each));
        }

        LinearSearchI linearSearch = new LinearSearchI(saved);
        TimeFixUtil timeFixUtil1 = new TimeFixUtil();
        Integer result = linearSearch.findOneSimilarTo(criterion);
        timeFixUtil1.elapsedTimePrint();
        System.out.println("result:               " + result);
        System.out.println();

        System.out.println();
        MultiSearchI multiSearchI = new MultiSearchI(saved, 4);
        TimeFixUtil timeFixUtil2 = new TimeFixUtil();
        Integer result2 = multiSearchI.findOneSimilarTo(criterion);
        System.out.println("TIME = "+ timeFixUtil2.elapsedTime());
        System.out.println("result:               " + result2);
        System.out.println();
    }
}
