package Team;

import java.util.*;

public class PlayerBowlingController {
    Deque<Player> bowlersList;
    Map<Player, Integer> bowlerVsOverCount;
    Player currentBowler;

    public PlayerBowlingController(List<Player> bowlersList) {
        setBowlerList(bowlersList);

    }
    public void setBowlerList(List<Player> bowlersList){
        this.bowlersList = new LinkedList<>();

        this.bowlerVsOverCount = new HashMap<>();
        for(Player bowler : bowlersList){
            this.bowlersList.addLast(bowler);
            bowlerVsOverCount.put(bowler,0);
        }
    }
    public void getNextBowler(int maxOverCountPerBowler){
        Player bowler = bowlersList.poll();
        if(bowlerVsOverCount.get(bowler)+1 == maxOverCountPerBowler){
            currentBowler = bowler;
        }
        else{
            currentBowler = bowler;
            bowlersList.addLast(currentBowler);
            bowlerVsOverCount.put(currentBowler,bowlerVsOverCount.get(currentBowler)+1);
        }
    }
    public Player getCurrentBowler() {
        return currentBowler;
    }
}
