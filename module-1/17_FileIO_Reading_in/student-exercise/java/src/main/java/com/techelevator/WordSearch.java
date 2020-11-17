package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) throws IOException {
	Scanner input = new Scanner(System.in);
	System.out.println("Please enter the file path: ");
	String path = input.nextLine();
	
	File aliceFile = new File(path);
	
	System.out.println("Please enter the term you'd like to search for: ");
	String searchTerm = input.nextLine();
	
	LineNumberReader lineReader = new LineNumberReader(new FileReader(aliceFile));
	
	try (Scanner fileScanner = new Scanner(aliceFile)) {
		while (fileScanner.hasNextLine()) {
			String line = lineReader.readLine();
			if(line.contains(searchTerm)) {
				System.out.println(lineReader.getLineNumber() + ": " + line);
				}
			}
		lineReader.close();
		}
	}
}
