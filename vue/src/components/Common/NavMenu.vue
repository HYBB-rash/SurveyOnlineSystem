<template>

  <el-menu
    :default-active="'/index'"
    router
    mode="horizontal"
    background-color="#FFFFFF"
    text-color="#222"
    active-text-color="red"
    style="min-width: 1300px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)">
    <el-menu-item v-for="(item, i) in navList" :key="i" :index="item.name">
      {{ item.navItem }}
    </el-menu-item>
    <a href="#nowhere" style="color: #222; float: right; padding: 20px;">更多功能</a>
    <i class="el-icon-menu" style="float: right; font-size: 45px; color: #222; padding-top: 8px"></i>
    <span style="position: absolute; padding-top: 20px; right: 43%; font-size: 20px; font-weight: bold">
      在线问卷系统
    </span>
  </el-menu>
</template>

<script>
export default {
  name: 'NavMenu',
  data () {
    return {
      navList: [
        {name: '/login', navItem: '首页'},
        {name: '/index', navItem: '我的问卷'},
        {name: '/profile', navItem: '个人中心'}
      ]
    }
  }
}
</script>

<style scoped>
a{
  text-decoration: none;
}

span{
  pointer-events: none;
}

</style>
