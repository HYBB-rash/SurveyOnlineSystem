export default {
  state: {
    id: null
  },
  mutations: {
    resetStatus (state) {
      state.id = null
    },
    setStatus (state, playLoad) {
      state.id = playLoad.id
    }
  }
}
