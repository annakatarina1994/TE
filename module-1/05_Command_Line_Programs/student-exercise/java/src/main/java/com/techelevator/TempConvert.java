package com.techelevator;

import java.util.Scanner;

public class TempConvert {
	
//	Tf = Tc * 1.8 + 32 Celcius => Fahrenheit
//	Tc = (Tf - 32) / 1.8 Fahrenheit => Celcius

	public static void main(String[] args) {
		System.out.println("Please enter the temperature: ");
		Scanner input = new Scanner(System.in);
		String tempInput = input.nextLine();
		
		System.out.println("Is this in Celsius or Fahrenheit? (enter C or F): ");
		String tempType = input.nextLine();
		
		if(tempType.equals("F")) {
			double tempInputF = Double.parseDouble(tempInput);
			double tempInCelsius = (tempInputF - 32) / 1.8;
			System.out.println("The temperature you entered was: " + tempInputF + " degrees Fahrenheit" +
					"\nThe temperature in Celsius is: " + String.format("%.2f", tempInCelsius));
		} else if(tempType.equals("C")) {
			double tempInputC = Double.parseDouble(tempInput);
			double tempInFahrenheit = tempInputC * 1.8 + 32;
			System.out.println("The temperature you entered was: " + tempInputC + " degrees Celsius" +
					"\nThe temperature in Fahrenheit is: " + String.format("%.2f", tempInFahrenheit));
			}
		}
	}