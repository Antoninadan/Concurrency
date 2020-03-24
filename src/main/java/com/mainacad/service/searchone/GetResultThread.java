package com.mainacad.service.searchone;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class GetResultThread extends Thread{
    ReentrantLock locker = new ReentrantLock();
    Condition conditionFinishSearch;

    public GetResultThread(Condition conditionFinishSearch) {
        this.conditionFinishSearch = conditionFinishSearch;
    }

    @Override
    public void run() {

        locker.lock();
        try {
            // пока нет, ожидаем
            while (Saver.getResult() == null){
                System.out.println("+++++++++++++++");
                conditionFinishSearch.await();}

            System.out.println("Result       : " + Saver.getResult());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}
