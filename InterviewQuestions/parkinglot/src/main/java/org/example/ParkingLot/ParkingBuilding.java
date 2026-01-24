package org.example.ParkingLot;

import org.example.Entity.ParkingSpot;
import org.example.Entity.Ticket;
import org.example.Entity.Vehicle;
import org.example.Pricing.CostComputation;

import java.util.List;

public class ParkingBuilding {
    private final List<ParkingLevel>  parkingLevels;

    public ParkingBuilding(List<ParkingLevel> parkingLevels, CostComputation costComputation) {
        this.parkingLevels = parkingLevels;

    }
    Ticket allocate(Vehicle vehicle) {
        for (ParkingLevel parkingLevel : parkingLevels) {
            if(parkingLevel.hasAvailable(vehicle.getVehicleType())){
                ParkingSpot spot=parkingLevel.park(vehicle.getVehicleType());
                if(spot != null){
                    Ticket ticket=new Ticket(vehicle,parkingLevel,spot);
                    System.out.println("Parking allocated at level: " +  parkingLevel.getLevelNumber()+ " spot "+spot.getSpotId());
                    return ticket;
                }
            }
        }
        throw new RuntimeException("Parking full");
    }
    void release(Ticket ticket) {
        ticket.getParkingLevel().unpark(ticket.getVehicle().getVehicleType(),ticket.getParkingSpot());
    }
}
