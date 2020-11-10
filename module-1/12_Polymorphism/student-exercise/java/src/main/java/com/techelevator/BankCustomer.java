package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
	
	private String name;
	private String address;
	private String phoneNumber;
	private List<Accountable> accounts = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Object[] getAccounts() {
		Object[] accountsArray = new Object[accounts.size()];
		accountsArray = accounts.toArray(accountsArray);
		return accountsArray;
	}
	
	public void addAccount(Accountable newAccount) {
		accounts.add(newAccount);
	}
	
	public boolean isVip() {
		int sum = 0;
		for(Accountable account : accounts) {
			sum += account.getBalance();
		}
		if(sum >= 25000) {
			return true;
		}else if(sum < 25000) {
			return false;
		} return false;
	}

} 