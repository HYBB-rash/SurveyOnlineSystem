import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
export default new Vuex.Store({
  state: {
    surveyTitle: '我的一个测试问卷',
    instruction: '这是一些说明，这是一些说明，这是一些说明，这是一些说明，这是一些说明，',
    forms: [
      {
        key: 1607659615766,
        question: '如果这是一个单选题，你觉得这个单选题做的怎么样？',
        type: 0,
        flag: true,
        context: '',
        rate: null,
        choices: [
          {value: '很好', key: 1607659142948},
          {value: '好', key: 1607659142949},
          {value: '一般', key: 1607659142950},
          {value: '很差', key: 1607659142951}
        ]
      },
      {
        key: 1607659615767,
        question: '如果这是一个多选题，你觉得这个多选题应该怎么改进',
        type: 1,
        flag: true,
        context: '',
        rate: null,
        choices: [
          {value: '弄得好看点', key: 1607659074952},
          {value: '弄得效率高一点', key: 1607659090076},
          {value: '色彩可以弄得丰富一点', key: 1607659099465},
          {value: '动画可以考虑弄得好一些', key: 1607659121665}
        ]
      },
      {
        key: 1607659615768,
        question: '如果这是一个评价题，你会对这个题型做出什么样得评价',
        type: 2,
        flag: true,
        context: '',
        rate: null,
        choices: [
          {value: '', key: 1607659039503}
        ]
      },
      {
        key: 1607659615769,
        question: '如果这是一个评分题，你会对这个题型打多少分',
        type: 3,
        flag: true,
        context: '',
        rate: null,
        choices: [
          {value: '', key: 1607659142951}
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
