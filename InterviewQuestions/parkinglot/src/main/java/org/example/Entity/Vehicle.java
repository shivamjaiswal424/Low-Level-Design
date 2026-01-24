package org.example.Entity;

import org.example.VehicleType;

public class Vehicle {
    private String VehicleNumber;
    private VehicleType VehicleType;
    public Vehicle(String VehicleNumber, VehicleType VehicleType) {
        this.VehicleNumber = VehicleNumber;
        this.VehicleType = VehicleType;
    }
    public String getVehicleNumber() {
        return VehicleNumber;
    }
    public void setVehicleNumber(String VehicleNumber) {
        this.VehicleNumber = VehicleNumber;
    }
    public VehicleType getVehicleType() {
        return VehicleType;
    }
    public void setVehicleType(VehicleType VehicleType) {
        this.VehicleType = VehicleType;
    }
}
