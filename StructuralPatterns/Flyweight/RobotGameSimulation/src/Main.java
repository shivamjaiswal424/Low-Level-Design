public class Main {
    public static void main(String[] args) {
        System.out.println("====== Flyweight Design Pattern ======");


        IRobot humanoidRobot1 = RobotFactory.createRobot("HUMANOID");
        humanoidRobot1.display(1, 2);
        IRobot humanoidRobot2 = RobotFactory.createRobot("HUMANOID");
        humanoidRobot2.display(10, 30);
        // Create 2 Robotic Dog robots and provide display
        IRobot roboDog1 = RobotFactory.createRobot("ROBOTIC_DOG");
        roboDog1.display(2, 9);
        IRobot roboDog2 = RobotFactory.createRobot("ROBOTIC_DOG");
        roboDog2.display(11, 19);
        // Total robots created: 2 - because we are reusing the same object
        System.out.println("Total robots created: " + RobotFactory.getTotalRobots());
    }
}