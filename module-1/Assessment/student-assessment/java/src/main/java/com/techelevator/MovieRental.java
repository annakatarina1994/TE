package com.techelevator;


public class MovieRental {
	
	private String title;
	private String format;
	private boolean isPremiumMovie;
	private double rentalPrice;
	
	public MovieRental(String title, String format, boolean isPremiumMovie) {
		this.title = title;
		this.format = format;
		this.isPremiumMovie = isPremiumMovie;
	}

	public String getTitle() {
		return title;
	}

	public String getFormat() {
		return format;
	}

	public boolean isPremiumMovie() {
		return isPremiumMovie;
	}

	public double getRentalPrice() {
		if(format.equals("VHS")) {
			rentalPrice += 0.99;
			return rentalPrice;
		} else if(format.equals("VHS") && isPremiumMovie || format.equals("DVD")) {
			rentalPrice += 1.99;
			return rentalPrice;
		} else if(format.equals("DVD") && isPremiumMovie || format.equals("BluRay")) {
			rentalPrice += 2.99;
			return rentalPrice;
		} else if(format.equals("BluRay") && isPremiumMovie) {
			rentalPrice += 3.99;
			return rentalPrice;
		}
		return rentalPrice;
	}

	public double calculateLateFee(int daysLate) {
		double lateFee = 0.00;
		if(daysLate == 1) {
			lateFee += 1.99;
			return lateFee;
		} else if(daysLate == 2) {
			lateFee += 3.99;
			return lateFee;
		} else if(daysLate >= 3) {
			lateFee += 19.99;
			return lateFee;
		} return lateFee;
	}

	@Override
	public String toString() {
		return "MOVIE - " + title + " - " + format + " - " + getRentalPrice();
	} 
	
	
	
}

