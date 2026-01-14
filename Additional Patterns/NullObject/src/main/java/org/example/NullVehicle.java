package org.example;

public class NullVehicle extends Vehicle {
    private String model;
    private String color;
    private int seatCapacity;
    private int fuelCapacity;
    private boolean isAvailableForTestDrive;

    public NullVehicle() {
        this.model = "Default";
        this.color = "Default";
        this.fuelCapacity = 0;
        this.isAvailableForTestDrive = false;
        this.seatCapacity = 0;
    }
    @Override
    public void start() {
        System.out.println("\n[-] NullVehicle starting");
    }

    @Override
    public void stop() {
        System.out.println("\n[-] NullVehicle stopping");
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
