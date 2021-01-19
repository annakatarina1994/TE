<template>
  <div class="vue-demo">
    <h2>Products</h2>
    <ul>
      <li v-for="prod in product" v-bind:key="prod.id">{{ prod }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      product: ["Boots", "Socks", "Mittens", "Kitten Mittens"],
    };
  },
};
</script>

<style>
</style>