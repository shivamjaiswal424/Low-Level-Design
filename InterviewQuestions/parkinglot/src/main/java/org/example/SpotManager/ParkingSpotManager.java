package org.example.SpotManager;

import org.example.Entity.ParkingSpot;
import org.example.LookUpStrategy.ParkingSpotLookUpStrategy;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingSpotManager {
    protected final List<ParkingSpot> parkingSpots;
    protected final ParkingSpotLookUpStrategy parkingSpotLookUpStrategy;
    private final ReentrantLock lock = new ReentrantLock();
    public ParkingSpotManager(List<ParkingSpot> parkingSpots,ParkingSpotLookUpStrategy parkingSpotLookUpStrategy) {
        this.parkingSpotLookUpStrategy = parkingSpotLookUpStrategy;
        this.parkingSpots = parkingSpots;

    }

    public ParkingSpot park(){
        lock.lock();
        try{
            ParkingSpot spot=parkingSpotLookUpStrategy.selectParkingSpot(parkingSpots);
            if(spot==null){
                return null;

            }
            spot.setFree(false);
            return spot;
        }
        finally{
            lock.unlock();
        }
    }
    public void unpark(ParkingSpot spot){
        lock.lock();
        try{
            spot.setFree(true);
        }
        finally{
            lock.unlock();
        }
    }
    public boolean hasFreeSpot(){
        lock.lock();
        try{
            for(ParkingSpot spot : parkingSpots){
                if(spot.isFree()){
                    return true;
                }
            }
            return false;
        }
        finally{
            lock.unlock();
        }

    }

}
