package ScoreUpdaterObserver;

import Innings.Ball;
import Innings.RunType;

public class BattingScoreUpdater implements ScoreUpdaterObserver {

    @Override
    public void update(Ball ball) {
        int run=0;
        if(ball.runType== RunType.ONE){
            run=1;
        }
        else if(ball.runType== RunType.TWO){
            run=2;
        }
        else if(ball.runType== RunType.THREE){
            run=3;
        }
        else if(ball.runType== RunType.FOUR){
            run=4;
            ball.playedBy.getBattingScoreCard().totalFours++;
        }
        else if(ball.runType==RunType.SIX){
            run=6;
            ball.playedBy.getBattingScoreCard().totalSixes++;
        }
        ball.playedBy.getBattingScoreCard().totalRun+=run;
        ball.playedBy.getBattingScoreCard().totalBallsPlayed++;
        if(ball.wicket!=null){
            ball.playedBy.getBattingScoreCard().setWicket(ball.wicket);
        }
    }
}
