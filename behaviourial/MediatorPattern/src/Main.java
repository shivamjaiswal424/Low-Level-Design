//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AuctionMediator auctionHouse=new AuctionHouse("Guitar", 100.0);
        IColleague alice=new Bidder("Alice", auctionHouse);
        IColleague bob=new Bidder("Bob", auctionHouse);
        IColleague carol=new Bidder("Carol", auctionHouse);

        alice.placeBid(150.0);
        bob.placeBid(250.0);
        carol.placeBid(300.0);
        alice.placeBid(300.0); // Will not be accepted
        bob.placeBid(900.0); // Winner
        // Admin closes the auction
        auctionHouse.closeAuction();
    }
}