import java.awt.*;

public class HumanoidRobot implements IRobot {

    private final String type;
    private final Sprites body;
    public HumanoidRobot(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Displaying" + type + " at " + x + " " + y);
    }
}
