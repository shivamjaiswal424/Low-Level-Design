public class Bidder implements IColleague {

    private String bidderName;
    private AuctionMediator mediator;


    public Bidder(String bidderName,AuctionMediator mediator) {
        this.bidderName = bidderName;
        this.mediator=mediator;
        mediator.registerBidder(this);
    }
    @Override
    public void placeBid(double price) {
        System.out.println("Bidder "+bidderName+" placing bid for "+price);
        mediator.placeBid(this,price);
    }

    @Override
    public void receiveNotification(double price) {
        System.out.println("Bidder " + bidderName+" received notification for amount "+ price);
    }

    @Override
    public String getBidderName() {
        return bidderName;
    }
}
