package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.println("Enter the path of a file or directory >>> ");
		String path = userInput.nextLine(); //pick up the path name as a String
		
		File file = new File(path);
		// we can inspect various attributes of a file system object
		
		System.out.println();
		
		if(file.exists()) { //returns true only if a file or a directory exists at the file system location
			System.out.println("Name: " + file.getName());
			System.out.println("Absolute path: " + file.getAbsolutePath());
			System.out.println("Canonical path: " + file.getCanonicalPath());
			System.out.println("Readable: " + file.canRead());
			System.out.println("Writable: " + file.canWrite());
			
			if(file.isDirectory()) {
				System.out.println("Type: directory");
			}
			if(file.isFile()) {
				System.out.println("Type: file");
			}
			System.out.println("Free Space: " + file.getFreeSpace());
		} else {
			System.out.println(file.getAbsolutePath() + " does not exist");
		}
		
		File newFile = new File("myFile.txt");
		newFile.createNewFile();
		
		File anotherFile = new File("target", "myNewFile.txt"); //creates a new file and puts in in the directory specified
		anotherFile.createNewFile();
		
//		File yetAnotherFile = new File("resources", "myNewFile.txt"); //throws an IOException if the directory does not exist
		
		System.out.println();
		System.out.println("Let's create a new Directory");
		System.out.println("Enter the path of the new directory >>> ");
		path = userInput.nextLine();
		File newDirectory = new File(path);
		
		if(newDirectory.exists()) {
			System.out.println("Sorry! That directory already exists!");
			System.exit(1); //0 or 1 are typical, doesn't matter, just needs an integer
		}
		else if(newDirectory.mkdir()) {
			System.out.println("New directory created!");
			} else {
				System.out.println("Could not create directory.");
				System.exit(1);
		}
		
		System.out.println("Enter file name to create >>> ");
		String fileName2 = userInput.nextLine();
		File newFile2 = new File(newDirectory, fileName2);
		newFile2.createNewFile();
		
		/*
		 * WRITING TO A FILE!!
		 */
		
		PrintWriter writer = new PrintWriter(newFile2.getAbsoluteFile());
		
		String response = "";
		
		do {
			System.out.println("Enter text to save to the file: ");
			String input = userInput.nextLine(); //picks up user text
			writer.println(input);				//puts the user text into the buffer
			
			System.out.println("Do you wish to add more text? (Y/N): ");
			response = userInput.nextLine().toUpperCase();
		} while(response.charAt(0) != 'N');
		
		writer.flush(); // send the bytes to the file from the buffer
		writer.close();
		
		//Show code with try with resources
		/*
		 * try (PrintWriter writer = new PrintWriter(newFile2);
		 * all the rest of the code
		 * 
		 * this will automatically flush and close the file
		 */
		 
	}

}
