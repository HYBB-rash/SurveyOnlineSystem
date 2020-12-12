<template>
  <el-container>
    <el-main>
      <survey v-bind:survey-title="$store.state.answer.surveyTitle"
              v-bind:instruction="$store.state.answer.instruction"
              v-bind:forms="$store.state.answer.forms"
              v-bind:flag="false"
      ></survey>
    </el-main>
  </el-container>
</template>

<script>
import Survey from '../Common/Survey'
export default {
  name: 'Answer',
  components: {Survey}
}
</script>

<style scoped>
  .surveyDisplay {
    width: 80%;
  }
</style>
