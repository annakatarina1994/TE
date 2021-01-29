import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    rateObj: {
      name: '',
      rate: ''
    }
  },
  mutations: {
    SAVE_RATE_INFO(state, payload){
      state.rateObj = payload;
    }
  },
  actions: {
  },
  modules: {
  },
  strict: true
})
