package com.techelevator.Model;

public class Student {
	// data properties, data members, instance variables
	private String name;
	private int age;
	
	//class variables
	private static int count; // one copy per class

	public Student (String name, int age) {
		this.name = name;
		this.age = age;
//		ageStudentBy5();
		count++;
	}
	public Student() {  //default constructor is one with no params
		count++;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
//	private void ageStudentBy5() {
//		age += 5;
//	}
	
	public String toString() {
		return name + "   " + age;
	}
	
	public static int getCount() {
		return count;
	}
}
