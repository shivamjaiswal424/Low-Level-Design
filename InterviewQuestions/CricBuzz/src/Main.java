import Match.Match;
import Match.MatchType;
import Match.T20Match;
import Team.Team;
import Team.Player;
import Team.PlayerType;
import Team.Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Demo demo = new Demo();
        Team teamA=demo.addTeam("India");
        Team teamB=demo.addTeam("Sri Lanka");
        MatchType matchType=new T20Match();
        Match match=new Match(teamA,teamB,null,"Eden Gardens",matchType);
        match.startMatch();
    }


}