<template>
  <div>
    <el-card class="box-card" shadow="hover"
             style="box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); margin: 15px" >
      <div slot="header" class="clearfix">
        <el-row>
          <el-col :span="6"><div class="grid-content"><span style="text-align: left" :key='card.title'>{{ card.title }}</span></div></el-col>
          <el-col :span="9"><div class="grid-content"></div></el-col>
          <el-col :span="3">
            <div class="grid-content" style="text-align: center" :key='card.id'>
              <small>ID:{{ card.id }}</small>
            </div>
          </el-col>
          <el-col :span="2">
            <div class="grid-content" style="text-align: center" :key='card.status'>
              <small v-if="card.status === 1" style="color: #409EFF">●已发布</small>
              <small v-else-if="card.status === 0" style="color: #F56C6C">●已结束</small>
              <small v-else-if="card.status === -1" style="color: #909399">●已删除</small>
            </div>
          </el-col>
          <el-col :span="2">
            <div class="grid-content" style="text-align: center" :key='card.cnt'>
              <small>答题卷:{{card.cnt}}</small>
            </div>
          </el-col>
          <el-col :span="2">
            <div class="grid-content" style="text-align: right" :key='card.date'>
              <small>{{card.date}}</small>
            </div>
          </el-col>
        </el-row>

<!--        <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>-->
      </div>
      <div>
        <el-row>
          <el-col :span="8"><div class="grid-content"></div></el-col>
          <el-col :span="4"><div class="toRight">
            <el-button style="box-shadow: 0 1px 6px 0 rgba(0, 0, 0, 0.1)">
              <i class="el-icon-edit" style="color: #67C23A"></i>编辑问卷</el-button>
          </div></el-col>
          <el-col :span="4"><div class="toRight">
            <el-button style="box-shadow: 0 1px 6px 0 rgba(0, 0, 0, 0.1)">
              <i class="el-icon-document" style="color: #409EFF"></i>发送问卷</el-button>
          </div></el-col>
          <el-col :span="4"><div class="toRight">
            <el-button style="box-shadow: 0 1px 6px 0 rgba(0, 0, 0, 0.1)">
              <i class="el-icon-cpu" style="color: #E6A23C"></i>分析&下载</el-button>
          </div></el-col>
          <el-col :span="4"><div class="toRight">
            <el-button style="box-shadow: 0 1px 6px 0 rgba(0, 0, 0, 0.1)">
              <i class="el-icon-circle-close" style="color: #F56C6C"></i>停止问卷</el-button>
          </div></el-col>
        </el-row>
      </div>
    </el-card>
  </div>

</template>

<script>
export default {
  name: 'SurveyCard',
  props: ['card'],
  data () {
    return {
    }
  }
}
</script>

<style>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 960px;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 12px;
  }
  .toRight{
    text-align: right;
  }
</style>
