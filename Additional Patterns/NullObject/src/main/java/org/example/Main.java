package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("\n#### NULL Object Pattern Solution ####");
        Vehicle car=VehicleFactory.getVehicle("Car");
        printVehicleDetails(car);
        testDrive(car);

        Vehicle bike=VehicleFactory.getVehicle("Bike");
        printVehicleDetails(bike);
        testDrive(bike);

        Vehicle nullVehicle=VehicleFactory.getVehicle("null");
        printVehicleDetails(nullVehicle);
        testDrive(nullVehicle);

    }
    private static void printVehicleDetails(Vehicle vehicle){
        if(vehicle instanceof Car car){
            System.out.println("\n[+] Vehicle Details: ");
            System.out.println(car.getClass().getSimpleName() + "[Model=" +car.getModel() + ", Color=" +car.getColor()
                    + ", Seat Capacity=" + car.getSeatCapacity() +
                    ", Fuel Capacity=" + car.getFuelCapacity() + "]");
        }
        if(vehicle instanceof Bike bike){
            System.out.println("\n[+] Vehicle Details: ");
            System.out.println(bike.getClass().getSimpleName() + "[Model=" +bike.getModel() + ", Color=" +bike.getColor()
                    + ", Seat Capacity=" + bike.getSeatCapacity() +
                    ", Fuel Capacity=" + bike.getFuelCapacity() + "]");
        }
    }
    private static void testDrive(Vehicle vehicle){
        vehicle.start();
        vehicle.stop();
    }
}