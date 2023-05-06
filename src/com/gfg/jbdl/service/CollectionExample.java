package com.gfg.jbdl.service;

public class CollectionExample {
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
 *
 *  */



























