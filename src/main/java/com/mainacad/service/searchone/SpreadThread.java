package com.mainacad.service.searchone;

public class SpreadThread extends Thread {
    private Integer result;
    private Thread mainThread;



    public SpreadThread(Thread mainThread) {
        this.mainThread = mainThread;
    }

    public Integer getResult() {
        return result;
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
