<template>
  <div class="currency">
    <h1>Currencies</h1>
    <div class="sectionContainer">
      <currency-list />
      <currency-converter />
    </div>
  </div>
</template>

<script>
import CurrencyList from "../components/CurrencyList";
import CurrencyConverter from "../components/CurrencyConverter";

export default {
  name: "Currency",
  components: {
    CurrencyList,
    CurrencyConverter,
  },
};
</script>

<style>
.sectionContainer {
  display: flex;
  justify-content: space-evenly;
}
</style>