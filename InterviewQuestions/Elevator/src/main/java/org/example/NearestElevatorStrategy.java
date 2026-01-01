package org.example;

import org.example.enums.ElevatorDirection;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{

    ElevatorController best=null;
    int minDistance=Integer.MAX_VALUE;
    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers, int requestFloor, ElevatorDirection elevatorDirection) {
        for(ElevatorController controller:controllers){
            int nextFloorStoppage=controller.elevatorCar.nextFloorStoppage;
            boolean isSameDirectionCandidate=false;
            if(controller.elevatorCar.elevatorDirection==elevatorDirection){
                if((elevatorDirection==ElevatorDirection.UP && nextFloorStoppage<=requestFloor) || ( elevatorDirection==ElevatorDirection.DOWN && nextFloorStoppage>=requestFloor)){
                    isSameDirectionCandidate=true;
                }
            }
            int dist=Math.abs(nextFloorStoppage-requestFloor);
            if(isSameDirectionCandidate && dist<minDistance){
                minDistance=dist;
                best=controller;
            }
        }
        if(best==null){
            for(ElevatorController controller:controllers){
                if(controller.elevatorCar.elevatorDirection==ElevatorDirection.IDLE){
                    best=controller;
                    break;
                }
            }
        }
        if(best==null){
            best=controllers.get(0);
        }

        return best;
    }

}
