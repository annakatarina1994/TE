<template>
  <div class="meal-plan">
    <table class="table">
      <caption>
        <input v-model="mealPlan.name"
          type="text"
          id="mealPlanName"
          name="mealPlanName"
          placeholder="Enter name for meal plan"
        />
        <button v-on:click="saveMealPlanName()">Save Meal Plan Name</button>
      </caption>
      <thead>
        <tr>
          <th></th>
          <th>Monday</th>
          <th>Tuesday</th>
          <th>Wednesday</th>
          <th>Thursday</th>
          <th>Friday</th>
          <th>Saturday</th>
          <th>Sunday</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th class="breakfast">Breakfast</th>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select v-model="scheduleMondayBreakfast.mealId" id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mondayBreakfast"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                    {{ meal.mealId }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
        </tr>
      </tbody>
      <tbody>
        <th class = "lunch">Lunch</th>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
      </tbody>
      <tbody>
        <th class = "dinner">Dinner</th>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
          <td>
            <div class="dropdown">
              <div class="dropdown-content">
                <select id="meal" name="meal">
                  <option>Add a meal</option>
                  <option
                    value="mealSelected"
                    v-for="meal in allMyMeals"
                    :key="meal.mealId"
                  >
                    {{ meal.name }}
                  </option>
                </select>
              </div>
              <br />
            </div>
          </td>
      </tbody>
    </table>
    <br />
    <button>Add Ingredients To Grocery List</button>
    <button>Clear Meal Plan</button>
    <button v-on:click="saveMealRow()">Save Meal Plan</button>
  </div>
</template>

<script>
import MealService from '../services/MealService';
import mealService from "../services/MealService";

export default {
  data() {
    return {
      allMyMeals: [],
      userId: this.$store.state.user.id,
      scheduleRow: {
        mealPlanId: Number,
        mealId: Number,
        dayOfWeek: "",
        timeOfDay: ""
      },
      mealPlan: {
        name: "",
        userId: this.$store.state.user.id
      },
      scheduleMondayBreakfast: {
        mealPlanId: Number,
        mealId: Number,
        dayOfWeek: "Monday",
        timeOfDay: "Breakfast"
      }
    };
  },
  created() {
    mealService
      .getMyMeals(this.userId)
      .then((response) => {
        this.allMyMeals = response.data;
      })
      .catch((error) => {
        console.error(error + " cannot get my meals");
      });
  },
  methods: {
    saveMealPlanName() {
      MealService.addMealPlanName(this.mealPlan).then((response) => {
        if (response.status === 201) {
          console.log("Meal Plan Saved!");

        }
      })
    }
  },
  saveMealRow() {
    MealService.addMealToPlan(this.scheduleRow).then((response => {
      if (response.status === 200) {
        console.log("Meal added to plan!")
        this.scheduleRow = response.data;
        console.log(this.scheduleMondayBreakfast.mealId);
      }
    }))
  },



};
</script>

<style>
.table {
  margin-left: auto;
  margin-right: auto;
}
</style>