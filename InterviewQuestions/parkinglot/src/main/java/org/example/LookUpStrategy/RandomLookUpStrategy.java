package org.example.LookUpStrategy;

import org.example.Entity.ParkingSpot;

import java.util.List;

public class RandomLookUpStrategy implements ParkingSpotLookUpStrategy {



    @Override
    public ParkingSpot selectParkingSpot(List<ParkingSpot> parkingSpot) {
        for(ParkingSpot spot : parkingSpot){
            if(spot.isFree()){
                return spot;
            }
        }
        return null;
    }
}
