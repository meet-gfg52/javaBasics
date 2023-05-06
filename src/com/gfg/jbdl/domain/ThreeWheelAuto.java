package com.gfg.jbdl.domain;

public class ThreeWheelAuto implements Car,Bike{
    @Override
    public void moveForward() {

    }

    @Override
    public void moveBackward() {

    }

    @Override
    public void startEngine() {

    }

    @Override
    public void brake() {

    }

    @Override
    public void stopEngine() {

    }

    @Override
    public void recharge() {
        Car.super.recharge();
    }

    @Override
    public void CNG() {
        Car.super.CNG();
    }
}
