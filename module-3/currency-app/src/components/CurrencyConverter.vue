<template>
  <div class="currency-converter">
      <h2>Currency Converter</h2>
      <h3>Convert From USD to {{ $store.state.rateObj.name }}</h3>
      <form class="convertForm">
          <label for="amount">Enter amount to convert: </label>
          <input type="number" id="amount" name="amount" v-model="amountToConvert" />
      </form>
        <h3>${{ convertedAmount }}</h3>
  </div>
</template>

<script>
export default {
    data(){
        return {
            amountToConvert: 0
        }
    },
    computed: {
        convertedAmount(){
            return ((this.amountToConvert * this.$store.state.rateObj.rate).toFixed(2));
        }
    }
}
</script>

<style>

</style>