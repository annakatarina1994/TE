import axios from 'axios';

const http = axios.create( {
    baseURL: "https://api.exchangeratesapi.io"
});

export default {
    listCurrency(){
        return http.get("/latest?base=USD");
    }
}