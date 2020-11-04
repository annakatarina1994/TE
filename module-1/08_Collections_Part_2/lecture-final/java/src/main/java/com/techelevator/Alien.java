package com.techelevator;

public class Alien {  // blueprint for all aliens
	
	//properties or data members
	private String color = "green";
	private boolean hasBigHead;
	private String planetOfOrigin;
	private boolean isHostile;
	
	public void setColor(String color) {
		if (color.equals("Pink Polka-Dot")) {
			this.color = "Pink";
		}
		else {
		this.color = color;
		}
	}
	public String getColor() {
		return color;
	}
	
	public void setHasBigHead (boolean hasBigHead) {
		this.hasBigHead = hasBigHead;
	}
	public boolean getHasBigHead() {
		return hasBigHead;
	}

	public void setPlanetOfOrigin (String planetOfOrigin) {
		this.planetOfOrigin = planetOfOrigin;
	}
	public String getPlanetOfOrigin() {
		return planetOfOrigin;
	}
	
	public void setIsHostile(boolean isHostile) {
		this.isHostile = isHostile;
	}
	public boolean getIsHostile() {
		return isHostile;
	}
	
}
