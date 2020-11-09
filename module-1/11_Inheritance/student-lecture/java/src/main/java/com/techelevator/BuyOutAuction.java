package com.techelevator;

public class BuyOutAuction extends Auction{
	//data member
	private int buyOutPrice;
	
//	public BuyOutAuction() {
//		super("A red balloon");
//	}
	
	public BuyOutAuction(String itemForSale, int buyOutPrice) {
		super(itemForSale);
		this.buyOutPrice = buyOutPrice;
	}
	
	/*
	 * if offered bid meets or exceeds the buyout price,
	 * bid is set to buyoutPrice and all future bids are ignored
	 */
	
	//overriding means we are providing a new version of the parent's method
	@Override
	public boolean placeBid(Bid offeredBid) {
		boolean isCurrentWinningBid = false;
		if(offeredBid.getBidAmount() >= buyOutPrice) {
			// you are buying the item at the buyout price
			offeredBid = new Bid(offeredBid.getBidder(), buyOutPrice);
			isCurrentWinningBid = super.placeBid(offeredBid);
		}
		return isCurrentWinningBid;
	}

}
