export default {
  state: {
    id: null,
    address: 'http://localhost:8080/ans/',
    user: {
      username: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).username
    }
  },
  mutations: {
    resetStatus (state) {
      state.id = null
    },
    setStatus (state, playLoad) {
      state.id = playLoad.id
    },
    login (state, user) {
      state.user = user
      window.localStorage.setItem('user', JSON.stringify(user))
    },
    logout (state) {
      state.user = []
      window.localStorage.removeItem('user')
    }
  }
}
