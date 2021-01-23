import Vue from 'vue'
import VueRouter from 'vue-router'
import Users from '../views/Users.vue'
import User from '../views/User.vue'

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
    // if the client enters the default path, it'll automatically take them to /users
    path: '/',
    redirect: {name: 'users'}
  }
]

const router = new VueRouter({
  routes
})

export default router
