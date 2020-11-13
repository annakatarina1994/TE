package com.techelevator;

import java.util.Scanner;

public class GuessingGameApp {

	public static void main(String[] args) {
		int randomNumber = (int)(Math.random() * 100);
		
		System.out.println("*****************************************************************");
		System.out.println("***************       Anna's Guessing Game       ****************");
		System.out.println("*****************************************************************");
		System.out.println("\nWelcome to my game!\nYou need to guess a number between 1 and 100 to win the game!");
		
		Scanner input = new Scanner(System.in);
		int count = 5;
		
		
		while(count > 0) { 
			System.out.println("Enter your guess: ");
			int guess = Integer.parseInt(input.nextLine());
		 count--;
			
			if(guess == randomNumber) {
				System.out.println("You Win!!!");
				break;
			}else if(guess < randomNumber) {
				System.out.println("Number is too Low! Guess again!");
				System.out.println("You have " + count + " guesses left!");
				
			}else {
				System.out.println("Number is too high! Guess again!");
				System.out.println("You have " + count + " guesses left!");
			}
		}
		if(count == 0) {
			System.out.println("You lose!! The number was " + randomNumber);
		}
	}

}
