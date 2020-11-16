package com.entertainments.sergeyShuikov.theLamp;

public class Lamp implements ElectricityConsumer {
    public void lightOn() {
        System.out.println("the lamp came on, sir! ");
    }
    public void electricityOn() {
        lightOn();
    }
}
