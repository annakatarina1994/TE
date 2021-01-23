/**
 * Service class to extract the functionality of list and getting users.
 */
export default {

    listCurrency() {
      return fetch('https://api.exchangeratesapi.io/latest?base=USD')
      .then((response) => {
        return response.json();
      });
    },
  
    getCurrency(currencyId) {
      return fetch(`https://api.exchangeratesapi.io/latest?base=USD&symbols=${currencyId}`)
      .then((response) => {
        return response.json();
      });
    }
  
  }