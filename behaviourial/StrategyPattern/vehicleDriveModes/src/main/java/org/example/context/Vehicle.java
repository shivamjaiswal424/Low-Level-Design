package org.example.context;

import org.example.strategy.DriveStrategy;

public class Vehicle {
    public DriveStrategy driveStrategy;
    public Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy=driveStrategy;

    }
    public void drive(){
        System.out.println("\n" + this.getClass().getSimpleName() +": ");
        driveStrategy.drive();
    }
}
