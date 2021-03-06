package com.techelevator;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter{

	public static void main(String[] args) throws IOException {
		
		
		String filePath = "FizzBuzz.txt";
		File fizzBuzzFile = new File(filePath);
		fizzBuzzFile.createNewFile();
	
//		try(PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))){
		
		try(PrintWriter writer = new PrintWriter(filePath)){
		
		for(int i = 1; i <= 300; i++) {
			if(i % 15 == 0) {
				writer.println("FizzBuzz");
			} else if(i % 5 == 0) {
				writer.println("Buzz");
			} else if(i % 3 == 0) {
				writer.println("Fizz");
			} else {
				String str = Integer.toString(i);
				writer.println(str);
				}
			}
		}
	}
}

