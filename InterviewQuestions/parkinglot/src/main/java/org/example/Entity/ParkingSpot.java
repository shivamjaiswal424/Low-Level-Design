package org.example.Entity;

public class ParkingSpot {
    private String spotId;
    private boolean isFree;

    public  ParkingSpot(String spotId) {
        this.spotId = spotId;
        isFree = true;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
