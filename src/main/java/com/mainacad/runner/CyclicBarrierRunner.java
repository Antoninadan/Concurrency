package com.mainacad.runner;

import com.mainacad.service.cyclicbarrier.SingleThread;
import com.mainacad.service.cyclicbarrier.SynchClass;

//CyclicBarrier — синхронизаторы, использующиеся при условии, что потоки
//        должны остановить свое выполнение до тех пор, пока N потоков также не подойдут к
//        указанной точке выполнения. Т.е. это - своеобразный барьер, в который «упрутся»
//        потоки, пока их не наберется достаточное их количество.


public class CyclicBarrierRunner {
    public static void main(String[] args) {
        SynchClass synchClass = new SynchClass(5);
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new SingleThread(synchClass));
            thread.start();
        }
        System.out.println(synchClass.getNumber());
    }

}
