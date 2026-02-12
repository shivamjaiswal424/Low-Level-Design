package Team;

import java.util.List;
import java.util.Queue;

public class Team {
    public String teamName;
    public Queue<Player>playing11;
    public List<Player> bench;
    public PlayerBattingController playerBattingController;
    public PlayerBowlingController playerBowlingController;
    public boolean isWinner;

    public Team(String teamName, Queue<Player> playing11, List<Player> bench, List<Player> bowlers) {
        this.teamName = teamName;
        this.playing11 = playing11;
        this.bench = bench;
        this.playerBattingController = new PlayerBattingController(playing11);
        this.playerBowlingController = new PlayerBowlingController(bowlers);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public void chooseNextBatsman(){
        playerBattingController.getNextPlayer();
    }
    public void chooseNextBowler(int maxOverCountPerBowler){
        playerBowlingController.getNextBowler(maxOverCountPerBowler);
    }
    public Queue<Player> getPlaying11() {
        return playing11;
    }

    public void setPlaying11(Queue<Player> playing11) {
        this.playing11 = playing11;
    }

    public List<Player> getBench() {
        return bench;
    }

    public void setBench(List<Player> bench) {
        this.bench = bench;
    }

    public PlayerBattingController getPlayerBattingController() {
        return playerBattingController;
    }

    public void setPlayerBattingController(PlayerBattingController playerBattingController) {
        this.playerBattingController = playerBattingController;
    }

    public PlayerBowlingController getPlayerBowlingController() {
        return playerBowlingController;
    }

    public void setPlayerBowlingController(PlayerBowlingController playerBowlingController) {
        this.playerBowlingController = playerBowlingController;
    }
    public Player getStriker() {
        return playerBattingController.getStriker();
    }
    public void setStriker(Player striker) {
        this.playerBattingController.setStriker(striker);
    }
    public Player getNonStriker() {
        return playerBattingController.getNonStriker();
    }
    public void setNonStriker(Player nonStriker) {
        playerBattingController.setNonStriker(nonStriker);
    }
    public Player getCurrentBowler() {
        return  playerBowlingController.getCurrentBowler();
    }
    public void printBattingScoreCard(){
        for(Player player : playing11){
            player.printBattingScoreCard();
        }
    }
    public void printBowlingScoreCard(){
        for(Player player : playing11){
            if(player.getBowlingScoreCard().getTotalOverDeliver()>0){
                player.printBowlingScoreCard();
            }

        }
    }
    public int getTotalRuns(){
        int totalRuns = 0;
        for(Player player : playing11){
            totalRuns+=player.getBattingScoreCard().getTotalRun();
        }
        return totalRuns;
    }
}
