package com.gfg.jbdl.service;

import com.gfg.jbdl.domain.MyCallableTaskExecutor;
import com.gfg.jbdl.domain.MyRunnableTaskExec;

import java.util.concurrent.*;

public class ThreadExample {
    /**
     * 1. Concurrent
     * 2. parallel
     * 3. Async
     *
     *
     *
     * coding + music - parallel
     * coding + replying message on mobile - concurrent
     * code is compiling & went to collect a parcel -async
     * */

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println(Runtime.getRuntime().availableProcessors());

        Long start=System.currentTimeMillis();

        System.out.println("starting here:"+Thread.currentThread().getName());
        int a=0;

           MyCallableTaskExecutor t1=new MyCallableTaskExecutor();
        //int a=t1.call();
//
            MyCallableTaskExecutor t2=new MyCallableTaskExecutor();
//        a=a+t2.call();
//
           MyCallableTaskExecutor t3=new MyCallableTaskExecutor();
         // t3.call();

        MyRunnableTaskExec t4=new MyRunnableTaskExec();


        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        ExecutorService service2 = Executors.newFixedThreadPool(4);
        Future<Integer> t1Out = service.submit(() -> t1.call());
        Future<Integer> t2Out = service.submit(() -> t2.call());
        Future<Integer> t3Out = service.submit(() -> t3.call());
//        try {
//            service.submit(() -> t4.run());
//        }catch (Exception e){
//            System.out.println("exception here ");
//            e.printStackTrace();
//        }

//        a = a + t1Out.get();
//        a = a + t2Out.get();
//        a = a + t3Out.get();
        CompletableFuture<Boolean> aFuture = CompletableFuture.supplyAsync(() -> {
            try{
                t4.run();
            }catch (Exception ex){
                ex.getMessage();
                return false;
            }
            return true;
        }).thenApplyAsync(status -> {
            System.out.println("here in compFuture"+status);
            return status;
        });

       // aFuture.get();  ** --> this will wait for the thread methods to be finished. The above line is blocking call

        a=a+1;
        System.out.println("a="+a);
        Long end=System.currentTimeMillis();
        System.out.println("done in time:"+(end-start));

        service.shutdown();
    }


/**
 *
 *    // Thread implements the runnable so it does not return anything, It fire and forget way.
 *
 *         /*The Runnable interface is a functional interface and has a single run() method which doesn't accept any parameters and does not return any values.
 *          * Since the method signature does not have the “throws” clause specified, there is no way to propagate further checked exceptions.
 *          *
 *          * The Callable interface is a generic interface containing a single call() method – which returns a generic value V:
 *          * Callable's call() method contains “throws Exception” clause so we can easily propagate checked exceptions further:
 *
 * Future are used for getting the output after the thread finishes the computation.
 * Ex:
 *  When any service is booked. we get a token(Future here in java) and we wait for our token number to come and get
 *  the service. Similar way Future ( intro in 1.5) waits and blocks the calling thread to get output when .get() is called
 *
 *  to avoid blocking in Java 1.8 Completable Future were introduced which implements Future and CompletionStage.
 *  It is a non-blocking call used with function which accepts consumer and supplier which needs to be processed after thread finishes
 *
 *  We use executorServices to manage thread rather than creating a custom new threads.
 *  ExecutorService is framework inbuilt to handle and limit the thread.
 *         * types of executors
 *             Single Thread Executor : A thread pool with only one thread. So all the submitted tasks will be executed sequentially. Method : Executors.newSingleThreadExecutor()
 *
 *             Cached Thread Pool : A thread pool that creates as many threads it needs to execute the task in parrallel. The old available threads will be reused for the new tasks. If a thread is not used during 60 seconds, it will be terminated and removed from the pool. Method : Executors.newCachedThreadPool()
 *
 *             Fixed Thread Pool : A thread pool with a fixed number of threads. If a thread is not available for the task, the task is put in queue waiting for an other task to ends. Method : Executors.newFixedThreadPool()
 *
 *             Scheduled Thread Pool : A thread pool made to schedule future task. Method : Executors.newScheduledThreadPool()
 *
 *             Single Thread Scheduled Pool : A thread pool with only one thread to schedule future task. Method : Executors.newSingleThreadScheduledExecutor()
 *
 *
 *
 *  Future cannot handle the checked exception while CompletableFuture are enhanced with handling the Checked exceptions.
 *
 * */















}
