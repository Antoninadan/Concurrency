package com.mainacad.method.createthread;

public class CreateConstructorApp extends Thread{
    CreateConstructorApp() {
        super();
        start();
    }

    public void run() {
        System.out.println("Mой поток запущен...");

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Второй поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Второй поток прерван");
        }
    }

    public static void main(String[] args) {
        CreateConstructorApp m = new CreateConstructorApp();
    }

}
