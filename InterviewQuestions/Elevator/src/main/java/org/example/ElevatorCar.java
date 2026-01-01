package org.example;

import org.example.enums.ElevatorDirection;

public class ElevatorCar {
    int id;
    int currentfloor;
    ElevatorDirection elevatorDirection;
    Door door;
    int nextFloorStoppage;

    public ElevatorCar(int id){
        this.id=id;
        currentfloor=0;
        elevatorDirection=ElevatorDirection.IDLE;
        door=new Door();
    }
    public void showDisplay(){
        System.out.println("elevator: " + id +" Current floor: " + currentfloor+ " going: " + elevatorDirection);
    }
    public void setCurrentfloor(int currentfloor){
        this.currentfloor=currentfloor;
    }
    public void moveElevator(int destinationFloor){
        this.nextFloorStoppage=destinationFloor;
        if(currentfloor==nextFloorStoppage){
            door.openDoor(id);
            return;
        }
        int startFloor=this.currentfloor;
        door.closeDoor(id);
        if(nextFloorStoppage>=currentfloor){
            elevatorDirection=ElevatorDirection.UP;
            showDisplay();
            for(int i=startFloor+1;i<=nextFloorStoppage;i++){
                try{
                    Thread.sleep(5);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                setCurrentfloor(i);
                showDisplay();
            }
        }
        else{
            elevatorDirection=ElevatorDirection.DOWN;
            showDisplay();
            for(int i=startFloor-1;i>=nextFloorStoppage;i--){
                try{
                    Thread.sleep(5);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                setCurrentfloor(i);
                showDisplay();
            }

        }
        door.openDoor(id);

    }

}
