package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=====Abstract Factory Design Pattern=====");
        CarFactoryProvider carFactoryProvider = new CarFactoryProvider();

        CarFactory economyCar= carFactoryProvider.getCarFactory(CarType.ECONOMY,"Honda");
        economyCar.productCompleteVehicle();
        CarFactory luxuryCar= carFactoryProvider.getCarFactory(CarType.LUXURY,"Mercedes");
        luxuryCar.productCompleteVehicle();
    }
}