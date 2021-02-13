package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Ingredient;
import com.techelevator.model.IngredientWithUser;

public interface IngredientDAO {
	
//	void addNewIngredientToExistingRecipe(Ingredient[] ingredients, int recipeId);
	
	void addIngredientNotInRecipe(Ingredient ingredient);
	
	void addIngredientAndQuantityNotInRecipe(Ingredient ingredient);
	
	void addNewIngredientToExistingRecipe(IngredientWithUser ingredientObj, int recipeId);
	
	void addExistingIngredientToGroceryList(int ingredientId);
	
	void editIngredientForRecipe(Ingredient ingredient, int recipeId, int ingredientId);
	
	void deleteIngredient (int id);
	
	List<Ingredient> viewIngredientsInRecipe(int recipeId);
	
	List<Ingredient> viewGroceryList(int userId);
	
	public void deleteIngredientsInRecipe(int recipeId);
	
}
