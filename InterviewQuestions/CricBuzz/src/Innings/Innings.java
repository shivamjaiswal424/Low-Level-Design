package Innings;

import Match.MatchType;
import Team.Team;
import Team.Player;
import java.util.ArrayList;
import java.util.List;

public class Innings {
    Team battingTeam;
    Team bowlingTeam;
    MatchType matchType;
    List<Over> overs;

    public Innings(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        overs = new ArrayList<>();
    }
    public void start(int runsToWin){
        try{
            battingTeam.chooseNextBatsman();
        }
        catch (Exception e){

        }
        int noOfOvers = matchType.noOfOvers();
        for(int i = 1; i <= noOfOvers; i++){
            bowlingTeam.chooseNextBowler(matchType.maxOverCountBowlers());
            Over over=new Over(i,bowlingTeam.getCurrentBowler());
            overs.add(over);
            try{
                boolean won=over.startOver(battingTeam,bowlingTeam,runsToWin);
                if(won){
                    break;
                }
            } catch(Exception e){
                break;
            }

            Player temp=battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);

        }
    }
    public int getTotalRuns(){
        return battingTeam.getTotalRuns();
    }
}
