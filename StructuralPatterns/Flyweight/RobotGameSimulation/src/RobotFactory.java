import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
    private static  final Map<String,IRobot> roboticObjectCache = new HashMap<>();

    public static IRobot createRobot(String robotType){
        if(roboticObjectCache.containsKey(robotType)){
            return roboticObjectCache.get(robotType);
        }
        else{
            if(robotType.equals("HUMANOID")){
                Sprites humanoidSprite=new Sprites();
                IRobot humanoidObject=new HumanoidRobot(robotType,humanoidSprite);
                roboticObjectCache.put(robotType,humanoidObject);
                return humanoidObject;
            }
            else if(robotType.equals("ROBOTIC_DOG")){
                Sprites roboticDogSprite=new Sprites();
                IRobot roboticDogObject=new RoboticDog(robotType,roboticDogSprite);
                roboticObjectCache.put(robotType,roboticDogObject);
                return roboticDogObject;

            }
        }
        throw new IllegalArgumentException("Invalid robot type: " + robotType);
    }

    public static int getTotalRobots() {
        return roboticObjectCache.size();
    }
}
