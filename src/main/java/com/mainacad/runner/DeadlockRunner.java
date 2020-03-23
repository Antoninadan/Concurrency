package com.mainacad.runner;

import com.mainacad.service.deadlock.A;
import com.mainacad.service.deadlock.B;
import com.mainacad.service.deadlock.SingleThread;

public class DeadlockRunner {

    public static void main(String[] args) {
        A classA = new A(10);
        B classB = new B();

        classA.setClassB(classB);
        classB.setClassA(classA);

        SingleThread singleThread = new SingleThread();
        singleThread.setClassB(classB);
        singleThread.start();
//        Thread cuThread = new Thread(singleThread);
//        cuThread.start();
        System.out.println("classA.getSumm() = " + classA.getValueFromB());
    }
}
