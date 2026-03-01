public class TurnOnCommand implements ICommand{

    public final AirConditioner airConditioner;
    public boolean previousState;

    public TurnOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        previousState=airConditioner.isOn();
        airConditioner.turnOn();
    }

    @Override
    public void undo() {
        System.out.println("Undo: Turn On Command");
        if(!previousState){
            airConditioner.turnOff();
        }
    }
}
