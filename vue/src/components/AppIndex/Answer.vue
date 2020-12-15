<template>
  <el-container>
    <el-main>
      <survey v-bind:survey-title="$store.state.answer.surveyTitle"
              v-bind:forms="$store.state.answer.forms"
              v-bind:instruction="instruction"
              v-bind:flag="false"
      ></survey>
      <el-button>提交答案</el-button>
    </el-main>
  </el-container>
</template>

<script>
import Survey from '../Common/Survey'
export default {
  name: 'Answer',
  components: {Survey},
  beforeCreate () {
    this.$axios
      .post('/ans', {
        id: this.$route.params.id
      })
      .then(successResponse => {
        if (successResponse.data.code === 200) {
          this.$store.commit({
            type: 'refreshAnsPage',
            forms: successResponse.data.result
          })
        }
      })
  },
  computed: {
    instruction: {
      get () {
        return this.$store.state.answer.instruction
      },
      set (value) {
        this.$store.commit('refreshAnsInstruction', value)
      }
    }
  }
}
</script>

<style scoped>
  .surveyDisplay {
    width: 80%;
  }
</style>
