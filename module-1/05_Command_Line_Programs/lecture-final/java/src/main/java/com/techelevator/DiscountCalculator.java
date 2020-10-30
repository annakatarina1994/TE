package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        String discountStr = scanner.nextLine();  // scanner.nextLine() grabs what the user types in and stores in discountStr
        double discount = Double.parseDouble(discountStr) / 100; // gives me discount as decimal amount



        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String pricesStr = scanner.nextLine();  // picks up all prices in a line stores them all in pricesStr
        
        String[] priceArray = pricesStr.split(" ");  //breaks apart the prices and stores each price in the array
        
        for (int i = 0; i < priceArray.length; ++i) { // loops through the array one element at a time
        	double originalPrice = Double.parseDouble(priceArray[i]);
        	
        	double amountOff = originalPrice * discount;
        	
        	double salePrice = originalPrice - amountOff;
        	
        	System.out.println("Original Price: " + originalPrice + " Sale Price: " + String.format("%.2f", salePrice));
        	
        }


        scanner.close();



    }

}