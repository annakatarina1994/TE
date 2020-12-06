package com.techelevator;

import com.techelevator.services.ConsoleService;
import com.techelevator.services.HotelService;

public class App {

    private static final String API_BASE_URL = null;

    public static void main(String[] args) {
        int menuSelection = 999;
        int hotelId = -1;

        ConsoleService consoleService = new ConsoleService();
        HotelService hotelService = new HotelService(API_BASE_URL);

        while (menuSelection != 0) {
        	System.out.println("Not implemented");
            if (menuSelection == 1) {
            	System.out.println("Not implemented");
            } else if (menuSelection == 2) {
            	System.out.println("Not implemented");
            } else if (menuSelection == 3) {
            	System.out.println("Not implemented");
            } else if (menuSelection == 4) {
            	System.out.println("Not implemented");
            } else if (menuSelection == 5) {
            	System.out.println("Not implemented");
            } else if (menuSelection == 6) {
            	System.out.println("Not implemented - Create custom query");
            } else if (menuSelection == 0) {
                consoleService.exit();
            } else {
                // anything else is not valid
                System.out.println("Invalid Selection");
            }
            // Press any key to continue...
            if(hotelId != 0) {
                consoleService.next();
            }
            // Ensure loop continues
            menuSelection = 999;
        }

        // if the loop exits, so does the program
        consoleService.exit();
    }

}
