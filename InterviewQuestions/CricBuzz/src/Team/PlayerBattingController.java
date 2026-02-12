package Team;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {
    Queue<Player> yetToPlay;
    Player striker;
    Player nonStriker;

    public PlayerBattingController(Queue<Player> playing11) {
        this.yetToPlay =new LinkedList<>();
        this.yetToPlay.addAll(playing11);
    }

    public Exception getNextPlayer() {
        if (yetToPlay.isEmpty()) {
            return new Exception();
        }
        if(striker == null) {
            striker=yetToPlay.poll();

        }
        if(nonStriker == null) {
            nonStriker=yetToPlay.poll();
        }
        return null;
    }

    public Player getStriker() {
        return striker;
    }

    public void setStriker(Player striker) {
        this.striker = striker;
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(Player nonStriker) {
        this.nonStriker = nonStriker;
    }

}
