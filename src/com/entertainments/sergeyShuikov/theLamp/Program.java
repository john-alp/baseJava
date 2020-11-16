package com.entertainments.sergeyShuikov.theLamp;

public class Program {
    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();

        // event subscribe  подписка на событие
        switcher.addElectricityListener(new Cooker());
        switcher.addElectricityListener(lamp);

        switcher.addElectricityListener(() -> System.out.println("Fire! "));
        // анонимный класс
//        switcher.addElectricityListener(new  ElectricityConsumer() {
//            @Override
//            public void electricityOn() {
//                System.out.println("Fire!");
//            }
//        });


        switcher.switchOn();
    }
}
