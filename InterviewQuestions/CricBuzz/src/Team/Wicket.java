package Team;

import Innings.Ball;
import Innings.Over;

public class Wicket {
    public WicketType type;
    public Player takenBy;
    public Over over;
    public Ball ball;

    public Wicket(WicketType type, Player takenBy, Over over, Ball ball) {
        this.type = type;
        this.takenBy = takenBy;
        this.over = over;
        this.ball = ball;
    }

    public WicketType getType() {
        return type;
    }

    public void setType(WicketType type) {
        this.type = type;
    }

    public Player getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(Player takenBy) {
        this.takenBy = takenBy;
    }

    public Over getOver() {
        return over;
    }

    public void setOver(Over over) {
        this.over = over;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}
