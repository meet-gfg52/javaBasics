package com.gfg.jbdl.domain;

public interface Bike {

    public void moveForward();

    public void startEngine();
    public void brake();
    public void stopEngine();
    default  void recharge(){
        // plug in charger;
    }
}
