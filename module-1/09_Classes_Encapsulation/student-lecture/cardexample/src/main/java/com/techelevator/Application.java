package com.techelevator;

public class Application {

	public static void main(String[] args) {
		Card aceOfSpades = new Card("Spades", "Ace");
		Card joker = new Card();
		
		System.out.println(aceOfSpades.toString());
		
		Deck playingCards = new Deck();
		
		System.out.println(playingCards);
		
		System.out.println("After shuffling: ");
		playingCards.shuffle();
		System.out.println(playingCards);
	}

}
