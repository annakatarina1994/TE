<template>
  <div class="landing-page">
    <h1>Meal Planner</h1>
    <div class="landingButtons">
      <div class="buttons">
        <router-link :to="{ name: 'login' }">Log In</router-link>
      </div>
      <div class="buttons">
        <router-link :to="{ name: 'register' }">Register</router-link>
      </div>
    </div>
    <div
      class="image"
      v-if="image"
      style="width: 100%; height: 37.5rem"
      :style="{ 'background-image': 'url(' + image + ')' }"
    ></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      image:
        "https://feast2thebeat.com/wp-content/uploads/2016/06/fttb-bg-food.jpg",
    };
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap");

button {
  /* font-size: 3vh; */
  border: none;
}

.landingButtons{
  display:flex;
  justify-content: center;
}

.buttons {
  margin: 50px;
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
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
}
.buttons:hover{
  background-color: #ffffff;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
}

button:hover {
  background: rgba(184, 183, 183, 0.39);
}

body {
  background-color: rgb(223, 223, 223);
}
.landing-page {
  text-align: center;
  /* background-color:  rgb(229, 212, 194); */
}
.landing-page .image {
  background-repeat: no-repeat;
  background-size: cover;
  opacity: 75%;
  box-shadow: 0px 75px 50px 0 rgb(209, 209, 209) inset,
    0px 0px 50px 0 rgb(209, 209, 209) inset;
}
h1 {
  font-family: montserrat;
  font-size: 5rem;
  text-shadow: 4px 4px #ffffff;
}
</style>