package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        String discountString = input.nextLine();
        double discount = Double.parseDouble(discountString) / 100;


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");

        String priceString = input.nextLine();
        String[] priceArray = priceString.split(" ");
        for(int i = 0; i < priceArray.length; i++) {
        	double originalPrice = Double.parseDouble(priceArray[i]);
        	double amountOff = originalPrice * discount;
        	double salePrice = originalPrice - amountOff;
        	
        	System.out.println("Original Price: " + originalPrice +
        			"\nSale Price: " + String.format("%.2f", salePrice));
        input.close();
        }



    }

}