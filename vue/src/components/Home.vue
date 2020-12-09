<template>
  <div>
    <nav-menu></nav-menu>
<!--    <left-menu></left-menu>-->
    <router-view></router-view>
  </div>

</template>

<script>
import NavMenu from './Common/NavMenu'
import LeftMenu from './Common/LeftMenu'
export default {
  name: 'Home',
  components: {NavMenu, LeftMenu}
}
</script>

<style scoped>

</style>
