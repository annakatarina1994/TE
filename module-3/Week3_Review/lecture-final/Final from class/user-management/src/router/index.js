import Vue from 'vue'
import VueRouter from 'vue-router'
import Users from "../views/Users.vue"
import User from "@/views/User.vue"

Vue.use(VueRouter)

const routes = [
  {
    path: '/users',
    name: 'users',
    component: Users
  },
  {
    path: '/users/:id',
    name: 'user',
    component: User
  }, 
  {
    // if person enters the default path (/), I'm going to 
    // send them to the users path and component (view)
    path: '/',
    redirect:  { name: 'users' }
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
