package com.techelevator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        int bestRange;
        Automobile truck = new Automobile( 2, 16, 22 );
        Automobile smartCar = new Automobile( 2, 41, 8 );
        if( smartCar.getTotalRangeInMiles( ) > truck.getTotalRangeInMiles( ) ) {
            bestRange = smartCar.getTotalRangeInMiles( );
        } else {
            bestRange = truck.getTotalRangeInMiles( );
        }
        System.out.println(bestRange);
    }
}
