<template>
  <div class="currency-list">
    <h2>Currency List</h2>
    <table>
      <thead>
        <tr>
          <th></th>
          <th>Currency ID</th>
          <th>Rate</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(value, name) in rates" v-bind:key="name">
          <input
            type="checkbox"
            v-bind:name="name"
            v-bind:value="value"
            v-on:change="saveRateInfo($event)"
          />
          <td>{{ name }}</td>
          <td>{{ value }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import CurrencyService from "../services/CurrencyService";

export default {
  name: "currency-list",
  data() {
    return {
      rates: [],
      oneToConvert: {}
    };
  },
  methods: {
    getCurrencyRates() {
      CurrencyService.listCurrency().then((response) => {
        this.rates = response.data.rates;
      });
    },
    saveRateInfo(event){
        if (event.target.checked){
            this.oneToConvert = {
                name: event.target.name,
                rate: event.target.value // value from above saved as rate
            };
            this.$store.commit("SAVE_RATE_INFO", this.oneToConvert);
        }
    }
  },
  created() {
    this.getCurrencyRates();
  },
};
</script>

<style>
</style>