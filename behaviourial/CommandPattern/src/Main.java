public class Main {
    public static void main(String[] args) {
        System.out.println("### Command Pattern: Solution Demo ###");
        AirConditioner airConditioner = new AirConditioner();

        RemoteController remoteObj = new RemoteController();
        remoteObj.setCommand(new TurnOnCommand(airConditioner));
        remoteObj.pressButton();
        remoteObj.setCommand(new SetTemperatureCommand(airConditioner,25));

        remoteObj.pressButton();
        remoteObj.setCommand(new SetTemperatureCommand(airConditioner,18));
        remoteObj.pressButton();
        remoteObj.setCommand(new TurnOffCommand(airConditioner));
        remoteObj.pressButton();

        remoteObj.undo(); // Undo: Turn Off command => AC is now on
        // Undo Command
        remoteObj.undo(); // Undo: Set Temperature Command. AC temperature is now 25°C
        // Undo Command
        remoteObj.undo(); // Undo: Set Temperature Command. AC temperature is now 0°C
        // Undo Command
        remoteObj.undo();
    }
}