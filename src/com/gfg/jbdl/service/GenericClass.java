package com.gfg.jbdl.service;

import com.gfg.jbdl.domain.Person;

public class GenericClass {

    static class MyClass<A>{
        A a;
        A b;
    }

    public static void main(String[] args) {

        MyClass<String> myclass=new MyClass();
        myclass.a="HI";
//        myclass.a=10;
//        myclass.b=new Person();

        String  a=myclass.a;


        MyClass<Person> myPersonClass=new MyClass();

        myPersonClass.a=new Person();

        //int b=myPersonClass.a; -> it is wrong because compiler will force to convert it int to person;
    }

}
