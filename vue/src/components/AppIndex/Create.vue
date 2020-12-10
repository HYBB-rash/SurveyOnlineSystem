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
      q: {
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
      this.$set(this.q, 'type', type)
      console.log(this.q.type)
      this.$store.commit({
        type: 'pushQuestion',
        q: this.q
      })
      console.log(this.q.type)
    }
  }
}
</script>

<style scoped>

</style>
