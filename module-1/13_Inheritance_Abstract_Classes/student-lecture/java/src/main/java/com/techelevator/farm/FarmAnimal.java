package com.techelevator.farm;

public abstract class FarmAnimal { //abstract says no concrete objects will be created from this class
	private String name;
	private String sound;
	private boolean isAsleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		isAsleep = false; // by default, animals are awake
	}

	public String getName( ) {
		return name;
	}
	
	public final String getSound( ) {  // final means the method can't be overridden by children
		return sound;
	}
	
	public void sleep() {
		isAsleep = true;
		sound = "Zzzzzzzz.....";
	}

}