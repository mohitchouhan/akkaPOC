package org.example;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.*;

public class BigPrime extends Actor {


    public BigPrime(){}
    @Override
    public  void tell(int a) throws ExecutionException, InterruptedException {
        mailbox.add(a);
        this.createReceive();
    }
    @Override
    public void createReceive() throws ExecutionException, InterruptedException {

        switch ((int)mailbox.poll()){
            case 1 :
                FutureTask v = new FutureTask<>(new Callable<BigInteger>() {
                    @Override
                    public BigInteger call() throws Exception {
                       return getBigPrime();
                    }
                });

                final Thread t =new Thread(v);
                t.start();
                System.out.println(t.getName()+" "+t.getThreadGroup());
                BigInteger number = (BigInteger) v.get();
                t.stop();
                break;
            case 2:
                FutureTask v1 = new FutureTask<>(new Callable<Double>() {
                    @Override
                    public Double call() throws Exception {
                        return getNumber();
                    }
                });
                final Thread t1 =new Thread();
                t1.start();
                System.out.println(t1.getName()+" "+t1.getThreadGroup());
                t1.stop();

        }
    }

    private static BigInteger getBigPrime(){
        BigInteger bigInteger = new BigInteger(2000,new Random());
        return bigInteger.nextProbablePrime();
    }

    private static double getNumber(){
        return Math.random();
    }

}
