package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		
		int numberOfExercises = 26;

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
		
		String name = "TechElevator";

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
		
		String myName = "Anna";
		
		System.out.println(myName);

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		
		int mouseButtons = 2;
		
		System.out.println(mouseButtons);

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/

		String phoneBattery = "56%";
		
		System.out.println(phoneBattery);
		
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int firstNumber = 121;
		int secondNumber = 27;
		int difference = firstNumber - secondNumber;
		
		System.out.println(difference);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		
		double thirdNumber = 12.3;
		double fourthNumber = 32.1;
		double addition = thirdNumber + fourthNumber;
		
		System.out.println(Math.floor(addition));

		/*
		12. Create a String that holds your full name.
		*/
		
		String fullName = "Anna Katarina Lizon";
		
		System.out.println(fullName);

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		
		String greeting = "Hello " + fullName;
		
		System.out.println(greeting);

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/

		String esquire = " Esquire";
		greeting = greeting + esquire;
		System.out.println(greeting);
		
		
		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		
		greeting += esquire;
		System.out.println(greeting);

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/

		String movieTitle = "Saw ";
		movieTitle += 2;
		System.out.println(movieTitle);
		
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/

		movieTitle += "0";
		System.out.println(movieTitle);
		
		/*
		18. What is 4.4 divided by 2.2?
		*/
		
		double fifthNumber = 4.4;
		double sixthNumber = 2.2;
		double answer = fifthNumber / sixthNumber;
		System.out.println(answer);

		/*
		19. What is 5.4 divided by 2?
		*/

		fifthNumber = 5.4;
		sixthNumber = 2.0;
		answer = fifthNumber / sixthNumber;
		System.out.println(answer);
		
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
		System.out.printf("%.3f", ans);
		
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		
		int remainder = 5 % 2;
		System.out.println("\n" + remainder);
		/*
		24. What is 1,000,000,000 * 3?
		*/
		
		long bigNum = (long)(1000000000) * 3;
		System.out.println(bigNum);

		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/

		/*
		26. Now set doneWithExercise to true.
		*/
		
	}

}
