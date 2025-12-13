package org.example.strategy;

public class NormalDrive implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Driving Capability: Normal");
    }
}
