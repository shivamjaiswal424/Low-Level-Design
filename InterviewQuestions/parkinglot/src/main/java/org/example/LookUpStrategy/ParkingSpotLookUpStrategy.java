package org.example.LookUpStrategy;

import org.example.Entity.ParkingSpot;

import java.util.List;

public interface ParkingSpotLookUpStrategy {
    ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpot);
}
