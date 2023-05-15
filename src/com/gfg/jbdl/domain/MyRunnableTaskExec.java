package com.gfg.jbdl.domain;

public class MyRunnableTaskExec implements Runnable {
    @Override
    public void run() {
        System.out.println("here in runnable");
        System.out.println(10/2);
        System.out.println("here after exception runnable");
    }
}
