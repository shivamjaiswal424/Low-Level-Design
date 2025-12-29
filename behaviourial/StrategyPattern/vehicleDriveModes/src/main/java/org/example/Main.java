package org.example;

import org.example.context.GoodsVehicle;
import org.example.context.HybridVehicle;
import org.example.context.SportsVehicle;
import org.example.context.Vehicle;
import org.example.strategy.EVDrive;
import org.example.strategy.NormalDrive;
import org.example.strategy.SportsDrive;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("###### Strategy Design Pattern ######");
        System.out.println("###### Example: Vehicle Drive Modes ######");

        Vehicle vehicle=new SportsVehicle(new SportsDrive());
        vehicle.drive();
        vehicle=new GoodsVehicle(new NormalDrive());
        vehicle.drive();

        vehicle=new HybridVehicle(new EVDrive());
        vehicle.drive();

        vehicle=new GoodsVehicle(new NormalDrive());
        vehicle.drive();
    }
}