<template>
  <el-container>
    <el-aside>
      <create-left-menu @onEmitType="onEmitType"></create-left-menu>
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
        key: this.$store.state.forms.length,
        type: type,
        question: {
          title: 'ddd',
          flag: true,
          context: '',
          rate: null,
          choices: [
            {value: 'ddd', ans: false},
            {value: 'ddd', ans: false}
          ]
        }
      }
      this.$store.commit({
        type: 'pushQuestion',
        q: ques
      })
      // console.log(this.$store.state.forms[5].type)
    }
  }
}
</script>

<style scoped>

</style>
