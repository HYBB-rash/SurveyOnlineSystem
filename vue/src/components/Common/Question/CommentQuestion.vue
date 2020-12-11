<template>
  <el-card>
    <!-- 问题编辑时应用的表单 -->
    <el-form v-if="dynamicValidateForm.flag"
             :model="dynamicValidateForm"
             ref="dynamicValidateForm" label-width="100px">
      <!-- 显示选择的题目类型 -->
      <div style="text-align: center; margin: 25px">
        <span>评价题</span>
      </div>
      <!-- 问卷标题 -->
      <el-form-item prop="" label="问题">
        <el-input v-model="dynamicValidateForm.title" style="width: 80%;"></el-input>
      </el-form-item>
      <!-- 编辑完后可以点击完成查看实际的显示效果 -->
      <el-form-item>
        <el-button type="" @click="submitForm('dynamicValidateForm')">提交</el-button>
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
          <el-input type="textarea" :autosize="{ minRows: 10, maxRows: 40}"
                    placeholder="请输入你的答案" v-model="dynamicValidateForm.context">
          </el-input>
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
  name: 'CommentQuestion',
  props: ['dynamicValidateForm'],
  data () {
    return {
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
  }
}
</script>

<style scoped>

</style>
