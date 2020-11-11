package com.techelevator.bigDecimalDemo;

import java.math.BigDecimal;

public class BigDecimalDemoApp {

	public static void main(String[] args) {
		double num1 = 0.02;
		double num2 = 0.03;
		
		double ans1 = num2 - num1;
		
		System.out.println(ans1);
		
		BigDecimal bd1 = new BigDecimal("0.02");
		BigDecimal bd2 = new BigDecimal("0.03");
		
		BigDecimal ans2 = bd2.subtract(bd1);
		BigDecimal bd3 = new BigDecimal("1.0");
//		BigDecimal divide1 =  bd3.divide(bd2); // causes exception!  1/ 3 = 0.33333333 repeating!
		
		System.out.println(ans2);
		
//		System.out.println(divide1);
		BigDecimal money = new BigDecimal(5.00);
		System.out.println(money);
		money = money.subtract(new BigDecimal(0.75));
		System.out.println(money);
	}
}
