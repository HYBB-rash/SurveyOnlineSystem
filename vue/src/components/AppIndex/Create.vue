<template>
  <el-container>
    <el-aside>
      <create-left-menu @onEmitType="onEmitType" ref="createLeftMenu"></create-left-menu>
    </el-aside>
    <el-main>
      <survey v-bind:survey-title="this.$store.state.create.surveyTitle"
              v-bind:instruction="this.$store.state.create.instruction"
              v-bind:flag="true"
              v-bind:forms="this.$store.state.create.forms"></survey>
    </el-main>
  </el-container>
</template>

<script>
import CreateLeftMenu from '../Common/CreateLeftMenu'
import Survey from '../Common/Survey'
export default {
  name: 'Create',
  components: {CreateLeftMenu, Survey},
  data () {
    return {
      type: null
    }
  },
  methods: {
    onEmitType (type) {
      // this.forms.push(question)
      // console.log(question.type)
      // this.$store.commit({
      //   type: 'pushQuestion',
      //   class: type
      // })
      const ques = {
        key: Date.now(),
        question: 'ddd',
        type: type,
        ans: -1,
        flag: true,
        context: '',
        rate: null,
        multi: [],
        choices: [
          {value: 'ddd', key: Date.now()},
          {value: 'ddd', key: Date.now() + 1}
        ]
      }
      // this.$set(ques, 'type', type)
      // console.log(this.q.type)
      this.$store.commit({
        type: 'pushQuestion',
        q: ques
      })
      // console.log(this.q.type)
    }
  }
}
</script>

<style scoped>

</style>
