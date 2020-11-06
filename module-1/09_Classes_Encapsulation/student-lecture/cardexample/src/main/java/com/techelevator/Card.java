package com.techelevator;

public class Card {
	// data members or properties or instance variables
	private String suit;
	private String value;
	
	public Card() { //default constructor (no params passed in)
		suit = "None";
		value = "Joker";
	}
	
	public Card(String suit, String value) { //overloaded constructor b/c it needs two arguments passed in
		this.suit = suit;
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString() { //returns a string representation of a card
		return this.value + " of " + this.suit;
		
	}
}
