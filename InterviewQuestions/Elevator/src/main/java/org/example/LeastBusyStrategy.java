package org.example;

import org.example.enums.ElevatorDirection;

import java.util.List;

public class LeastBusyStrategy implements ElevatorSelectionStrategy{
    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers, int requestFloor, ElevatorDirection elevatorDirection) {
        ElevatorController best=null;
        int minLoad=Integer.MAX_VALUE;
        for(ElevatorController elevatorController: controllers){
            int load=elevatorController.downMaxPQ.size()+elevatorController.upMinPQ.size();
            if(load<minLoad){
                minLoad=load;
                best=elevatorController;
            }
        }
        return best;
    }
}
