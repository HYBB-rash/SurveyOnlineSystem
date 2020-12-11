<template>
  <el-card>
    <!-- 问题编辑时应用的表单 -->
    <el-form v-if="dynamicValidateForm.flag"
             :model="dynamicValidateForm"
             ref="dynamicValidateForm" label-width="100px">
      <!-- 显示选择的题目类型 -->
      <div style="text-align: center; margin: 25px">
        <span>单选题</span>
      </div>
      <!-- 问卷标题 -->
      <el-form-item prop="" label="问题">
        <el-input v-model="dynamicValidateForm.title" style="width: 80%;"></el-input>
      </el-form-item>
      <!-- 当选择的题型为选择题类型时，显示每个需要显示的选项 -->
      <el-form-item v-for="(choice, index) in dynamicValidateForm.choices"
                    :label="'选项' + (index + 1)"
                    :key="choice.key"
                    :prop="'choices.' + index + '.value'">
        <el-input v-model="choice.value" style="width: 80%"></el-input>
        <el-button @click.prevent="removeChoice(choice)">删除</el-button>
      </el-form-item>
      <!-- 编辑完后可以点击完成查看实际的显示效果 -->
      <el-form-item>
        <el-button type="" @click="submitForm('dynamicValidateForm')">提交</el-button>
        <el-button @click="addChoice">新增选项</el-button>
        <el-button @click="resetForm('dynamicValidateForm')">重置</el-button>
      </el-form-item>
    </el-form>
    <!-- 问题编辑成功后查看效果的表单 -->
    <el-form v-else>
      <!-- 题目内容 -->
      <el-row><h4 style="margin-top: 5%; margin-left: 5%">{{dynamicValidateForm.title}}</h4></el-row>
      <el-row><div class="grid-content"></div></el-row>
      <!-- 根据题目类型分类渲染不同的问题选项 -->
      <el-row style="margin-top: 5%; margin-left: 5%;">
        <el-form-item>
          <el-radio-group>
            <el-radio v-for="choice in dynamicValidateForm.choices" v-bind:label="choice.value"
                      :key="choice" style="display: block; margin: 10px">
            </el-radio>
          </el-radio-group>
        </el-form-item>
      </el-row>
    </el-form>
    <!-- 调整用的功能按钮 -->
    <div style="text-align: right; width: 90%">
      <el-button>
        <span v-if="dynamicValidateForm.flag" @click="trans">确定</span>
        <span v-else @click="trans">编辑</span>
      </el-button>
    </div>
  </el-card>
</template>

<script>
export default {
  name: 'SimpleQuestion',
  props: ['form'],
  data () {
    return {
      dynamicValidateForm: {
        title: '如果这是一个多选题，你觉得这个多选题应该怎么改进',
        flag: true,
        context: '',
        rate: null,
        choices: [
          {value: '弄得好看点', ans: []},
          {value: '弄得效率高一点', ans: []},
          {value: '色彩可以弄得丰富一点', ans: []},
          {value: '动画可以考虑弄得好一些', ans: []}
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        console.log(this.dynamicValidateForm.choices[4].value)
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    removeChoice (item) {
      const index = this.dynamicValidateForm.choices.indexOf(item)
      if (index !== -1) {
        this.dynamicValidateForm.choices.splice(index, 1)
      }
    },
    addChoice () {
      this.dynamicValidateForm.choices.push({
        value: '',
        key: Date.now()
      })
    },
    trans () {
      this.dynamicValidateForm.flag = !this.dynamicValidateForm.flag
    }
  },
  watch: {
    data () {
      this.dynamicValidateForm = this.form
    }
  }
}
</script>

<style scoped>

</style>
