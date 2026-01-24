package org.example.ParkingLot;

import org.example.Entity.Ticket;
import org.example.Entity.Vehicle;

public class EntranceGate {
    public Ticket enter(ParkingBuilding parkingBuilding, Vehicle vehicle) {
        return parkingBuilding.allocate(vehicle);
    }
}
