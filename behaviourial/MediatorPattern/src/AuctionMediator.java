public interface AuctionMediator {
    public void registerBidder(IColleague colleague);
    public void placeBid(IColleague colleague,double price);
    public void  closeAuction();


}
