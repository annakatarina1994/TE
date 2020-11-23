package com.techelevator;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		MovieRental spiderMan = new MovieRental("SpiderMan", "DVD", true);
		MovieRental avengers = new MovieRental("Avengers", "BluRay", true);
		MovieRental fiftyFirstDates = new MovieRental("50 First Dates", "VHS", false);
		
		System.out.println(spiderMan.toString());
	}

}
