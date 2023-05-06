package com.gfg.jbdl.domain;

public interface Car {

    //1990 -2020
    /**
     * Inheritance
     * Compulsion and no clear definations
     * */

   public void moveForward();
    public void moveBackward();
    public void startEngine();
    public void brake();
    public void stopEngine();
    default  void recharge(){
        // plug in charger;
    }
    default void CNG(){
        // fill gas;
    }

    /**
     * when new method is added in interface, which is already implemented by 100s of classes
     * 1. Create one more interface with extra method and from now one use that interface
     * 2. Create one more interface that has only recharge method and implement both the interface in EV cars
     * 3. With java 8+ "default" keyword added for methods having definations in interface
     * */

}
