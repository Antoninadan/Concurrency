package com.mainacad.method.findone;


import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Regulator {
    private static Integer result = null;
    ReentrantLock locker;
    private Condition conditionFinishSearch;
    private List<FindOneThread> threads;

    public Regulator(List<FindOneThread> threads) {
        this.threads = threads;
        locker = new ReentrantLock();
        conditionFinishSearch = locker.newCondition();
    }

    public synchronized Integer saveResult(Integer searched) {
        locker.lock();
        this.result = searched;

        conditionFinishSearch.signalAll();
        locker.unlock();
        return result;
    }

    public Integer getResult() {
        locker.lock();
        try {
            while ((result == null && isRunningThreads())) {
                System.out.println("Visyak");
                conditionFinishSearch.await();
            }
            threads.forEach(it -> it.interrupt());
            return result;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
        return null;
    }

    private boolean isRunningThreads() {
        if (threads.stream().filter(thread -> (thread.isAlive()
                || thread.getState() == Thread.State.NEW
                || thread.isInterrupted())).
                collect(Collectors.toList()).size() > 0)
            return true;
        else return false;
    }
}
