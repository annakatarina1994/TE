package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        System.out.print("Bidder: " + 
            generalAuction.getHighBid().getBidder());
        System.out.println("     Amount: "
        		+ generalAuction.getHighBid().getBidAmount());
        
        generalAuction.placeBid(new Bid("Fonz", 23));
        System.out.print("Bidder: " + 
                generalAuction.getHighBid().getBidder());
            System.out.println("     Amount: "
            		+ generalAuction.getHighBid().getBidAmount());
            
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        System.out.print("Bidder: " + 
                generalAuction.getHighBid().getBidder());
            System.out.println("     Amount: "
            		+ generalAuction.getHighBid().getBidAmount());
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

            System.out.println("\n\n******  New Buyout Auction  *****");
            BuyoutAuction buyoutAuction = new BuyoutAuction("TE Travel Mug", 55);
            buyoutAuction.placeBid(new Bid("Josh", 35));
            System.out.print("Bidder: " + 
                    buyoutAuction.getHighBid().getBidder());
            System.out.println("     Amount: "
                		+ buyoutAuction.getHighBid().getBidAmount());
            buyoutAuction.placeBid(new Bid("Fonz", 56));
            System.out.print("Bidder: " + 
                    buyoutAuction.getHighBid().getBidder());
            System.out.println("     Amount: "
                		+ buyoutAuction.getHighBid().getBidAmount());
            
            
            
            System.out.println("\n\n");
            SpecialBuyoutAuction sBA = new SpecialBuyoutAuction();
            
    }
}
