package Match;

import Innings.Innings;
import Team.Team;

import java.util.Date;

public class Match {
    Team teamA;
    Team teamB;
    Date matchDate;
    String venue;
    Team tossWinner;
    Innings[] innings;
    MatchType matchType;

    public Match(Team teamA, Team teamB, Date matchDate, String venue, MatchType matchType) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchDate = matchDate;
        this.venue = venue;

        this.innings = new Innings[2];
        this.matchType = matchType;
    }
    public void startMatch() {
        tossWinner=toss(teamA, teamB);
        for(int i=1;i<=2;i++){
            Innings inning;
            Team bowlingTeam;
            Team battingTeam;

            boolean isChasing=false;
            if(i==1){
                battingTeam=tossWinner;
                bowlingTeam=tossWinner.getTeamName().equals(teamA.getTeamName())? teamB:teamA;
                inning=new Innings(battingTeam,bowlingTeam,matchType);
                inning.start(-1);
            }
            else{
                bowlingTeam=tossWinner;
                battingTeam=tossWinner.getTeamName().equals(teamA.getTeamName())? teamB:teamA;
                inning=new Innings(battingTeam,bowlingTeam,matchType);
                inning.start(innings[0].getTotalRuns());
                if(bowlingTeam.getTotalRuns()>battingTeam.getTotalRuns()){
                    bowlingTeam.isWinner=true;
                }
            }
            innings[i - 1] = inning;
            System.out.println();
            System.out.println("INNING " + inning + " -- total Run: " + battingTeam.getTotalRuns());
            System.out.println("---Batting ScoreCard : " + battingTeam.teamName + "---");

            battingTeam.printBattingScoreCard();

            System.out.println();
            System.out.println("---Bowling ScoreCard : " + bowlingTeam.teamName + "---");
            bowlingTeam.printBowlingScoreCard();


        }
        System.out.println();
        if (teamA.isWinner) {
            System.out.println("---WINNER---" + teamA.teamName);

        } else {
            System.out.println("---WINNER---" + teamB.teamName);

        }

    }
    private Team toss(Team teamA, Team teamB) {
        //random function return value between 0 and 1
        if (Math.random() < 0.5) {
            return teamA;
        } else {
            return teamB;
        }
    }


}
