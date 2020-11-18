package com.techelevator;

import com.techelevator.search.SearchDomain;
import com.techelevator.util.TELog;

public class Application {

	public static void main(String[] args) {
		
		try {

			// Step Two: Create TELog, and log the start of the application.
			//
			TELog.log("Search Application started");
			
			
			// Step Four: Instantiate a Search Domain
			//
			SearchDomain searchDomain = new SearchDomain("data");
			TELog.log("Searching domain: " + searchDomain.toString());
			
			// Step Six: Single word search
			//

			
			
			// Step Seven: Multiple word search
			//
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
