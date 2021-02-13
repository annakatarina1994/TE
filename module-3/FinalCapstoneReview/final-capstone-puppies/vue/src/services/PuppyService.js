import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080/api"
});

export default {
    list() {
        return http.get('/allPuppies');
    },

  get(id) {
    return http.get(`/puppy/${id}`);
  },

  // add a puppy to endpoint /newPuppy
  create(puppy) {
    return http.post('/newPuppy', puppy);
  },

  // update a puppy to endpoint /editPuppy
  update(puppy) {
    return http.put('/editPuppy', puppy);
  },

  // delete a puppy to endpoint /removePuppy/id
  delete(id) {
    return http.delete(`/removePuppy/${id}`);
  }
}
