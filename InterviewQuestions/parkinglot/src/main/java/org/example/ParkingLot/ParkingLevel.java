package org.example.ParkingLot;

import org.example.Entity.ParkingSpot;
import org.example.Entity.Vehicle;
import org.example.SpotManager.ParkingSpotManager;
import org.example.VehicleType;

import java.util.Map;

public class ParkingLevel {
    private final int levelNumber;
    private final Map<VehicleType, ParkingSpotManager>managers;

    public ParkingLevel(int levelNumber,Map<VehicleType, ParkingSpotManager>managers) {
        this.levelNumber = levelNumber;
        this.managers = managers;
    }

    public boolean hasAvailable(VehicleType vehicleType){
        ParkingSpotManager parkingSpotManager=managers.get(vehicleType);
        if(parkingSpotManager==null){
            return false;
        }
        return parkingSpotManager.hasFreeSpot();
    }
    public ParkingSpot park(VehicleType vehicleType){
        ParkingSpotManager parkingSpotManager=managers.get(vehicleType);
        if (parkingSpotManager == null) {
            throw new IllegalArgumentException(
                    "No parking manager for vehicle type: " + vehicleType);
        }
        return parkingSpotManager.park();
    }
    public void unpark(VehicleType vehicleType, ParkingSpot parkingSpot){
        ParkingSpotManager parkingSpotManager=managers.get(vehicleType);
        if(parkingSpotManager!=null){
            parkingSpotManager.unpark(parkingSpot);
        }
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public Map<VehicleType, ParkingSpotManager> getManagers() {
        return managers;
    }
}
