<template>
  <div class="links">
    <div class="mainNav">
      <router-link :to="{ name: 'mealPlans' }">My Meal Plans</router-link>
    </div>
    &nbsp;&nbsp;
    <div class="mainNav">
      <router-link :to="{ name: 'myMeals' }">My Meals</router-link>
    </div>
    &nbsp;&nbsp;
    <div class="mainNav">
      <router-link :to="{ name: 'createNewMeal' }">Create New Meal</router-link>
    </div>
    &nbsp;&nbsp;
    <div class="mainNav">
      <router-link :to="{ name: 'newMealPlans' }">Create New Meal Plans</router-link>
    </div>
    &nbsp;&nbsp;
    <div class="mainNav">
      <router-link :to="{ name: 'myRecipes' }">My Recipes</router-link>
    </div>
    &nbsp;&nbsp;
    <div class="mainNav">
      <router-link :to="{ name: 'browseRecipes' }">Browse Recipes</router-link>
    </div>
    &nbsp;&nbsp;
    <div class="mainNav">
      <router-link :to="{ name: 'addRecipe' }">Add Recipe</router-link>
    </div>
    &nbsp;&nbsp;
    <div class="mainNav">
      <router-link :to="{ name: 'groceryList' }">Grocery List</router-link>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Raleway&display=swap');

.links {
  display: flex;
  justify-content: center;
}

.mainNav {
  display: flex;
  width: 200px;
  height: 50px;
  font-size: 2vh;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  text-align: center;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow:  6px 6px 10px rgba(0, 0, 0, 0.2);
}
.mainNav:hover{
  background-color: #ffffff;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
}

a{
  text-decoration: none;
  color: black;
  font-family: Raleway, Verdana, Geneva, Tahoma, sans-serif;
}

</style>