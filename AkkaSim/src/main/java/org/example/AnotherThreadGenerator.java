package org.example;

import java.util.concurrent.ExecutionException;

public class AnotherThreadGenerator {
    public void call(BigPrime b){
        ThreadGroup gr1 = new ThreadGroup("threadGr3");
        Thread t2 = new Thread(gr1,new Runnable() {
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
        t2.start();
    }
}
