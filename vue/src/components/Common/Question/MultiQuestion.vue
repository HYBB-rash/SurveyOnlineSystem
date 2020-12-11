<template>
  <el-card>
    <!-- 问题编辑时应用的表单 -->
    <el-form v-if="dynamicValidateForm.flag"
             :model="dynamicValidateForm"
             ref="dynamicValidateForm" label-width="100px">
      <!-- 显示选择的题目类型 -->
      <div style="text-align: center; margin: 25px">
        <span>多选题</span>
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
          <el-checkbox-group v-model="dynamicValidateForm.choices">
            <div v-for="(item, index) in dynamicValidateForm.choices" :key="index" >
              <el-checkbox style="display: block;" disabled
                           name="type">{{item.value}}</el-checkbox>
            </div>
          </el-checkbox-group>
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
  name: 'MultiQuestion',
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
