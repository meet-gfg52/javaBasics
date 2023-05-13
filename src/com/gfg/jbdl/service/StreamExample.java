package com.gfg.jbdl.service;

import com.gfg.jbdl.domain.Trade;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {

    /**
     * ::
     * if the stream's output is the expected param of the calling method then no need explicitly pass it just referring will be enough
     * */

    public static void main(String[] args) {

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



        /** find the avegrage of result*/

        //Double avg=tradeList.stream().mapToDouble(Trade::getResult).average();
    }

    public static String makeItClown(Trade trade){
        return "CLOWN";
    }

}















