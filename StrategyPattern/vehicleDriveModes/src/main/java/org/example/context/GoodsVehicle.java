package org.example.context;

import org.example.strategy.DriveStrategy;

public class GoodsVehicle extends Vehicle{
    public GoodsVehicle(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}
