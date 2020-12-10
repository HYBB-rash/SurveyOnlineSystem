<template>
  <el-container>
    <el-aside style="margin-top: 20px">
      <left-menu @indexSelect='surveyIndex' ref="leftMenu"></left-menu>
    </el-aside>
    <el-main>
      <el-row>
        <h3>问卷列表</h3>
      </el-row>
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
      cards: [
        {
          id: '456782143',
          title: '我的一个测试问卷',
          status: 0,
          date: '2011-11-20',
          cnt: 10
        },
        {
          id: '456723143',
          title: '我的一个测试问卷',
          status: 1,
          date: '2011-11-22',
          cnt: 100
        },
        {
          id: '456723143',
          title: '我的一个测试问卷',
          status: -1,
          date: '2011-11-22',
          cnt: 100
        }
      ],
      show: 1
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
