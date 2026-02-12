package Team;

public class Player {
    Person person;
    PlayerType playerType;
    BattingScoreCard battingScoreCard;
    BowlingScoreCard bowlingScoreCard;

    public Player(Person person,PlayerType playerType) {
        this.person = person;
        this.playerType = playerType;
        this.battingScoreCard = new BattingScoreCard();
        this.bowlingScoreCard = new BowlingScoreCard();
    }
    public void printBattingScoreCard() {
        System.out.println("PlayerName: " + getPerson().getName() + " -- totalRuns: " + battingScoreCard.getTotalRun()
                + " -- totalBallsPlayed: " + battingScoreCard.getTotalBallsPlayed() + " -- 4s: " + battingScoreCard.getTotalFours()
                + " -- 6s: " + battingScoreCard.getTotalSixes() + " -- outby: " + ((battingScoreCard.getWicket() != null) ? battingScoreCard.getWicket().getTakenBy().getPerson().getName() : "notout"));
    }

    public void printBowlingScoreCard() {
        System.out.println("PlayerName: " + getPerson().getName() + " -- totalOversThrown: " + getBowlingScoreCard().getTotalOverDeliver()
                + " -- totalRunsGiven: " + getBowlingScoreCard().getRunsGiven() + " -- WicketsTaken: " + getBowlingScoreCard().getWicketTaken());
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public BattingScoreCard getBattingScoreCard() {
        return battingScoreCard;
    }

    public void setBattingScoreCard(BattingScoreCard battingScoreCard) {
        this.battingScoreCard = battingScoreCard;
    }

    public BowlingScoreCard getBowlingScoreCard() {
        return bowlingScoreCard;
    }

    public void setBowlingScoreCard(BowlingScoreCard bowlingScoreCard) {
        this.bowlingScoreCard = bowlingScoreCard;
    }
}
