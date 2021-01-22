<template>
  <div class="userList">
      <table>
          <thead>
              <tr>
                  <th>ID</th>
                  <th>Name</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="user in users" v-bind:key="user.id">
                  <!--  router link functions like an anchor and href -->
                  <td><router-link :to="{ // send an object to the router-link
                       name: 'user',   //with name
                       params: {       // and a params object
                           id: user.id  // that has an id key with user.id as the value
                           }
                       }">
                       {{ user.id }} </router-link>
                       </td>
                  <td>{{ user.name }}</td>
              </tr>
          </tbody>
      </table>
  </div>
</template>

<script>
import userService from '@/services/UserService';
export default {
    name: 'users',
    data() {
        return {
            users: []  // want our API to load the JSON array into this array
        }
    },
    methods: {
        getUsers() {
            //calls the userService method, which calls the API
            // returns a JSON array and loads it into our array called users
            userService.list().then(users => this.users = users);
        }
    },
    // this section created() runs when this component IS created!
    created() {
        this.getUsers();
    }

}
</script>

<style scoped>
.userList {
    display: flex;
    justify-content: center;
}
td, th {
  padding:6px;
  margin:0;
}
tr:nth-child(even) {
  background-color: rgb(216, 216, 216);
}
a, a:hover, a:visited {
  color:blue;
  text-decoration:none;
  text-transform: uppercase;
}

</style>