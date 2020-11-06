package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapDemo {

	public static void main(String[] args) {
		/*This program will ask the user to type in a string and
		 * we will load a Hashmap based each word and how many times
		 * the word appeared in the string
		 */
		
		Scanner input = new Scanner(System.in);
		Map<String, Integer> wordMap = new HashMap<>();
		
		System.out.print("Enter words: ");
		String sentence = input.nextLine();
		
		String[] inputSentence = sentence.split(" ");
		
		for(int i = 0; i < inputSentence.length; i++) {
			
		}
	}

}
