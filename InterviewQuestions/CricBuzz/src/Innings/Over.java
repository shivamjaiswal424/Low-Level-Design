package Innings;

import Team.Player;
import Team.Team;

import java.util.ArrayList;
import java.util.List;

public class Over {
    int overNumber;
    List<Ball> balls;
    int extraBallsCount;
    Player bowledBy;

    public Over(int overNumber,Player bowledBy) {
        this.overNumber = overNumber;
        this.balls =new ArrayList<>();
        this.bowledBy = bowledBy;
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin){
        int ballCount=1;
        while(ballCount<=6){
            Ball ball=new Ball(ballCount);
            ball.startBallDelivery(battingTeam,bowlingTeam,this);
            if(ball.getBallType()==BallType.NORMAL){
                balls.add(ball);
                ballCount++;
                if(ball.getWicket()!=null){
                    battingTeam.chooseNextBatsman();
                }
                if(runsToWin!=-1 &&  battingTeam.getTotalRuns()>=runsToWin){
                    battingTeam.isWinner=true;
                    return true;
                }
            }
            else{
                extraBallsCount++;
            }
        }
        return false;
    }
}
