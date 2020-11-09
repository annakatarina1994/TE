package com.techelevator;

public class Automobile {
	
    private int numberOfPassengers;
    private int milesPerGallon;
    private int gasTankCapacityInGallons;
    
    public Automobile( ) {
        numberOfPassengers = 5; 
        milesPerGallon = 30;
        gasTankCapacityInGallons = 15;
    }
    
    public Automobile( int numberOfPassengers, int milesPerGallon, int gasTankCapacityInGallons ) {
        this.numberOfPassengers = numberOfPassengers;
        this.milesPerGallon = milesPerGallon;
        this.gasTankCapacityInGallons = gasTankCapacityInGallons;
    }
    
    public int getTotalRangeInMiles( ) {
        return gasTankCapacityInGallons * milesPerGallon;
    }

}
