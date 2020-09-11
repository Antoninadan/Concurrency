package com.mainacad.method.lifecycle;

public class FirstThread extends Thread{

    @Override
    public void run(){
        System.out.println("First thread ran");
    }

}
