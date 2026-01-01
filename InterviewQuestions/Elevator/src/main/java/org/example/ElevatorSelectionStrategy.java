package org.example;

import org.example.enums.ElevatorDirection;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevator(List<ElevatorController> controllers, int requestFloor, ElevatorDirection elevatorDirection) ;
}
