<template>
  <div id="app">
    <product-review />
    <!-- <VueDemo /> -->
  </div>
</template>

<script>
import ProductReview from './components/ProductReview'
// import VueDemo from './components/VueDemo.vue'

export default {
  name: 'App',
  components: {
    // VueDemo,
    ProductReview,
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
