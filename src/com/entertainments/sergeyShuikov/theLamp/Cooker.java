package com.entertainments.sergeyShuikov.theLamp;

public class Cooker implements ElectricityConsumer {
    private void cookerOn() {
        System.out.println("cooker On, sir ");
    }

    @Override
    public void electricityOn() {
        cookerOn();
    }
}
