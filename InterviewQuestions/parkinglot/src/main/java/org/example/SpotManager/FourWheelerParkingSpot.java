package org.example.SpotManager;

import org.example.Entity.ParkingSpot;
import org.example.LookUpStrategy.ParkingSpotLookUpStrategy;

import java.util.List;

public class FourWheelerParkingSpot extends ParkingSpotManager{
    public FourWheelerParkingSpot(List<ParkingSpot> parkingSpots, ParkingSpotLookUpStrategy parkingSpotLookUpStrategy) {
        super(parkingSpots, parkingSpotLookUpStrategy);
    }
}
