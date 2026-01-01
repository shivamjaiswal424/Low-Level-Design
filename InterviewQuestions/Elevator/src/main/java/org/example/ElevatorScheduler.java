package org.example;

import org.example.enums.ElevatorDirection;

import java.util.List;

public class ElevatorScheduler {
    private final List<ElevatorController> controllers;
    private ElevatorSelectionStrategy elevatorSelectionStrategy;

    public ElevatorScheduler(List<ElevatorController> controllers,ElevatorSelectionStrategy elevatorSelectionStrategy){
        this.controllers=controllers;
        this.elevatorSelectionStrategy=elevatorSelectionStrategy;

    }
    public void setStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy){
        this.elevatorSelectionStrategy=elevatorSelectionStrategy;
    }

    public ElevatorController assignElevator(int floor, ElevatorDirection elevatorDirection){
        return elevatorSelectionStrategy.selectElevator(controllers,floor,elevatorDirection);
    }
}
