package com.mainacad.method.deadlock;

public class A {
    private int value;
    private B classB;

    public A(int value) {
        this.value = value;
    }

    public void setClassB(B classB) {
        this.classB = classB;
    }

    public synchronized int getValue() {
        System.out.println("Class A call in thread: " + Thread.currentThread().getName());
        System.out.println("Class A call method getValue() " + "\n");
        return this.value;
    }

    public synchronized int getValueFromB() {
        System.out.println("Class A in thread: " + Thread.currentThread().getName());
        System.out.println("Class A call method  classB.getValue() "  + "\n");
        return classB.getValueFromA() + this.value;
    }
}