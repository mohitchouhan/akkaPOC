package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class Actor {

    protected LinkedBlockingQueue<Object> mailbox = new LinkedBlockingQueue<>();
    public void tell(int a) throws ExecutionException, InterruptedException{}
    public void createReceive() throws ExecutionException, InterruptedException {}
}
