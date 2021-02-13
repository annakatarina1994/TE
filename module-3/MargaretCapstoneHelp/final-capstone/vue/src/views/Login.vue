<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>
      <div class="text">
        <div>
          <label for="username" class="sr-only">Username</label>
          </div>
        <div>
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
        </div>
      </div>
      <div class="text">
        <div><label for="password" class="sr-only">Password</label></div>
        <div>
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </div>
      </div>

      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button class="sign-in" type="submit">Sign in</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/home");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Raleway&display=swap");
.text{
  margin: 1vh;
}
.form-signin {
  display: flex;
  flex-direction: column;
  text-align: center;
}
#login {
  font-family: Raleway;
}

.sign-in {
  display: flex;
  flex-wrap: wrap;
  margin-top: 5vh;
  margin-left: 45%;
  display: flex;
  width: 200px;
  height: 50px;
  font-size: 2vh;
  background: #f3f0f1;
  margin-bottom: 25px;
  border-radius: 32px;
  text-align: center;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.1s ease-in-out;
  box-shadow: 6px 6px 10px rgba(0, 0, 0, 0.2);
  font-family: Raleway;
  border: none;
}
.sr-only {
  font-size: 3vh;
}
.form-control {
  font-size: 3vh;
}
</style>
