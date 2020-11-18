package com.techelevator.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TELog {
	
	public static void log(String message) {
		
		try {
			PrintWriter dataOutput = new PrintWriter(new FileOutputStream(
			   "logs/search.log", true));  /* This true sets the file to be appended */
			
			dataOutput.println(message);
			dataOutput.flush();
			dataOutput.close();
		} catch (FileNotFoundException e) {
			throw new TELogException(e.getMessage());  // <= pass the error message to the TELogException class
		}
	}

}
