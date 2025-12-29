package org.example.context;

import org.example.strategy.DriveStrategy;

public class OffRoadVehicle extends Vehicle{
    public OffRoadVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
