package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deckOfCards = new ArrayList<>();
	// ArrayList to hold a deck of cards 
	
	public Deck() {  // default constructor -- no params
		//  52 cards
		for (String suit : new String[] {"Spades", "Hearts", "Diamonds", "Clubs"}) {
			for (String value: new String[] {
					"Ace", "Two" ,"Three", "Four", "Five",
					"Six", "Seven", "Eight", "Nine", "Ten",
					"Jack", "Queen", "King"}) {
				Card currentCard = new Card(suit, value);
				deckOfCards.add(currentCard);
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(deckOfCards); // in place shuffling of the cards
	}
	
	public String toString() {
		return "Deck is " + deckOfCards;
	}

}
