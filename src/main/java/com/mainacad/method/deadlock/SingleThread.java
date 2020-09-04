package com.mainacad.method.deadlock;

public class SingleThread extends Thread {
    private B classB;

    public void setClassB(B classB) {
        this.classB = classB;
    }

    @Override
    public void run() {
        System.out.println("SinglThread call classB.getValueFromA()" + classB.getValueFromA());
    }

}
