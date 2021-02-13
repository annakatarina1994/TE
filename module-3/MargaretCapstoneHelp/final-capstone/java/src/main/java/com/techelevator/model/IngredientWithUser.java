package com.techelevator.model;

import java.util.List;

public class IngredientWithUser {
	private List<Ingredient> ingredients;
	private Long userId;
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredeints(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}