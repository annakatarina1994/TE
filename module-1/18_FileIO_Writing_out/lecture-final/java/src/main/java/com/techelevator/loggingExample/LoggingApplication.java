package com.techelevator.loggingExample;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class LoggingApplication {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
				
		System.out.print("Enter the file name: ");
		String path = input.nextLine();

		try (Logger log = new Logger(path)){
			System.out.println("Opening file for writing");
			log.write("Starting new session on " + LocalDateTime.now());
			String response = "";
			do {
				System.out.print("Enter text to save to the file: ");
				String inputMsg = input.nextLine();  //picks up user text 
				log.write(inputMsg);					//  puts the user text into the buffer
				
				System.out.print("Do you wish to add more text? (Y/N): ");
				response = input.nextLine().toUpperCase();
			} while (response.charAt(0) != 'N');
			
			log.write("Closing session on " + LocalDateTime.now());
		}

	}

}
