package com.mainacad.method.join;

public class Worker implements Runnable{
    Reader reader;

    public Worker(Reader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        System.out.println(reader.countWords());
    }
}
