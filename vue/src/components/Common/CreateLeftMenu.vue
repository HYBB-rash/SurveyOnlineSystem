<template>
  <div>
<!--    <el-button class="create-button" type="primary" @click="open" round>创建问卷</el-button>-->
    <el-menu
      collapse-transition
      class="choices"
      default-active="0"
      @select="handleSelect"
      active-text-color="red"
      style="box-shadow: 0 1px 4px 0 rgba(0, 0, 0, 0.1)">
      <el-menu-item index="0">
        <i class="el-icon-question"></i>
        <span slot="title">单选题</span>
      </el-menu-item>
      <el-menu-item index="1">
        <i class="el-icon-check"></i>
        <span slot="title">多选题</span>
      </el-menu-item>
      <el-menu-item index="2">
        <i class="el-icon-star-on"></i>
        <span slot="title">评价题</span>
      </el-menu-item>
      <el-menu-item index="2">
        <i class="el-icon-s-data"></i>
        <span slot="title">评分题</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'CreateLeftMenu',
  data () {
    return {
      show: 0
    }
  },
  methods: {
    handleSelect (key) {
      this.$emit('onEmitType', key)
    },
    open () {
      this.$prompt('请输入问卷标题', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '？？？'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        })
      })
    }
  }
}
</script>

<style scoped>
.choices {
  position: fixed;
  margin-left: 50%;
  left: -650px;
  top: 100px;
  width: 250px;
}
</style>
