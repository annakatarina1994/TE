<template>
  <div class="create-meal-plan">
    <h1>Create A New Meal Plan</h1>
    <main-nav />
    <add-new-meal-plan />
  </div>
</template>

<script>
import AddNewMealPlan from "../components/AddNewMealPlan";
import MainNav from '../components/MainNav.vue';

export default {
  components: { AddNewMealPlan,
  MainNav },
};
</script>

<style>
.create-meal-plan{
text-align: center;
align-items: center;

}


</style>