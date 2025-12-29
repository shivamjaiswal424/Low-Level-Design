package org.example.context;

import org.example.strategy.DriveStrategy;

public class HybridVehicle extends Vehicle{
    public HybridVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
