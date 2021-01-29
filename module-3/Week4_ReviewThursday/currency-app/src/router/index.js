import Vue from 'vue'
import VueRouter from 'vue-router'
import Currency from '../views/Currency.vue'
import History from '../views/History.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/currency',
    name: 'Currency',
    component: Currency
  },
  {
    path: '/history',
    name: 'History',
    component: History
  },
  {
    //if the URL is just /, take us to the currency view
    path: '/',
    redirect: {name: 'Currency'}
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
