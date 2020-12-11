<template>
  <div>
    <el-card class="box-card">
      <!-- 问卷标题 -->
      <el-row><div style="text-align: center"><h1>{{surveyTitle}}</h1></div></el-row>
      <!-- 间隔 -->
      <el-row><div class="grid-content"></div></el-row>
      <!-- 问卷的说明 -->
      <el-row><div>
        <el-card style="margin-left: 5%; margin-right: 5%">
          <small>{{instruction}}</small>
        </el-card>
      </div></el-row>
      <!-- 间隔 -->
      <el-row><div class="grid-content"></div></el-row>
      <!-- 具体的问题渲染 -->
      <el-row v-for="form in this.$store.state.forms" :key="form.key">
<!--        <question-->
<!--          v-for="(form, index) in forms" :key="index"-->
<!--          v-bind:dynamic-validate-form="form" class="questionCard"></question>-->
        <simple-question v-if="form.type === 0" class="questionCard"
                         :dynamic-validate-form="form.question"></simple-question>
        <multi-question v-else-if="form.type === 1" class="questionCard"
                        :dynamic-validate-form="form.question"></multi-question>
        <comment-question v-else-if="form.type === 2" class="questionCard"
                          :dynamic-validate-form="form.question"></comment-question>
        <rate-question v-else-if="form.type === 3" class="questionCard"
                       :dynamic-validate-form="form.question"></rate-question>
      </el-row>
      <el-row v-for="(form, index) in this.$store.state.forms" :key="index">
        <span>{{form.type}}</span>
        <span>{{form.question.title}}</span>
        <span>{{form.question.flag}}</span>
        <span>{{form.question.choices[0].value}}</span>
      </el-row>
<!--      <el-button @click="demo(forms)">demo</el-button>-->
    </el-card>
  </div>
</template>

<script>
import SimpleQuestion from './Question/SimpleQuestion'
import MultiQuestion from './Question/MultiQuestion'
import CommentQuestion from './Question/CommentQuestion'
import RateQuestion from './Question/RateQuestion'
export default {
  name: 'Survey',
  components: {SimpleQuestion, MultiQuestion, CommentQuestion, RateQuestion},
  data () {
    return {
      surveyTitle: this.$store.state.surveyTitle,
      instruction: this.$store.state.instruction,
      forms: this.$store.state.forms
    }
  }
}
</script>

<style scoped>
  .box-card{
    margin: auto;
    padding: 25px;
    width: 80%;
    height: 80%;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 24px;
  }
  .questionCard {
    margin: 5%;
  }
</style>
