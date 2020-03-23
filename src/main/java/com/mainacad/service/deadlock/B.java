package com.mainacad.service.deadlock;

public class B {
    private A classA;

    public void setClassA(A classA) {
        this.classA = classA;
    }

    public synchronized int getValueFromA() {
        System.out.println("Class B call in thread: " + Thread.currentThread().getName());
        System.out.println("Class B call method getValue() class A");
        return classA.getValue() ;
    }
}
