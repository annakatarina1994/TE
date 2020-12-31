package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) throws FileNotFoundException {
		File carFile = new File("data-files/CarInput.csv");
		List cars = new ArrayList<>();
		
		try(Scanner fileScanner = new Scanner(carFile)){
			
			int totalAge = 0;
			
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] carArray = line.split(",");
				
				int year = Integer.parseInt(carArray[0]);
				String make = carArray[1];
				boolean isClassicCar = Boolean.parseBoolean(carArray[2]);
				
				Car car = new Car(year, make, isClassicCar);
				cars.add(car);
				
				
				int age = car.getAge(2020);
				System.out.println(age);
				totalAge = totalAge + age;
			}
			System.out.println(cars.toString());
			System.out.println(totalAge);
		}
		
		
		
		
//		Car viper = new Car(2000, "Dodge", false);
//		Car oldCorvette = new Car(1957, "Chevy", true);
//		
//		System.out.println(viper.carNeedsECheck(2020));
//		System.out.println(viper.toString());
	}

	
}
