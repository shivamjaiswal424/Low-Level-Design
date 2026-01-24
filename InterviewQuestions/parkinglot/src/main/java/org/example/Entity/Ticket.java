package org.example.Entity;

import org.example.ParkingLot.ParkingLevel;

import java.time.LocalDateTime;

public class Ticket {
    private Vehicle vehicle;
    private ParkingLevel parkingLevel;
    private ParkingSpot parkingSpot;
    private LocalDateTime localDateTime;

    public Ticket(Vehicle vehicle, ParkingLevel parkingLevel, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingLevel = parkingLevel;
        this.parkingSpot = parkingSpot;
        this.localDateTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }

    public void setParkingLevel(ParkingLevel parkingLevel) {
        this.parkingLevel = parkingLevel;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
