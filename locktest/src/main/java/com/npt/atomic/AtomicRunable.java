package com.npt.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicRunable implements Runnable {
    private static int count;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            count++;
            atomicInteger.incrementAndGet();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];
        Runnable runnable = new AtomicRunable();
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(runnable) ;
            threads[i].start();
        }
        Thread.sleep(3000);
        System.out.println(count);
        System.out.println(atomicInteger);
    }
}
