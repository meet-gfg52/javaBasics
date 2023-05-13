package com.gfg.jbdl.service;

import com.gfg.jbdl.domain.*;

import java.sql.SQLOutput;
import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {

        TradesDAO tradesDAO=new TradesDAO();
        List<Trade> tradeList=tradesDAO.getLastYearTrades();

        for(Trade trade:tradeList){
            if(trade.getSymbol().equals("TCS"))
                System.out.println(trade);
        }


        System.out.println(tradeList.get(12).hashCode());
        System.out.println(tradeList.get(13).hashCode());

        Set<Trade> uniqueTrades=new HashSet<>(tradeList);

        System.out.println("set Size"+uniqueTrades.size());



        /**
         * <Symbol,List<Trade>
         * */

     /*

     Map<String,List<Trade>> tradeMap=new HashMap<>();
        for(Trade trade:tradeList){
            List<Trade> symTrades=null;
            if(tradeMap.containsKey(trade.getSymbol())){
                symTrades=tradeMap.get(trade.getSymbol());
            }
            else{
                 symTrades=new ArrayList<>();
            }
            symTrades.add(trade);
            tradeMap.put(trade.getSymbol(),symTrades);
        }
        System.out.println(tradeMap);
*/

        Map<String,List<Trade>> tradeMap=new HashMap<>();
        for(Trade trade:tradeList){
            List<Trade> symTrades=tradeMap.getOrDefault(trade.getSymbol(),new ArrayList<>());
            symTrades.add(trade);
            tradeMap.put(trade.getSymbol(),symTrades);
        }
        System.out.println(tradeMap);




        /**
         * Functional interface
         * 1. Consumer -> accepts input  process it and no return -> analytics input
         * 2. Supplier -> Accepts nothing and return the data ->   content feed (instagram)
         * 3. Predicate -> Accepts , process and return -> processing in live streams (gaming)
         *
         * */




 /*



        List<Number> myList=new ArrayList<>();
        myList.add(1);
        myList.add(10.0);

        *//**
        * Super & extends
         *
         * Super -> is for adding into the collection
         *
         * extends -> is for reading into the collection;
        * *//*

        List<ACar> mySecondList=new ArrayList<ACar>();
        List<ACar> myList3=new ArrayList<>();
        //List<ACar> myList4 = new ArrayList<Car>(); // parent to child assignment
        List<Car> myList5 = new ArrayList<Car>();
        *//**
         * Error in the below line because it should let u insert Bcar but ArrayList cannot store Bcar as it is assigned with Acar;
         List<Car> myList6 = new ArrayList<ACar>();
        myList6.add(new BCar());
        System.out.println(myList6.get(0)); // car
        System.out.println(myList6.get(1)); //car

         *//*


        List<? super Car> genList=new ArrayList<Car>();

        genList.add(new ACar());
        genList.add(new BCar());
        genList.add(new APlusCar());

        List<? extends APlusCar> genList2=new ArrayList<>();

        Car c1=genList2.get(0);
        ACar a1=genList2.get(0);
       // BCar b2=genList2.get(0); --> error because cannot aCar cannot be assigned;
        APlusCar ap2=genList2.get(0);


        List<? extends ACar> genList3=new ArrayList<APlusCar>();

        Car c3=genList2.get(0);
        ACar a3=genList2.get(0);
        // BCar b2=genList2.get(0); --> error because cannot aCar cannot be assigned;
      // APlusCar ap3=genList2.get(0); --> error because parent child assignment

*/

    }

}




/**
 * Collection in java to hold the group of objects which are of same type (or same parent)generics.
 * Example: Employee
 *
 *      Collection of Employee which has n number of employees accessible within one referecnce
 *
 *      with multiple references;
 *      Emp e1=new Emp();
 *      Emp e2=new EMp();
 *      ..
 *      10 emps;
 *
 *      --OR--
 *      use collection and access it via single reference
 *
 *      List of employees -> e1,e2,e3,e4
 *
 *      employeeList.get(3);
 *
 *
 *
 *      1. List -> ArrayList LinkedList
 *      2. Map  -> Types of Map (HashMap, hashTable, ConcurrentHashMap)
 *      3. Set  -> HashSet, TreeSet
 *
 *
 *      -> List -> ArrayList
 *       PROS
 *          Search is faster by random access facality
 *          memory efficient
 *      CONS
 *          Resize
 *          slow deletes
 *
 *      -> List -> LinkedList
 *
 *         Pros:
 *          Insertion & deletion are faster
 *
 *         Cons:
 *          Search is slower
 *          memory inefficient
 *
 *
 *  1. get the data from DB and print everything -> LinkedList( store once iterate/ search none)
 *  2. get the name of students based their ranks -> ArrayList (Store once iterate/search n times)
 *  3. get the list of employees from DB and filter the ones whose dept is ADMIN -> LinkedList
 *      a. store all the objets in memory  - LinkedList
 *      b. Iterate over all objects and find the one with ADMINS
 *
 *      Map -> a collection which holds the data in key value pairs
 *
 *      e1 -> john,TECH
 *      e2 -> jenny, ADMIN
 *      e3 -> ashok, TECH
 *      e4 -> jose, ADMIN
 *     for admin  result is e2 and e4 (one time list iteration)
 *     for tech   result is e1 and e3 (,,)
 *
 *     in single iteration form this data collection -> 1
 *     admin -> [e2,e4] -> 0
 *     tech -> [e1,e3] -> 0
 *     admin -> [e4]
 *
 *     <Key,Value> collection
 *      key -> always unique (can be null in few cases)
 *      value -> null or anything and duplicate values are permitted
 *
 *      hashing -> which will help in maps to maintain unique keys
 *
 *
 *
 *
 *  */



























