<template>
  <div>
    <nav-menu></nav-menu>
    <router-view></router-view>
  </div>

</template>

<script>
import NavMenu from './Common/NavMenu'
export default {
  name: 'Home',
  components: {NavMenu}
}
</script>

<style scoped>

</style>
