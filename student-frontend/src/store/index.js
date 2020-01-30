import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
  students:[]
}

const actions = {}

const mutations = {
  setStudents(state,students){
    state.students =students
  }
}

const getters = {}

export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters
})
