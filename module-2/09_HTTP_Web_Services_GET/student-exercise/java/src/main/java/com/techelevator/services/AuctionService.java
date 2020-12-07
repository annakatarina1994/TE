package com.techelevator.services;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.models.Auction;

public class AuctionService {

    private final String BASE_URL;
    public RestTemplate restTemplate = new RestTemplate();
    private final ConsoleService console = new ConsoleService();

    public AuctionService(String url) {
        BASE_URL = url;
    }


    public Auction[] getAll() {
        Auction[] auctions = restTemplate.getForObject(BASE_URL, Auction[].class);
        return auctions;
    }

    public Auction getOne(int id) {
    	Auction auction = restTemplate.getForObject(BASE_URL + "/" + id, Auction.class);
        return auction;

    }

    public Auction[] getByTitle(String title) {
    	Auction[] auctions = restTemplate.getForObject(BASE_URL + "?title_like=" + title, Auction[].class);
        return auctions;
        
    }

    public Auction[] getByPrice(double price) {
    	Auction[] auctions = restTemplate.getForObject(BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        return auctions;

    }

}
