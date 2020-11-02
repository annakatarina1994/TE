package com.techelevator;

import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String[] args) {
			System.out.println("Please enter the ending Fibonacci number: ");
			Scanner input = new Scanner(System.in);
			int endingNumber = input.nextInt();
			
			int a = 0;
			int b = 1;
			
			System.out.println(a);
			
			int sum = 0;
			
			while(sum <= endingNumber) {
				System.out.println(b);
				sum = a + b;
				a = b;
				b = sum;
			}
			
	}

}
