<template>
  <el-container>
    <el-aside>
      <create-left-menu @onEmitType="onEmitType" ref="createLeftMenu"></create-left-menu>
    </el-aside>
    <el-main>
      <survey></survey>
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
        type: 0,
        flag: true,
        context: '',
        rate: null,
        choices: [
          {value: 'ddd', ans: false},
          {value: 'ddd', ans: false}
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
