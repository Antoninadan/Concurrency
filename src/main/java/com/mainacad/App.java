package com.mainacad;

import com.mainacad.method.ConcurrencyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        List<String> logins = new ArrayList<>();
        List<String> logins = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i< 10000; i++) {
            ConcurrencyService service = new ConcurrencyService(logins);
            threads.add(service);
            service.start();
        }

        do {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (
                threads.stream().filter( thread -> (thread.isAlive()
                        || thread.getState() == Thread.State.NEW
                || thread.isInterrupted()) ).
                        collect(Collectors.toList()).size() > 0);
        System.out.println(logins.size());
    }
}
