package com.gfg.jbdl.service;

import com.gfg.jbdl.domain.Trade;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    /**
     * ::
     * if the stream's output is the expected param of the calling method then no need explicitly pass it just referring will be enough
     * */

    volatile  int a=0;

      AtomicInteger atomicA=new AtomicInteger(0);


    /***
     *  a = a+1
     *  a=1
     *
     *  a =  a+1
     *  a=2 in single thread
     *  --> T1 a (which belongs to thread) = a(thread)+1
     *  a=1
     *
     *
     * */

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TradesDAO tradesDAO=new TradesDAO();

        List<Trade> tradeList=tradesDAO.getLastYearTrades();


        /*  for(Trade trade:tradeList){
            if(trade.getSymbol().equals("TCS"))
                System.out.println(trade);
        }*/

        /// filter example

        tradeList.stream().filter(trade -> trade.getSymbol().equals("TCS")).forEach(trade -> {
            System.out.println(trade);});

        tradeList.stream().filter(trade -> trade.getSymbol().equals("TCS")).forEach(System.out::println);

        tradeList.stream().filter(trade -> trade.getSymbol().equals("TCS")).forEach(trade -> {
            System.out.println(trade.getSymbol());});

        //map function

        System.out.println("map example ");

        /*for(Trade trade:tradeList){
            if(trade.getSymbol().equals("TCS"))
                System.out.println(trade.getSymbol());
        }*/

        tradeList.stream().filter(trade -> trade.getSymbol().equals("TCS")).map(trade -> StreamExample.makeItClown(trade)).forEach(System.out::println);

        /** Collectors example */

       List<Trade> profitTrades= tradeList.stream().filter(trade -> trade.getResult() > 0).collect(Collectors.toList());

        Set<Trade> uniqueProfitTrades= tradeList.stream().filter(trade -> trade.getResult() > 0).collect(Collectors.toSet());

        System.out.println(profitTrades.size());
        System.out.println(uniqueProfitTrades.size());

       /*
       Map to stream
       Map<String,List<Trade>> tradeMap=new HashMap<>();
        for(Trade trade:tradeList){
            List<Trade> symTrades=tradeMap.getOrDefault(trade.getSymbol(),new ArrayList<>());
            symTrades.add(trade);
            tradeMap.put(trade.getSymbol(),symTrades);
        }
        System.out.println(tradeMap);*/

        Map<String,List<Trade>> tradeMap=tradeList.stream().collect(Collectors.groupingBy(Trade::getSymbol));
        System.out.println(tradeMap);

        List<Double> result=tradeList.stream().map(Trade::getResult).sorted().collect(Collectors.toList());

        System.out.println(result);



        /**
         * count the result -> total profit+(-total loss)*/

        Double finalResult=tradeList.stream().map(Trade::getResult).reduce(100000.0, (t1,t2) -> t1+t2);

        System.out.println("final Result"+finalResult);

        /**Optional intro in java 1.8
         * it is a wrapper over the entity*/

        /**
         * Calling a method with optional
         *  Optional<String> testOptional=Optional.of(makeItClown(t2));
         * */

        Optional<Trade> tradeOptional=tradeList.stream().filter(trade -> trade.getResult() == 0.0).findFirst();


        Trade t2=tradeOptional.orElse(new Trade());

        Trade t3=tradeOptional.orElseGet(() -> newTrade());



        if(tradeOptional.isPresent()){
            //do something
            System.out.println("here in optional");
            System.out.println(tradeOptional.get());
        }else{
            System.out.println("here in optional empty or not found");
        }



        /** find the avegrage of result*/

        //Double avg=tradeList.stream().mapToDouble(Trade::getResult).average();


        /**Parallel stream*/

        List<Double> resultParallel=tradeList.parallelStream().map(Trade::getResult).sorted().collect(Collectors.toList());

        Stream<Trade> abc=tradeList.stream();
        Stream<Trade> pqr=tradeList.parallelStream();

        List<Integer> intList= IntStream.rangeClosed(0,5).boxed().collect(Collectors.toList());
        Long start=System.currentTimeMillis();

        //intList.parallelStream().map(integer -> justWait(integer)).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println(tradeList.stream().map(Trade::getResult).reduce(0.0, (t1,t6) -> t1+t6));


        ForkJoinPool forkJoinPool=new ForkJoinPool(10);
        forkJoinPool.submit(() ->{
          //  intList.parallelStream().map(integer -> justWait(integer)).collect(Collectors.toList()).forEach(System.out::println);
            System.out.println(tradeList.parallelStream().map(Trade::getResult).reduce(0.0, (t1,t6) -> t1+t6));
        }).get();
        Long end=System.currentTimeMillis();
        System.out.println("the time taken:"+(end-start));

        /**
         * type of opeartion on chunks
         * 1.pure -> pure it is multi in and multi out. operations are isolated
         *
         * 2. impure -> impure is multi in and single out. operations are not isolated
         *
         *
         * Ways to resolve race conditions
         * 1. make the block of modifying code as synronized.
         * 2. mark the member as volatile
         * 3. use atomic data type
         *  volatile  int a=0;
         *
         *  static  AtomicInteger atomicA=new AtomicInteger(0);
         * */


    }

    public static String makeItClown(Trade trade){
       if(trade.getResult() >0.0)
        return "CLOWN";
       return  null;
    }

    public static Trade newTrade(){
        // logic of finding the trade from somewhere else
        return new Trade();
    }

    public static Integer justWait(Integer i){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i+1;

    }

    /***
     *
     * Marker interface
     *
     * Serialization - to store the object state of into a file/memory
     *
     * */
}















