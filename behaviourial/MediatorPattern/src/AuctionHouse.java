import java.util.ArrayList;
import java.util.List;

public class AuctionHouse implements AuctionMediator {
    private List<IColleague> colleagues;
    private IColleague currentHighestBidder;
    private double currentHighestBidPrice;
    private String bidItem;

    public AuctionHouse(String bidItem,double startingPrice) {
        this.currentHighestBidPrice = startingPrice;
        this.bidItem = bidItem;
        this.colleagues=new ArrayList<>();
        System.out.println("AuctionHouse created for "+ bidItem);
    }

    @Override
    public void registerBidder(IColleague bidder) {
        colleagues.add(bidder);
        System.out.println(bidder.getBidderName() +" is registered for "+ bidItem);
    }

    @Override
    public void placeBid(IColleague colleague, double price) {
        if(currentHighestBidPrice>=price){
            System.out.println(colleague.getBidderName()+", bid value is too low. Current bid is "+currentHighestBidPrice);
            return;
        }
        currentHighestBidPrice=price;
        currentHighestBidder=colleague;
        for(IColleague bidder:colleagues){
            if(!bidder.getBidderName().equals(colleague.getBidderName())){
                bidder.receiveNotification(price);
            }
        }
    }

    @Override
    public void closeAuction() {
        if(currentHighestBidder==null){
            System.out.println("AuctionHouse has been closed with no bidder");
            return;
        }
        System.out.println("AuctionHouse has been closed with bidder" + currentHighestBidder.getBidderName() + "with bid " + currentHighestBidPrice);

    }
}
