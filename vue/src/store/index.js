import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
export default new Vuex.Store({
  state: {
    surveyTitle: '我的一个测试问卷',
    instruction: '这是一些说明，这是一些说明，这是一些说明，这是一些说明，这是一些说明，',
    forms: [
      {
        question: '如果这是一个单选题，你觉得这个单选题做的怎么样？',
        type: 0,
        flag: true,
        context: '',
        rate: null,
        choices: [
          {value: '很好', ans: false},
          {value: '好', ans: false},
          {value: '一般', ans: false},
          {value: '很差', ans: false}
        ]
      },
      {
        question: '如果这是一个多选题，你觉得这个多选题应该怎么改进',
        type: 1,
        flag: true,
        context: '',
        rate: null,
        choices: [
          {value: '弄得好看点', ans: []},
          {value: '弄得效率高一点', ans: []},
          {value: '色彩可以弄得丰富一点', ans: []},
          {value: '动画可以考虑弄得好一些', ans: []}
        ]
      },
      {
        question: '如果这是一个评价题，你会对这个题型做出什么样得评价',
        type: 2,
        flag: true,
        context: '',
        rate: null,
        choices: [
          {value: '', ans: false}
        ]
      },
      {
        question: '如果这是一个评分题，你会对这个题型打多少分',
        type: 3,
        flag: true,
        context: '',
        rate: null,
        choices: [
          {value: ''}
        ]
      }
    ]
  },
  mutations: {
    pushQuestion (state, playload) {
      state.forms.push(playload.q)
    },
    addQuestion (state, playload) {
      state.forms.push(playload.forms)
    }
  }
})
