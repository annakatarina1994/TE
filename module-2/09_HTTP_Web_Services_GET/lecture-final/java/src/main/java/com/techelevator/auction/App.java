package com.techelevator.auction;

import com.techelevator.models.Auction;
import com.techelevator.services.AuctionService;
import com.techelevator.services.ConsoleService;

public class App {

    public static void main(String[] args) {

    	int menuSelection;
        int auctionId = -1;

        ConsoleService consoleService = new ConsoleService();
        AuctionService auctionService = new AuctionService("http://localhost:3000/auctions");

        while (true) {
            menuSelection = consoleService.printMainMenu();
            if (menuSelection == 1) {
            	Auction[] auctions = auctionService.getAll();
            	if (auctions != null) {
                    consoleService.printAuctions(auctions);
            	}
            } else if (menuSelection == 2) {
            	Auction[] auctions = auctionService.getAll();
                if (auctions != null) {
                    auctionId = consoleService.promptForAuction(auctions, "View");
                    if (auctionId != 0) {
                    	Auction auction = auctionService.getOne(auctionId);
                    	if (auction != null) {
                            consoleService.printAuction(auctionService.getOne(auctionId));
                    	}
                    }
                }
            } else if (menuSelection == 3) {
                String title = consoleService.promptForAuctionTitle();
                if (title != null) {
                	Auction[] auctions = auctionService.getByTitle(title);
                	if (auctions != null) {
                        consoleService.printAuctions(auctions);
                	}
                }
            } else if (menuSelection == 4) {
                double price = consoleService.promptForAuctionPrice();
                if (price != 0.0) {
                	Auction[] auctions = auctionService.getByPrice(price);
                	if (auctions != null) {
                        consoleService.printAuctions(auctions);
                	}
                }
            } else if (menuSelection == 0) { // Exit
                consoleService.exit();
            } else { // defensive programming: anything else is not valid
                System.out.println("Invalid Selection");
            }
            // Press any key to continue...
            if (auctionId != 0) {
                consoleService.next();
            }
        }
    }

}
