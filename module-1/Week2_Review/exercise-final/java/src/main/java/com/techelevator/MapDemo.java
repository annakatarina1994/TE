package com.techelevator;

import java.util.*;  // program has access to ANY class declared in the java.util package


/*
 * This program will ask the user to type in a string and
 * we will load a Hashmap based each word and how many times
 * the word appeared in the string
 */
public class MapDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//    word, count
		Map <String, Integer>  wordMap = new HashMap<>();
		
		System.out.print("Enter words: ");
		String sentence = input.nextLine();
		String[] inputSentence = sentence.split(" ");  // splits the sentence into one word on each line in the array

		//for (String word: inputSentence) -- forEach loop -- for each String (variable called word) in the inputSentence array
		for (int i = 0 ; i < inputSentence.length; i++) {
			System.out.println(inputSentence[i]);
			if (wordMap.containsKey(inputSentence[i]) == false) {
				wordMap.put(inputSentence[i], 1);
			}
			else {  // means that wordMap already contains the key 
				int value = wordMap.get(inputSentence[i]);
				value++;
				wordMap.put(inputSentence[i], value);
			}
		}
		System.out.println(wordMap);
	}

}
