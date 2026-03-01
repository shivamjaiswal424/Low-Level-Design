public class TurnOffCommand implements ICommand{
    public final AirConditioner airConditioner;
    public boolean previousState;
    public TurnOffCommand(AirConditioner airConditioner){
        this.airConditioner = airConditioner;
    }
    @Override
    public void execute() {
        previousState = airConditioner.isOn();
        airConditioner.turnOff();
    }

    @Override
    public void undo() {
        System.out.println("Undo: Turn off command");
    }
}
