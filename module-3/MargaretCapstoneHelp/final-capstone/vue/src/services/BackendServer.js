import axios from 'axios';

const http = axios.create( {
    // baseURL: "https://api.spoonacular.com/recipes"
    baseURL: "http://localhost:8080"
});

export default {
    // searchRecipes(searchTerm) {
    //     return http.get(`/complexSearch?query=${searchTerm}&apiKey=7673afa2c5ea4fe48c062eacd523f588`);
    // },

    // getRandom(){
    //     return http.get('/random?apiKey=7673afa2c5ea4fe48c062eacd523f588');
    // },

    createRecipe(recipe){
        return http.post('/addRecipe', recipe);
    }
}