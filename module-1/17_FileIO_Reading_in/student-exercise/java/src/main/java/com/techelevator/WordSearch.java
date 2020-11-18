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
	
	System.out.println("Should this search be case sensitive? (Y/N): ");
	String caseResponse = input.nextLine();
	if(caseResponse.startsWith("N")) {
		searchTerm = searchTerm.toLowerCase();
	}
	
	int lineNumber = 1;
	
	try (Scanner fileScanner = new Scanner(aliceFile)) {
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			if(line.contains(searchTerm)) {
				System.out.println(lineNumber + ": " + line);
				}
			lineNumber++;
			}
		}
	}
}
