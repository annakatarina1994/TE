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
        <tr>
          <td>1</td>
          <td>Bob Smith</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import UserService from "../services/UserService";

export default {
  name: "users",
  data() {
    return {
      // want our API to load JSON's into this array
      users: [],
    };
  },
  methods: {
      // calls userservice method which calls the API
      // returns a JSON array and loads it into our array called users
    getUsers() {
      UserService.list().then(users => this.users = users);
    },
  },
  // this section created() runs when this component is created
  created(){
      this.getUsers();
  }
};
</script>
    
<style>
.userList {
  display: flex;
  justify-content: center;
}
td,
th {
  padding: 6px;
  margin: 0;
}
tr:nth-child(even) {
  background-color: rgb(216, 216, 216);
}
a,
a:hover,
a:visited {
  color: blue;
  text-decoration: none;
  text-transform: uppercase;
}
</style>