package example;

import com.techelevator.Card;
import com.techelevator.Deck;

public class MainProgram {

	public static void main(String[] args) {
		Card aceOfSpades = new Card("Spades", "Ace");
		Card joker = new Card();
		
		System.out.println(joker);
		System.out.println(aceOfSpades);
		
		System.out.println(joker.getValue() + " of " + joker.getSuit());
		
		System.out.println(aceOfSpades.toString());
		
		Deck playingCards = new Deck();
		
		System.out.println(playingCards);
		
		System.out.println("After shuffling: ");
		playingCards.shuffle();
		System.out.println(playingCards);
	}
}
