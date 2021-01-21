import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    todos: [
      { name: 'Morning yoga', done: false, category: 'Home' },
      { name: 'Breakfast', done: false, category: 'Home' },
      { name: 'Shower', done: false, category: 'Home' },
      { name: 'Take out trash', done: false, category: 'Home' },
      { name: 'Walk the dogs', done: false, category: 'Home' },
      { name: 'Answer email', done: false, category: 'Work' },
      { name: 'Stand up meeting', done: false, category: 'Work' },
      { name: 'Fix a bug', done: false, category: 'Work' },
    ]
  },
  mutations: {
    ADD_NEW_TODO(state, todo){
      state.todos.push(todo);
    },
    FLIP_DONE(state, todo){
      todo.done = ! todo.done;
    }
    },
  actions: {
  },
  modules: {
  },
  strict: true
})
