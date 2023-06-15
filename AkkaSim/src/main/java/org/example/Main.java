package org.example;

import java.util.concurrent.ExecutionException;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        BigPrime b = new BigPrime();
        ThreadGroup gr1 = new ThreadGroup("threadGr1");
        Thread t = new Thread(gr1,new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<20;i++) {
                    try {
                        b.tell(1);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        ThreadGroup gr2 = new ThreadGroup("threadGr2");
        Thread t1 = new Thread(gr2,new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<20;i++) {
                    try {
                        b.tell(2);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        AnotherThreadGenerator antg = new AnotherThreadGenerator();
        antg.call(b);
        t.start();
        t1.start();


        System.out.println("End Time => "+(System.currentTimeMillis()-startTime) +"ms");
    }

}