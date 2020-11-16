package com.entertainments.sergeyShuikov.theLamp;

import java.util.ArrayList;
import java.util.List;

public class Switcher {
    private List<ElectricityConsumer> listeners = new ArrayList<>();

    protected void addElectricityListener(ElectricityConsumer listener) {
        listeners.add(listener);
    }

    protected void removeElectricityListener(ElectricityConsumer listener) {
        listeners.remove(listener);
    }

    public void switchOn() {
        System.out.println("switch On");
        for (ElectricityConsumer electricityConsumer : listeners) {
            electricityConsumer.electricityOn();
        }
//        if (consumer != null) {
//            consumer.electricityOn();
//        }
    }
}
