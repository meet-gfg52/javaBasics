package com.gfg.jbdl.domain;

import java.util.concurrent.Callable;

public class MyCallableTaskExecutor implements Callable<Integer> {


    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("here in thread run:"+Thread.currentThread());
    }


    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        System.out.println("here in thread run:"+Thread.currentThread());
        return 10;
    }
}
