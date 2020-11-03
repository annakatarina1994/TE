package com.techelevator;

import java.util.Arrays;

public class Lecture {

	public static void main(String[] args) {
		
//		int [] myArray = new int[10];
//		Arrays.fill(myArray, 42);
//		System.out.println(Arrays.toString(myArray));
//		
//		int[] newArray = Arrays.copyOf(myArray, 5);
//		System.out.println(Arrays.toString(newArray));
//		
//		newArray[1] = 4;
//		newArray[3] = 13;
//		newArray[4] = 1;
//		newArray[2] = 23; 
//		System.out.println(Arrays.toString(newArray));
//		
//		Arrays.sort(newArray);
//		System.out.println(Arrays.toString(newArray));
//		
//		if (Arrays.equals(myArray, newArray)) {  // compares each element in the arrays to each other
//			System.out.println("equal");
//		}  else {
//			System.out.println("not equal");
//		}
//		
//		String name = "Margaret";  // in one spot (reference value stored in stack)
//		String name2 = new String("Margaret");  // in another spot 
//		
//		if (name == name2) { // compares stack values
//			System.out.println("Names are Equal");
//		} else {
//			System.out.println("Names are not equal");
//		}
//		
//		if (name.equals(name2)) { // compares heap values
//			System.out.println("Names are Equal");
//		} else {
//			System.out.println("Names are not equal");
//		}

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String greeting = "Hello, World!";  // Strings are special
		
		System.out.println("Greeting: " + greeting);
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */
		System.out.println("*************** charAt **************");
		// greeting has Hello World! 
		char first = greeting.charAt(0);  //'H'
		char fourth = greeting.charAt(3); // 'l'
		
		System.out.println(first);
		System.out.println(fourth);
		
		boolean containsWorld = greeting.contains("World");
		System.out.println("Contains World: " + containsWorld);
		
		boolean containsworld = greeting.contains("world");
		System.out.println("Contains world: " + containsworld);
		
		containsworld = greeting.toLowerCase().contains("world"); // take what's in greeting and convert it to lower case and then
																  // see if it contains world
		System.out.println("Contains world: " + containsworld);
		
		String subStr = greeting.substring(0, 5);
		System.out.println(subStr);
		subStr = greeting.substring(7);  // no ending says give every up to the end of the string
		
		System.out.println(subStr);
		
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();


		String newStr = null;
		
		if (newStr == null) {
			System.out.println("newStr is null");
		}
		
		newStr = "";
		
		if (newStr == null) {
			System.out.println("newStr is null");
		} else {
			System.out.println("newStr is empty");
		}

		char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o'};
		String hello1 = new String (helloArray);
		String hello2 = new String (helloArray);
		
		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
