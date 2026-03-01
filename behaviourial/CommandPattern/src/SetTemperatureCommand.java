public class SetTemperatureCommand implements ICommand {
    private final AirConditioner airConditioner;
    private final int newTemperature;
    private int previousTemperature;

    public SetTemperatureCommand(AirConditioner airConditioner, int newTemperature) {
        this.airConditioner = airConditioner;
        this.newTemperature = newTemperature;
    }


    @Override
    public void execute() {
        previousTemperature = airConditioner.getTemperature();
        airConditioner.setTemperature(newTemperature);
    }

    @Override
    public void undo() {
        System.out.println("Undo: Set Temperature command");
        airConditioner.setTemperature(previousTemperature);
    }
}
