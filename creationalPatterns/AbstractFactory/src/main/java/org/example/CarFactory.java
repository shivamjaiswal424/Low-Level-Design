package org.example;

public interface CarFactory {

    CarInterior createCarInterior() ;
    CarExterior createCarExterior() ;

    default void productCompleteVehicle(){
        System.out.println("Starting complete vehicle production...");
        CarInterior interior = createCarInterior() ;
        CarExterior exterior = createCarExterior() ;
        interior.addInteriorComponents() ;
        exterior.addExteriorComponents();

        System.out.println("Vehicle production completed!");
    }
}
