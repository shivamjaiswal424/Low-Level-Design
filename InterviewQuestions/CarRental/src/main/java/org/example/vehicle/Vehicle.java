package org.example.vehicle;

public class Vehicle {
    private final int vehicleId;
    private final String vehicleNumber;
    private final VehicleType vehicleType;
    private double dailyRentalCost;
    private volatile VehicleStatus vehicleStatus;

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getDailyRentalCost() {
        return dailyRentalCost;
    }

    public void setDailyRentalCost(double dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public Vehicle(int vehicleId, String vehicleNumber, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }
}
