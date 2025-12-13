package org.example.context;

import org.example.strategy.DriveStrategy;

public class SportsVehicle extends Vehicle{
    public SportsVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
