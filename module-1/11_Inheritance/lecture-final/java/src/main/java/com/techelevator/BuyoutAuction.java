package com.techelevator;

public class BuyoutAuction extends Auction{
	// data member 
	private int buyoutPrice;
	
//	public BuyoutAuction() {
//		super("A red balloon");
//	}
	// overloading means 2 or more methods
	// named the same with different parameters
	public BuyoutAuction(String itemForSale, 
			     int buyoutPrice) {
		super(itemForSale);
		this.buyoutPrice = buyoutPrice;
		System.out.println("BuyoutAuction object");
	}

	// overriding means we are providing 
	// a new version of the parent's method
	/*
	 * if offeredBid meets or exceed the buyoutPrice
	 * bid is set to buyoutPrice and all future bids are ignored.
	 */
	@Override
	public boolean placeBid(Bid offeredBid) {
		boolean isCurrentWinningBid = false;
		if (offeredBid.getBidAmount() >= buyoutPrice) {
			// you are buying the item at the buyoutPrice
			offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
			isCurrentWinningBid = super.placeBid(offeredBid);
		} else {
			super.placeBid(offeredBid);
		}
		return isCurrentWinningBid;
	}

}
