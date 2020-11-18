package com.techelevator.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TELog {
	
	public static void log(String message) {
 
			PrintWriter dataOutput;
			try {
				dataOutput = new PrintWriter(new FileOutputStream("logs/search.log", true ));
				dataOutput.println(message);
				dataOutput.flush();
				dataOutput.close();
			} catch (FileNotFoundException e) {
				throw new TELogException(e.getMessage()); //passing error message to the TE log exception class...
				//it's still a FileNotFoundException, but been thrown up to this class so you can do
				//extra things with it if you want to... like printing something to the console
			}
	}
}
