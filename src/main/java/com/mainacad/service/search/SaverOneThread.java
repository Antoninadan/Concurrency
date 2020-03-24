package com.mainacad.service.search;

public class SaverOneThread extends Thread {
    private Integer result;
    private Thread mainThread;

    public Integer getResult() {
        return result;
    }

    public SaverOneThread(Thread mainThread) {
        this.mainThread = mainThread;
    }

    public synchronized Integer saveResult(Integer searched){
        result = searched;
        return  result;
    }

    @Override
    public void run() {
       if (mainThread.isAlive()) {mainThread.interrupt();
           System.out.println("!!!!!!!!!!!!!Interrapt main");}
    }
}
