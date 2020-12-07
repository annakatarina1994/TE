package com.techelevator.auction;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import com.techelevator.models.Auction;
import com.techelevator.services.AuctionService;

public class AppTest {

        private static final String BASE_URL = "http://localhost:3000/auctions";

        private AuctionService auctionService = new AuctionService(BASE_URL);
        private RestTemplate mockRestTemplate  = Mockito.mock(RestTemplate.class);

        private final Auction[] auctions = { new Auction(0, "Zero", "Zero Auction", "User0", 0.0),
                new Auction(1, "One", "One Auction", "User1", 1.1) };

        private final Auction auction = new Auction(0, "Zero", "Zero Auction", "User0", 0.0);

        @Test
        public void listAllAuctions() {

                Mockito.when(mockRestTemplate.getForObject(Mockito.eq(BASE_URL), Mockito.eq(Auction[].class)))
                        .thenReturn(auctions);
                auctionService.restTemplate = mockRestTemplate;

                assertArrayEquals(auctionService.getAll(), auctions);
        }

        @Test
        public void listDetailsForAuction() {
                int auctionID = 0;
                Mockito.when(mockRestTemplate.getForObject(Mockito.eq(BASE_URL + "/" + auctionID), Mockito.eq(Auction.class)))
                        .thenReturn(auction);
                auctionService.restTemplate = mockRestTemplate;

                assertEquals(auction, auctionService.getOne(auctionID));
        }

        @Test
        public void findAuctionsSearchTitle() {
                String title = "Zero";
                Mockito.when(mockRestTemplate.getForObject(Mockito.eq(BASE_URL + "?title_like=" + title), Mockito.eq(Auction[].class)))
                        .thenReturn(auctions);
                auctionService.restTemplate = mockRestTemplate;

                assertArrayEquals(auctions, auctionService.getByTitle(title));
        }

        @Test
        public void findAuctionsSearchPrice() {
                double price = 23.25;
                Mockito.when(mockRestTemplate.getForObject(Mockito.eq(BASE_URL + "?currentBid_lte=" + price), Mockito.eq(Auction[].class)))
                        .thenReturn(auctions);
                auctionService.restTemplate = mockRestTemplate;

                assertArrayEquals(auctions, auctionService.getByPrice(price));
        }

}
