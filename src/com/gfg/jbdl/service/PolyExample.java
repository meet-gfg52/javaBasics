package com.gfg.jbdl.service;

public class PolyExample {

    public static void main(String[] args) {
        System.out.println(add(5,10));
    }

    /**
     * Polymoric example
     * 1. overloading
     *  a. param type should be different
     *  b. return type does not count for overloading
     *  c. order the parameters also differs
     *  d. number of parameters
     * */

   public static double add(double a,int b){
       return a+b;
   }
    public static double add(int b,double a){
        return a+b;
    }


    public static double add(int a,int b){
             return a+b;
    }

    public static double add(int a,int b,int c){
        return a+b;
    }


    public static Double add(Double a,Double b){
        return a+b;
    }

    public static String add(String a, String b){
        return a+b;
    }
}































