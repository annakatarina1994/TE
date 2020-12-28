package com.techelevator;

public class Car {
	
	private int year;
	private String make;
	private boolean isClassicCar;
	private int age;
	
	public Car(int year, String make, boolean isClassicCar) {
		this.year = year;
		this.make = make;
		this.isClassicCar = isClassicCar;
	}
	
	
	
	
	public boolean carNeedsECheck(int yearToCheck) {
		int age = getAge(yearToCheck);
		if (this.isClassicCar == false) {
			if(age < 4 || age > 25) {
				return false;
			}
			if(year % 2 == 0 && yearToCheck % 2 == 0) {
				return true;
			}
			if(year % 2 != 0 && yearToCheck %2 != 0) {
				return true;
			}
		}
		return false;
	}


	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public boolean isClassicCar() {
		return isClassicCar;
	}

	public void setClassicCar(boolean isClassicCar) {
		this.isClassicCar = isClassicCar;
	}

	public int getAge(int yearToCheck) {
		this.age = yearToCheck - year;
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "CAR - " + year + " - " + make;
	}

	
	
}
