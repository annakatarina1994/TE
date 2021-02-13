<template>
  <div class="recipe-details">
    <h1>Recipe Details</h1>
    <main-nav />
    <br /><br />
    <button v-on:click.prevent="saveRecipe()">Save</button>
    <div class="more-recipe-details">
      <div>
        <h2>
          {{ recipe.title }}
          <br />
        </h2>
        <img v-bind:src="recipe.image" />
      </div>
      <br />
      <div
        class="ingredients"
        v-for="ingredient in ingredients"
        v-bind:key="ingredient.name"
      >
        <p>
          {{ ingredient.amount.us.value.toFixed(2) }}
          {{ ingredient.amount.us.unit }} - {{ ingredient.name }}
        </p>
      </div>
      <div id="recipe-instructions"></div>
    </div>
  </div>
</template>

<script>
import apiService from "../services/ApiService";
import MainNav from "./MainNav.vue";
import RecipeService from "../services/RecipeService";

export default {
  components: { MainNav },
  props: {
    searchTerm: String,
    id: Number,
  },
  data() {
    return {
      ingredients: [],
      recipe: {
        userId: this.$store.state.user.id,
      },
      ingredient: {
        userId: this.$store.state.user.id,
        name: "",
        isOnGroceryList: false,
        recipeId: 0,
        apiRecipeId: this.$route.params.id,
        quantity: 0,
        measurement: "",
      },
    };
  },
  methods: {
    saveRecipe() {
      console.log("saving recipe");
      this.recipe.userId = this.$store.state.user.id;
      console.log(this.recipe.userId);

      RecipeService.createRecipe(this.recipe)
        .then((response) => {
          if (response.status === 201) {
            console.log("recipe created!");
            alert("Your recipe has been added!");
          }
        })
        .then(
          setTimeout(() => {
            RecipeService.getRecipeId(this.recipe.title).then((response) => {
              if (response.status === 200) {
                // this.ingredients.forEach((portion) => {
                //   console.log("PORTION" + portion.name);
                //   this.ingredient.name = portion.name;
                //   this.ingredient.quantity = Number.parseInt(
                //     portion.amount.us.value.toFixed(2)
                //   );
                console.log("got recipe - ingredient:" + this.ingredients);
                const ingredientBody = {
                  ingredients: this.ingredients,
                  userId: this.$store.state.user.id,
                };

                RecipeService.saveIngredients(
                  response.data,
                  ingredientBody
                ).then((response) => {
                  if (response.status === 201) {
                    console.log("Ingredients saved");
                  }
                });
                // });
              }
            });
          }, 2000)
        );
    },
    // saveIngredients() {

    // },
  },

  created() {
    console.log("RECIPE ID" + " " + this.$route.params.id);
    apiService.getRecipeInfo(this.$route.params.id).then((response) => {
      if (response.status === 200) {
        console.log(response.data);
        this.recipe = response.data;
        document.getElementById(
          "recipe-instructions"
        ).innerHTML = this.recipe.instructions;
      }
    });
    apiService.getIngredients(this.$route.params.id).then((response) => {
      if (response.status === 200) {
        console.log(response.data);
        this.ingredients = response.data.ingredients;
      }
    });
  },
};
</script>

<style>
#recipe-instructions {
  text-align: left;
}
.recipe-details {
  text-align: center;
}
.ingredients {
  font-size: 2vh;
}
</style>