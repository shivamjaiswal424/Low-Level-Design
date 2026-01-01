package org.example;

public class InternalButton {
    public final ElevatorController controller;
    public InternalButton(ElevatorController elevatorController){
        this.controller=elevatorController;
    }
    public void pressButton(int destinationFloor){
        InternalDispatcher.getInstance().submitInternalRequest(destinationFloor,controller);
    }
}
