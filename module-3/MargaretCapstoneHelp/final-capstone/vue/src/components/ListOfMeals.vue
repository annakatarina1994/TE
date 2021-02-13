<template>
  <div>
    <div class="mealInfo" v-for="meal in allMyMeals" :key="meal.mealId">
      <div class="meal">
        <div class="row">Name:</div>
        {{ meal.name }}
        <div class="recipesInMeal" v-for="recipe in recipesInMeal" :key="recipe.recipeId">
          {{ recipe.title }}
        </div>
        <br />
        <br />
        <div class="buttons-my-meals">
          <div class="addToMealPlan">
            <button>Add to Meal Plan</button>
          </div>
          <div class="edit">
            <button>Edit</button>
          </div>
          <div class="delete">
            <button>Delete</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import mealService from "../services/MealService";

export default {
  data() {
    return {
      allMyMeals: [],
      userId: this.$store.state.user.id,
      recipesInMeal: [],
    };
  },
  created() {
    mealService
      .getMyMeals(this.userId)
      .then((response) => {
        this.allMyMeals = response.data;
        this.listRecipesInMeal();
      })
      .catch((error) => {
        console.error(error + " cannot get my meals");
      });
  },
  methods: {
    listRecipesInMeal() {
      this.allMyMeals.forEach((meal) => {
        mealService.listRecipesInMeal(meal.mealId).then((response) => {
          this.recipesInMeal = response.data;
          console.log("RECIPES IN MEAL" + response.data);
        })

    })

    },
  }
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");

.buttons-my-meals {
  font-family: Raleway;
  font-size: x-large;
}

.addToMealPlan {
  margin-left: 46%;
  display: flex;
  font-size: 2vh;
  width: 150px;
  height: 50px;
  text-align: center;
  align-items: center;
  justify-content: center;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
}
.edit {
  margin-left: 46%;
  display: flex;
  font-size: 2vh;
  width: 150px;
  height: 50px;
  text-align: center;
  align-items: center;
  justify-content: center;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
}
.delete {
  margin-left: 46%;
  display: flex;
  font-size: 2vh;
  width: 150px;
  height: 50px;
  text-align: center;
  align-items: center;
  justify-content: center;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
}

.mealInfo {
  font-family: Raleway;
  font-size: 2.5vh;
}
.row {
  font-weight: bold;
}
</style>