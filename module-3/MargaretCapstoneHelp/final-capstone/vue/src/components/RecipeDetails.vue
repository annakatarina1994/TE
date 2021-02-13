<template>
  <div class="recipe-details">
    <h1>Recipe Details</h1>
    <main-nav />
    <h3 class="recipeName">{{ recipe.title }}</h3>
    <p class="ingredients"></p>
    <p class="instructions" id="recipe-instructions">
      {{ recipe.instructions }}
    </p>
    <button
      id="edit-btn"
      v-if="showForm === false"
      v-on:click.prevent="showForm = true"
    >
      Edit
    </button>
    <form v-if="showForm === true">
      <div>
        <label for="name">Name: </label>
        <input
          type="text"
          placeholder="Enter new name"
          v-model="recipe.title"
        />
      </div>
      <div>
        <label for="instructions"> Instructions: </label>
        <textarea
          id="instructions"
          v-model="recipe.instructions"
          rows="8"
          cols="40"
        ></textarea>
      </div>
      <input type="submit" value="Save" v-on:click="updateRecipe" />
      <input type="button" value="Cancel" v-on:click.prevent="resetForm" />
    </form>
    <br />
    <button v-on:click="deleteRecipe">Delete Recipe</button>
  </div>
</template>

<script>
import RecipeService from "../services/RecipeService";
import mealService from "../services/MealService";
import MainNav from "./MainNav.vue";

export default {
  components: { MainNav },
  props: {
    recipeId: Number,
  },

  data() {
    return {
      recipe: {},
      showForm: false,
      mealIds: [],
    };
  },
  created() {
    console.log("RECIPE ID" + " " + this.$route.params.id);
    RecipeService.getOneRecipe(this.$route.params.id).then((response) => {
      this.recipe = response.data;
      document.getElementById(
        "recipe-instructions"
      ).innerHTML = this.recipe.instructions;
    });
  },
  methods: {
    updateRecipe() {
      console.log("update recipe");
      const newRecipe = {
        userId: this.$store.state.user.id,
        recipeId: this.$route.params.id,
        title: this.recipe.title,
        instructions: this.recipe.instructions,
      };
      console.log(newRecipe.id);
      RecipeService.editRecipe(newRecipe)
        .then((response) => {
          if (response.status === 202) {
            alert("Recipe has been updated!");
          }
        })
        .catch((error) => {
          console.error(error + " problem updating recipe.");
        });
    },
    resetForm() {
      this.showForm = false;
      this.newRecipe = {};
    },
    deleteRecipe() {
      mealService
        .getMealIdFromRecipeId(this.$route.params.id)
        .then((response) => {
          if (response.status === 200) {
            for (let i = 0; i < response.data.length; i++) {
              this.mealIds.push(response.data[i].mealId);
            }
            console.log("Meal ID array: " + this.mealIds);

            if (this.mealIds.length > 0) {
              console.log(
                "Right before for loop. MealId's array length: " +
                  this.mealIds.length
              );
              for (let j = 0; j < this.mealIds.length; j++) {
                console.log("In the for loop: " + this.mealIds[j]);
                RecipeService.deleteRecipeFromMeal(
                  this.mealIds[j],
                  this.$route.params.id
                ).then((response) => {
                  if (response.status === 200) {
                    console.log("Recipes deleted from meals!");
                    RecipeService.deleteIngredientsFromRecipe(
                      this.$route.params.id
                    ).then((response) => {
                      if (response.status === 200) {
                        console.log(
                          "Ingredients deleted from ingredients table."
                        );

                        RecipeService.deleteRecipe(this.$route.params.id)
                          .then((response) => {
                            if (response.status === 200) {
                              alert("This recipe has been deleted.");
                              this.$router.push("/myRecipes");
                            }
                          })
                          .catch((error) => {
                            console.error(
                              error + " not able to delete recipe."
                            );

                            
                          });
                      }
                    });
                  }
                });
              }
            } else if (this.mealIds.length === 0) {
              RecipeService.deleteIngredientsFromRecipe(
                this.$route.params.id
              ).then((response) => {
                if (response.status === 200) {
                  RecipeService.deleteRecipe(this.$route.params.id)
                    .then((response) => {
                      if (response.status === 200) {
                        alert("This recipe has been deleted.");
                        this.$router.push("/myRecipes");
                      }
                    })
                    .catch((error) => {
                      console.error(error + " not able to delete recipe.");
                    });
                }
              });
            }
          }
        });
    },
  },
};
</script>

<style>
.recipe-details {
  text-align: center;
}
</style>