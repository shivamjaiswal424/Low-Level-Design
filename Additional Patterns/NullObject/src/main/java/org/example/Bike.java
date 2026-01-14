package org.example;

public class Bike extends Vehicle{
    private String model;
    private String color;
    private int seatCapacity;
    private int fuelCapacity;
    private boolean isAvailableForTestDrive;

    public Bike(String model, String color, int fuelCapacity) {
        this.model = model;
        this.color = color;
        this.fuelCapacity = fuelCapacity;
        this.isAvailableForTestDrive = false;
        this.seatCapacity = 2;
    }

    @Override
    public void start() {
        System.out.println("Bike is starting");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping");
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
