import Vue from 'vue'
import Vuex from 'vuex'

import createStore from './common/create.js'
import surveyStore from './common/survey.js'
import answerStore from './common/answer.js'
import profileStore from './common/profile.js'
import userStore from './common/user.js'

Vue.use(Vuex)
export default new Vuex.Store({
  modules: {
    create: createStore,
    survey: surveyStore,
    answer: answerStore,
    profile: profileStore,
    user: userStore
  }
})
