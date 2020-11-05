package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();
		
// interface <data type, T>  objectName = new  className<> ()
		Map <String, String> nameToZip = new HashMap<>();
		
		nameToZip.put("Bob", "23454");
		nameToZip.put("Tom", "44565");
		nameToZip.put("Jim", "56123");
		
		
		// if you know the key, you can use get to get the value
		System.out.println("Bob lives in " + nameToZip.get("Bob"));
		
		// keys have to be unique, otherwise we overwrite the value
		System.out.println("Tom lives in " + nameToZip.get("Tom"));
		nameToZip.put("Tom", "99999");
		System.out.println("The new Tom lives in " + nameToZip.get("Tom"));
		
		System.out.println("****************  Printing all elements in the Map ****************");
		Set<String> keys = nameToZip.keySet();  // returns a collection of all the keys in the Map
		for (String name: keys) {
			System.out.println(name + " lives in " + nameToZip.get(name));
		}
		
		System.out.println("**************  Printing all elements using an entry set ***************");
		for (Map.Entry<String, String> nameZip : nameToZip.entrySet()) {  // returns collection of k,v pairs 
			System.out.println(nameZip.getKey() + " lives in " + nameZip.getValue());
		}
		
		nameToZip.put("Sue", "33454");
		nameToZip.put("Ann", "23454");
		nameToZip.put("Rex", "99999");
		System.out.println("*************** Printing out elements after putting more in *****************");
		System.out.println(nameToZip);
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a zip to search for: ");
		String zip = input.nextLine();
		int counter = 0;  // counter to count how many people live at a zipCode
		
		for (Map.Entry<String, String> nameZip : nameToZip.entrySet()) {
			if (zip.equals(nameZip.getValue())) {
				System.out.println(nameZip.getKey() + " lives in that zipCode");
				counter++;
			}
		}
		if (counter == 0 ) {
			System.out.println("No one at that zipCode");
		}
		
	}

}
