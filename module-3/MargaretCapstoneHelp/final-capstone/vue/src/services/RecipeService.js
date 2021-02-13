import axios from 'axios';

const http = axios.create( {
    baseURL: "http://localhost:8080"
});

export default {
    createRecipe(recipe){
        return http.post('/addRecipe', recipe);
    },

    getMyRecipes(userId){
        return http.get(`/myRecipes/${userId}`);
    },
    editRecipe(recipe){
        return http.put('/editRecipe', recipe);
    },
    getOneRecipe(id){
        return http.get(`/recipe/${id}`);
    },
    saveIngredients(recipeId, ingredientBody){
        console.log("INGREDIENTS: ");
        console.log(ingredientBody);
        return http.post(`/recipe/${recipeId}/addIngredient`, ingredientBody);
    },
    getRecipeId(title) {
        return http.get(`/${title}/recipeId`);
    },

    deleteRecipe(recipeId){
        return http.delete(`/removeRecipe/${recipeId}`);
    },

    deleteRecipeFromMeal(mealId, recipeId){
        return http.delete(`/meal/${mealId}/recipe/${recipeId}/delete`);
    },

    deleteIngredientsFromRecipe(recipeId){
        return http.delete(`/recipe/${recipeId}/ingredients/delete`);
    }
}