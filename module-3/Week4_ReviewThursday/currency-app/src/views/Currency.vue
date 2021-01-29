<template>
  <div class="currency">
    <h1>Currencies</h1>
    <div class="flexbox">
      <currency-list />
      <currency-converter />
    </div>
  </div>
</template>

<script>
import CurrencyList from "../components/CurrencyList.vue";
import CurrencyConverter from "@/components/CurrencyConverter.vue";

export default {
  name: "Currency",
  components: {
    CurrencyList,
    CurrencyConverter,
  },
};
</script>

<style>
.flexbox {
  display: flex;
  justify-content: space-evenly;
  /* align-items: flex-start; */
}
</style>
