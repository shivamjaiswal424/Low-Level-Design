package Innings;

import ScoreUpdaterObserver.ScoreUpdaterObserver;
import ScoreUpdaterObserver.BattingScoreUpdater;
import Team.Player;
import Team.WicketType;
import Team.Team;
import Team.Wicket;

import java.util.ArrayList;
import java.util.List;

public class Ball {
    public int ballNumber;
    public BallType ballType;
    public RunType runType;
    public Player playedBy;
    public Player bowledBy;
    public Wicket wicket;
    public List<ScoreUpdaterObserver> scoreUpdaterObservers=new ArrayList<>();

    public Ball(int number){
        this.ballNumber=number;
        scoreUpdaterObservers.add(new BattingScoreUpdater());
        scoreUpdaterObservers.add(new BattingScoreUpdater());
    }
    public void startBallDelivery(Team battingTeam,Team bowlingTeam,Over over){
        playedBy=battingTeam.getStriker();
        this.bowledBy=over.bowledBy;
        ballType=BallType.NORMAL;
        if(isWicketTaken()){
            runType=RunType.ZERO;
            wicket=new Wicket(WicketType.BOLD, bowlingTeam.getCurrentBowler(),over,this);
            battingTeam.setStriker(null);

        }
        else{
            runType=getRunType();
            if(runType==RunType.ONE || runType==RunType.THREE){
                //swap
                Player temp=battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getStriker());
                battingTeam.setNonStriker(temp);
            }
        }
        notifyUpdaters(this);

    }
    public void notifyUpdaters(Ball ball){
        for(ScoreUpdaterObserver observer:scoreUpdaterObservers){
            observer.update(ball);
        }
    }
    private RunType getRunType() {

        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

    private boolean isWicketTaken() {
        //random function return value between 0 and 1
        if (Math.random() < 0.2) {
            return true;
        } else {
            return false;
        }
    }


    public int getBallNumber() {
        return ballNumber;
    }

    public void setBallNumber(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }



    public Player getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(Player playedBy) {
        this.playedBy = playedBy;
    }

    public Player getBowledBy() {
        return bowledBy;
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }

    public Wicket getWicket() {
        return wicket;
    }

    public void setWicket(Wicket wicket) {
        this.wicket = wicket;
    }

    public List<ScoreUpdaterObserver> getScoreUpdaterObservers() {
        return scoreUpdaterObservers;
    }

    public void setScoreUpdaterObservers(List<ScoreUpdaterObserver> scoreUpdaterObservers) {
        this.scoreUpdaterObservers = scoreUpdaterObservers;
    }
}
