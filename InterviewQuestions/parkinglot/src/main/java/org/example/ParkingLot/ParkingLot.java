package org.example.ParkingLot;

import org.example.Entity.Ticket;
import org.example.Entity.Vehicle;
import org.example.Payment.Payment;

public class ParkingLot {
    private ParkingBuilding parkingBuilding;
    private EntranceGate entranceGate;
    private ExitGate exitGate;
    public ParkingLot(ParkingBuilding parkingBuilding, EntranceGate entranceGate, ExitGate exitGate) {
        this.parkingBuilding = parkingBuilding;
        this.entranceGate = entranceGate;
        this.exitGate = exitGate;

    }
    public Ticket vehicleArrives(Vehicle vehicle) {
        return entranceGate.enter(parkingBuilding, vehicle);
    }
    public void vehicleExits(Ticket ticket, Payment payment) {
        exitGate.completeExit(parkingBuilding,ticket,payment);
    }

}
