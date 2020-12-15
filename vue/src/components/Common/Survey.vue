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
          <el-card class="questionCard">
            <el-input type="textarea" v-if="instructionSig"
                      :autosize="{ minRows: 5, maxRows: 10}"
                      placeholder="请输入问卷的说明信息" v-model="instruction">
            </el-input>
            <small v-else>{{instruction}}</small>
            <div v-if="flag" style="text-align: right; width: 90%; margin-top: 10px">
              <el-button>
                <span v-if="instructionSig" @click="trans">确定</span>
                <span v-else @click="trans">编辑</span>
              </el-button>
            </div>
          </el-card>
        </div></el-row>
        <!-- 间隔 -->
        <el-row><div class="grid-content"></div></el-row>
        <!-- 具体的问题渲染 -->
        <el-row>
          <transition-group name="el-fade-in">
            <question v-for="(form, idx) in forms"
                      v-bind:dynamic-validate-form="form"
                      :key="Date.now() + idx"
                      class="questionCard"
                      v-bind:flag="flag"></question>
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
// import Instruction from './CreateInfo'

export default {
  name: 'Survey',
  components: {Question},
  props: ['surveyTitle', 'forms', 'flag'],
  data () {
    return {
      // surveyTitle: this.$store.state.create.surveyTitle,
      // instruction: this.$store.state.create.instruction,
      // forms: this.$store.state.create.forms
      instructionSig: true
    }
  },
  methods: {
    trans () {
      this.instructionSig = !this.instructionSig
    }
  },
  computed: {
    instruction: {
      get () {
        return this.$store.state.create.instruction
      },
      set (value) {
        this.$store.commit('refreshInstruction', value)
      }
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
