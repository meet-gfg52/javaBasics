package com.gfg.jbdl.service;

import com.gfg.jbdl.domain.Person;

import java.io.*;
import java.sql.SQLException;

public class ExceptionExample {

    /**
     * Error -> App cannot recover
     * Exception -> App can continue after handling the exceptions
     *
     * 2 types of exceptions
     * 1/ Compile time -- Checked exceptions
     * 2/ Run time  -- unchecked exceptions
     *
     *
     * 1. Try- catch  -> try block runs the code which may occur into exception. And catch will handle if exception occurs
     * 2. Finally keyword -> finally will be executed irrespective of both try or catch.
     * 3. Throw -> To throw a exception
     * 4. Throws -> a warning that the method can throw or result into exception.
     * */

    public static void main(String[] args) {


            try {
              //create DB connection
                // Run a query
                return;
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                //db.close();
            }
            System.out.println("hello");


    }


    public static int divide(int a, int b){
        return a/b;
    }
}




/**
 *
 * Cart Services
 *
 *      makePayment()
 *
 * Payment service
 * makePayment(cardNumber) throws InValidCardNumberException(Exception), PaymentUnsuccessfulException(Exception){
 * try{
 *     intiate the payment service
 *     if(card number <16 )
 *      throw invalidCardNumberException();
 *     if(payment success)
 *      return positive;
 *      if(incorrect pin || retryPossible)
 *      retry payments
 *      else
 *          throw PaymentUnsuccessfulException;
 *      if(paymentDeclined)
 *          throw PaymentUnsuccessfulException;
 *
 *
 * }catch(IncorretPinException){
 *     makePayment(cardNumber);
 * }
 *
 * */























