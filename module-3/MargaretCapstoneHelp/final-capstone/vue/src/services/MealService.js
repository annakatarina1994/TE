import axios from 'axios';

const http = axios.create( {
    baseURL: "http://localhost:8080"
});

export default {
    getMyMeals(userId){
        return http.get(`/meals/${userId}`);
    },

    addMeal(meal){

        return http.post('/addMeal', meal);
    },
    addMealToPlan(schedule){
        return http.put('/editSchedule', schedule);
    },
    removeMealFromPlan(scheduleId, mealId){
        return http.delete('/removeMealFromSchedule', scheduleId, mealId);
    },
    viewSchedule(mealPlanId){
        return http.get('/getSchedule', mealPlanId);

        // const data = http.post('/addMeal', meal);
        // return data;
    },

    addMealWithRecipe(mealId, recipeId){
        return http.post(`/meal/${mealId}/addRecipe/${recipeId}`)
    },

    getMealId(mealName){
        const data = http.get(`/meal/${mealName}/Id`);
        return data;

    },

    addMealPlanName(mealPlan) {
        return http.post('/addMealPlan', mealPlan);
    },

    listRecipesInMeal(mealId) {
        return http.get(`/meal/${mealId}/recipes`);
    },

    getMealIdFromRecipeId(recipeId){
        return http.get(`/mealIds/${recipeId}`);
    }
}