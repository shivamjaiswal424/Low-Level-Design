package com.example.UberLLD.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver {

    private final String id;
    private final String name;

    private Location location;
    private DriverStatus status;

    public Driver(
            String id,
            String name,
            Location location
    ) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.status = DriverStatus.AVAILABLE;
    }

    public void updateLocation(Location location) {
        this.location = location;
    }

}