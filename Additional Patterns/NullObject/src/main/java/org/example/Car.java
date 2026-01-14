package org.example;

public class Car extends Vehicle {
    private String model;
    private String color;
    private int seatCapacity;
    private int fuelCapacity;
    private boolean isAvailableForTestDrive;

    public Car(String model, String color,int seatCapacity, int fuelCapacity,boolean isAvailableForTestDrive) {
        this.model = model;
        this.color = color;
        this.fuelCapacity = fuelCapacity;
        this.isAvailableForTestDrive = isAvailableForTestDrive;
        this.seatCapacity = seatCapacity;
    }
    @Override
    public void start() {
        System.out.println("Starting Car");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Car");
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public boolean isAvailableForTestDrive() {
        return isAvailableForTestDrive;
    }
}
