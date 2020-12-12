<template>
  <el-container>
    <el-main>
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
        <el-row>
          <transition-group name="el-fade-in">
            <question
              v-for="form in forms" :key="form.key"
              v-bind:dynamic-validate-form="form" class="questionCard"></question>

            <!--            <transition v-for="form in forms" :key="form.key" name="el-fade-in">-->
<!--              <question v-bind:dynamic-validate-form="form" class="questionCard"></question>-->
<!--            </transition>-->
          </transition-group>
        </el-row>
        <!--      <el-button @click="demo(forms)">demo</el-button>-->
      </el-card>
    </el-main>
  </el-container>
</template>

<script>
import Question from './Question'

export default {
  name: 'Survey',
  components: {Question},
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
    /*height: 80%;*/
  }
  .grid-content {
    border-radius: 4px;
    min-height: 24px;
  }
  .questionCard {
    margin: 5%;
  }
</style>
