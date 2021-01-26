<template>
  <div class="userProfile">
    <p>{{ user }}</p>
  </div>
</template>

<script>
import userService from "@/services/UserService";
export default {
  name: "user-profile",
  data() {
    return {
      user: null,
    };
  },
  methods: {
    getUser(id) {
      userService.get(id).then((user) => (this.user = user));
    },
  },
  created() {
    //   console.log(this.$route);
    this.getUser(this.$route.params.id);  //this.$route gives us access to the parameter in URL
  },
};
</script>

<style>
</style>