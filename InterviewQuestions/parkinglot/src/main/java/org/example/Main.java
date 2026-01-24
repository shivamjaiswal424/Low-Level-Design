package org.example;

import org.example.Entity.ParkingSpot;
import org.example.Entity.Ticket;
import org.example.Entity.Vehicle;
import org.example.LookUpStrategy.ParkingSpotLookUpStrategy;
import org.example.LookUpStrategy.RandomLookUpStrategy;
import org.example.ParkingLot.*;
import org.example.Payment.Cash;
import org.example.Payment.UPI;
import org.example.Pricing.CostComputation;
import org.example.Pricing.FixedPriceStrategy;
import org.example.SpotManager.FourWheelerParkingSpot;
import org.example.SpotManager.ParkingSpotManager;
import org.example.SpotManager.TwoWheelerParkingSpot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingSpotLookUpStrategy strategy=new RandomLookUpStrategy();
        Map<VehicleType, ParkingSpotManager>levelOneManager=new HashMap<>();
        levelOneManager.put(VehicleType.TwoWheeler,new TwoWheelerParkingSpot(List.of(new ParkingSpot("L1-S1"), new ParkingSpot("L1-S2")),strategy));
        levelOneManager.put(VehicleType.FourWheeler, new FourWheelerParkingSpot(List.of(new ParkingSpot("L1-S3")), strategy));
        ParkingLevel level1 = new ParkingLevel(1, levelOneManager);

        Map<VehicleType, ParkingSpotManager> levelTwoManager=new HashMap<>();
        levelTwoManager.put(VehicleType.TwoWheeler, new TwoWheelerParkingSpot(List.of(new ParkingSpot("L2-S1")), strategy));

        levelTwoManager.put(VehicleType.FourWheeler, new FourWheelerParkingSpot(List.of(new ParkingSpot("L2-S2"), new ParkingSpot("L2-S3")), strategy));


        ParkingLevel level2 = new ParkingLevel(2, levelTwoManager);

        ParkingBuilding parkingBuilding=new ParkingBuilding(List.of(level1,level2),new CostComputation(new FixedPriceStrategy()));
        ParkingLot parkingLot = new ParkingLot(parkingBuilding, new EntranceGate(),
                new ExitGate(new CostComputation(new FixedPriceStrategy()))
        );


        Vehicle bike = new Vehicle("BIKE-101", VehicleType.TwoWheeler);
        Vehicle car = new Vehicle("CAR-201", VehicleType.FourWheeler);

        Ticket t1 = parkingLot.vehicleArrives(bike);
        Ticket t2 = parkingLot.vehicleArrives(car);

        parkingLot.vehicleExits(t1, new Cash());
        parkingLot.vehicleExits(t2, new UPI());


    }
}