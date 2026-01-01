package org.example;

import org.example.enums.DoorState;

public class Door {
    private DoorState doorState;

    Door(){
        this.doorState=DoorState.DOOR_CLOSE;
    }
    public void openDoor(int id){
        this.doorState=DoorState.DOOR_OPEN;
        System.out.println("Opening the Elevator door of elevator: " + id);
    }
    public void closeDoor(int id){
        this.doorState=DoorState.DOOR_CLOSE;
        System.out.println("Closing the Elevator door of elevator: " + id);
    }
}
