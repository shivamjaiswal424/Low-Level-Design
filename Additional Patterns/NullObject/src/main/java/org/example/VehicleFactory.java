package org.example;

public class VehicleFactory {
    public  static Vehicle getVehicle(String type) {

        if(type.equalsIgnoreCase("Car")){
            return new Car("Toyota","Red",5,60,true);
        }
        else if(type.equalsIgnoreCase("Bike")){
            return new Bike("Yamaha","Black",60);
        }
        else{
            return new NullVehicle();
        }

    }
}
