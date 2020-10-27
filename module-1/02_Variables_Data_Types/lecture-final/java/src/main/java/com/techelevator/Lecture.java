package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises;
		numberOfExercises = 26;

		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half = 0.5;
		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "Tech Elevator";

		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;

		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";

		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/

		double pi = 3.1416;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/

		String myName = "Margaret Green";
		System.out.println(name);
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfButtons = 3;
		System.out.println(numberOfButtons);
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		double phoneBatteryActual = .8527213;
		System.out.println(phoneBatteryActual);
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int numberOne = 121;
		int numberTwo = 27;
		
		int difference = numberOne - numberTwo;
		System.out.println(difference);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double doubleOne = 12.3;
		double doubleTwo = 32.1;
		
		double addition = doubleOne + doubleTwo;
		System.out.println(addition);
		/*
		12. Create a String that holds your full name.
		*/
		String fullName = "Margaret Green";
		System.out.println(fullName);
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String greeting = "Hello, " + fullName;
		System.out.println(greeting);
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		greeting = greeting + " Esquire"; // do the right side of the = first
		    // means greeting + " Esquire" => "Hello, Margaret Green Esquire"
			// and then store all back in the variable greeting
		System.out.println(greeting);
		/*
		15. Now do the same as exercise 14, but use the += operator.
		     x += 5;  is the same as x = x + 5;  
		     += , -=, *=, /=, %=
		*/
		greeting += " Esquire";
		System.out.println(greeting);
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String movieTitle = "Saw";
		movieTitle += 2;
		System.out.println(movieTitle);

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		movieTitle += "0";  // have to add it as a String
		System.out.println(movieTitle);

		/*
		18. What is 4.4 divided by 2.2?
		*/
		double nOne = 4.4;
		double nTwo = 2.2;
		
		System.out.println(nOne / nTwo);

		/*
		19. What is 5.4 divided by 2?
		*/

		/*
		20. What is 5 divided by 2?
		*/

		/*
		21. What is 5.0 divided by 2?
		*/

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		    double ans = 66.6 / 100;
		    System.out.println(ans);  // numerical accuracy problem -- don't use doubles for money
		    System.out.printf("%.3f\n", ans);  // % specifier  .3 says 3 decimal places to the right of the . f for float
		    		//  \n  says newline
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		    int remainder = 5  % 2;
		    System.out.println(remainder);
		/*
		24. What is 1,000,000,000 * 3?
		*/
		    long bigNumber = 1000000000 * (long)3;
		    System.out.println(bigNumber);
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		    boolean doneWithExercises = false;
		    System.out.println(doneWithExercises);
		/*
		26. Now set doneWithExercise to true.
		*/
		doneWithExercises = true;
		System.out.println(doneWithExercises);
	}

}
