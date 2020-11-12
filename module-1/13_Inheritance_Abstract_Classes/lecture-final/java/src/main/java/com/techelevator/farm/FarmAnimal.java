package com.techelevator.farm;

public abstract class FarmAnimal {    // abstract says no actual objects will be created from this class
	private String name;
	private String sound;
	private boolean isAsleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		isAsleep = false;  // by default animals are awake
	}

	public abstract void eat();  // any class that extends from FarmAnimal will provide the body for this method
	
	public String getName( ) {
		return name;
	}
	public final String getSound( ) {   // method cannot be overridden by any children
		return sound;
	}
	
	public void sleep() {  
		isAsleep = true;
		sound = "Zzzzz....";
	}


}