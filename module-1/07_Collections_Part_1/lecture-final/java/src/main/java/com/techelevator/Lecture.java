package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		 
		List <String> names = new ArrayList <>();
		names.add("Frodo");
		names.add("Sam");
		names.add("Pippin");
		names.add("Merry");
		names.add("Gandalf");
		names.add("Aragorn");
		names.add("Legolas");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i = 0 ; i < names.size(); i++) {
			System.out.println(names.get(i));  // in an ArrayList, this is the same as names[i] in an array
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		names.add("Sam");

		for (int i = 0 ; i < names.size(); i++) {
			System.out.println(names.get(i));  // in an ArrayList, this is the same as names[i] in an array
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		names.add(3, "Bilbo");
		for (int i = 0 ; i < names.size(); i++) {
			System.out.println(names.get(i));  // in an ArrayList, this is the same as names[i] in an array
		}
		
		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(5);
		for (int i = 0 ; i < names.size(); i++) {
			System.out.println(names.get(i));  // in an ArrayList, this is the same as names[i] in an array
		}
		
		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if (names.contains("Bilbo")) {
			System.out.println("names contains Bilbo");
		}
		else {
			System.out.println("Bilbo is not found!");
		}
		
		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		
		int indexOfMerry = names.indexOf("Merry");
		System.out.println("Merry is in position: " + indexOfMerry);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] namesArray = names.toArray(new String[0]);
		for (int i = 0 ; i < namesArray.length; i++) {
			System.out.println(namesArray[i]);
		}
		
		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");
		// sorting Collections.sort() method we can use -- it is called an in-place method
		Collections.sort(names);
		
		System.out.println(names);


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");
		// Collections.reverse() is also an in-place method
		Collections.reverse(names);
		System.out.println(names);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
		
		// names ArrayList
		for (String name: names) {  // for Each loop loops through all elements in the AL - var to use is name
			System.out.println("Hello, " + name);
		}
	

// removeAll and then peek
		names.removeAll(names);
		System.out.println(names);
		
		List <Integer> intList = new ArrayList<>(Arrays.asList(23, 45, 17, 1, 56));  // this allowed me to declare and initialize
		
		Collections.sort(intList);
		
		// calculate the average
		int sum = 0;
		for (Integer num: intList) {
			sum += num;
		}
		double avg = (double) sum / intList.size();
		System.out.println("The average is " + avg);
		
	}
}
