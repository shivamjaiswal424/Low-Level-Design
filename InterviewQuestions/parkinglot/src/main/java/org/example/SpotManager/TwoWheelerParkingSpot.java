package org.example.SpotManager;

import org.example.Entity.ParkingSpot;
import org.example.LookUpStrategy.ParkingSpotLookUpStrategy;

import java.util.List;

public class TwoWheelerParkingSpot extends ParkingSpotManager {

    public TwoWheelerParkingSpot(List<ParkingSpot> parkingSpots, ParkingSpotLookUpStrategy parkingSpotLookUpStrategy) {
        super(parkingSpots, parkingSpotLookUpStrategy);
    }
}
