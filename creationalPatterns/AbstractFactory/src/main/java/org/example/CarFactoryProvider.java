package org.example;


public class CarFactoryProvider {
    public CarFactory getCarFactory(CarType carType,String brand) {
        switch (carType) {
            case ECONOMY:
                return new EconomyCarFactory(brand);
            case LUXURY:
                return new LuxuryCarFactory(brand);
            default:
                throw new IllegalArgumentException("Unknown car type: " + carType);

        }
    }
}
