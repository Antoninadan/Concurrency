package com.mainacad.service.dock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Regulator {
    public static final Integer NUMBER_OF_DOCKS = 2;
    public static final Long UNLOADING_TIME = 2L;

    private ReentrantLock locker;
    private Condition needfinishUnloading;
    private Condition needFreeDock;
    private List<Dock> docks;

    public Regulator() {
        for (int i =1; i<= NUMBER_OF_DOCKS; i++){
            Dock dock = new Dock(Integer.toString(i), null);
            docks.add(dock);
        }

        locker = new ReentrantLock();
        needfinishUnloading = locker.newCondition();
        needFreeDock = locker.newCondition();
    }

    public void catchDock(Ship ship) {
        locker.lock();
        try {
            while (choseFreeDock() == null) ;
            needFreeDock.await();

            Dock freeDock = choseFreeDock();
            freeDock.setLastCatch(new Date());
            System.out.println("Dock " + freeDock.getName() + "free");
            System.out.println("Ship " + ship.getName() + "loading");
            needfinishUnloading.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unloadDock() {
        locker.lock();
        try {
            while (unloadingNotFinish(dock))
                needfinishUnloading.await();

            dock.setLastCatch(null);
            System.out.println("Dock " + dock.getName() + " free" + " with time = " +dock.getLastCatch());
            needFreeDock.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Dock choseFreeDock() {
        for (Dock dock : docks) {
            if (dock.getLastCatch() == null) return dock;
        }
        return null;
    }

    public boolean unloadingNotFinish(Dock dock) {

        Date now = new Date();
        if (dock.getLastCatch() == null) return false;
        return (now.getTime() - dock.getLastCatch().getTime() <= UNLOADING_TIME) ? true : false;
    }

}
