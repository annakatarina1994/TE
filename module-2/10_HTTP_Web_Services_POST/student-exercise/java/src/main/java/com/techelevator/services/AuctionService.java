package com.techelevator.services;

import com.techelevator.models.Auction;

import java.util.Random;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class AuctionService {

    private final String BASE_URL;
    public RestTemplate restTemplate = new RestTemplate();
    private final ConsoleService console = new ConsoleService();

    public AuctionService(String url) {
        BASE_URL = url;
    }


    public Auction[] getAll() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(BASE_URL, Auction[].class);
        } catch (RestClientResponseException ex) {
            console.printError("Could not retrieve the auctions. Is the server running?");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auctions;
    }

    public Auction getOne(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(BASE_URL + "/" + id, Auction.class);
        } catch (RestClientResponseException ex) {
            console.printError("Could not retrieve the auction.");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auction;
    }

    public Auction[] getByTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException ex) {
            console.printError("The title was not found. Please try again.");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auctions;
    }

    public Auction[] getByPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException ex) {
            console.printError("No auctions found. Please try again.");
        } catch (ResourceAccessException ex) {
            console.printError("A network error occurred.");
        }
        return auctions;
    }

    public Auction add(String auctionString) {
        Auction auction = makeAuction(auctionString);
        
        if(auction == null) {
        	return null;
        }
        
        HttpEntity<Auction> entity = makeEntity(auction);
        try {
        	auction = restTemplate.postForObject(BASE_URL, entity, Auction.class);
        } catch (RestClientResponseException ex) {
        	console.printError(ex.getRawStatusCode() + ": " + ex.getStatusText());
        	return null;
        } catch (ResourceAccessException ex) {
        	console.printError(ex.getMessage());
        	return null;
        }
        return auction;
    }

    public Auction update(String auctionString) {
        Auction auction = makeAuction(auctionString);
        if(auction == null) {
        	return null;
        }
        HttpEntity<Auction> entity = makeEntity(auction);
        
        try {
        	restTemplate.put(BASE_URL + "/" + auction.getId(), entity);
        } catch (RestClientResponseException ex) {
        	console.printError(ex.getRawStatusCode() + ": " + ex.getStatusText());
        	return null;
        } catch (ResourceAccessException ex) {
        	console.printError(ex.getMessage());
        	return null;
        }
        return auction;
    }

    public boolean delete(int id) {
    	try {
    	restTemplate.delete(BASE_URL + "/" + id);
    	}catch (RestClientResponseException ex) {
        	console.printError(ex.getRawStatusCode() + ": " + ex.getStatusText());
        	return false;
        } catch (ResourceAccessException ex) {
        	console.printError(ex.getMessage());
        	return false;
        }
    	return true; 
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	HttpEntity<Auction> entity = new HttpEntity<>(auction, headers);
    	return entity;
    }

    private Auction makeAuction(String csv) {
        String[] parsed = csv.split(",");
        
        if(parsed.length < 4 || parsed.length > 5) {
        	return null;
        }
        if(parsed.length == 4) {
        	String[] withId = new String[5];
        	String[] idArray = new String[] { new Random().nextInt(1000) + ""};
        	System.arraycopy(idArray, 0, withId, 0, 1);
        	System.arraycopy(parsed, 0, withId, 1, 4);
        	parsed = withId;
        	}
        return new Auction(Integer.parseInt(parsed[0].trim()), parsed[1].trim(), parsed[2].trim(),
        		parsed[3].trim(), Double.parseDouble(parsed[4].trim()));
    }

}
