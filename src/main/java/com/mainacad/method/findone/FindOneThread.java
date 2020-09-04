package com.mainacad.method.findone;

import java.util.List;
import java.util.Random;

public class FindOneThread extends Thread {
    List<Integer> listForSearch;
    Integer result;
    Regulator regulator;

    public FindOneThread(List<Integer> listForSearch, Regulator regulator) {
        this.listForSearch = listForSearch;
        this.regulator = regulator;
    }

    @Override
    public void run() throws IllegalThreadStateException {
        result = search();
        if (result != null) {
            System.out.println(Thread.currentThread().getName() + " search " + result);
            regulator.saveResult(result);
        }
    }

    public Integer search() {
//        try {
//            Thread.sleep(getRandomNumberInRange(1000, 10000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (Integer element : listForSearch) {
            if (Integer.toString(element).contains("6")) return element;
        }
        return null;
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
