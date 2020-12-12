<template>
  <el-container>
    <el-aside style="margin-top: 20px">
      <left-menu @indexSelect='surveyIndex' ref="leftMenu"></left-menu>
    </el-aside>
    <el-main>
      <el-row>
        <h3>问卷列表</h3>
      </el-row>
      <!-- 渲染已经存在的了的问卷的信息 -->
      <el-row v-for="card in cards" :key="card">
        <survey-card v-bind:card="card"></survey-card>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
import NavMenu from '../Common/NavMenu'
import LeftMenu from '../Common/LeftMenu'
import SurveyCard from '../Common/SurveyCard'
export default {
  name: 'Index',
  components: {NavMenu, LeftMenu, SurveyCard},
  data () {
    return {
      cards: this.$store.state.survey.surveyMessage
    }
  },
  methods: {
    surveyIndex () {
    }
  }
}
</script>

<style scoped>

</style>
