n<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- <vue-demo /> -->
    <product-review />
  </div>
</template>

<script>
import ProductReview from './components/ProductReview.vue'
// import VueDemo from './components/VueDemo.vue'

export default {
  name: 'App',
  components: {
    // VueDemo,
    ProductReview
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
