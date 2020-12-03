<template>
  <boby id="paper">
    <el-form class="login-container" label-width="80px"
             status-icon :rules="rules"
             label-position="top" :model="registerForm">
      <h3 class="login_title">系统注册</h3>
      <el-form-item prop="username" label="用户名">
        <el-input type="text" v-model="registerForm.username"
                  autocomplete="off" aria-placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item prop="password" label="密码">
        <el-input type="password" v-model="registerForm.password"
                  autocomplete="off" aria-placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item prop="invite" label="邀请码">
        <el-input type="text" v-model="registerForm.invite"
                  autocomplete="off" aria-placeholder="邀请码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" class="login_button"
                   v-on:click="register">注册</el-button>
      </el-form-item>
    </el-form>
  </boby>
</template>

<script>
export default {
  name: 'Register',
  data () {
    const checkUsername = (rule, value, callback) => {
      if (!value) return callback(new Error('请输入你的用户名'))
    }
    const checkPassword = (rule, value, callback) => {
      if (!value) return callback(new Error('请输入你的密码'))
    }
    const checkInvite = (rule, value, callback) => {

    }
    return {
      registerForm: {
        username: '',
        password: '',
        invite: ''
      },
      rules: {
        username: [{validator: checkUsername, trigger: 'blur'}],
        password: [{validator: checkPassword, trigger: 'blur'}],
        invite: [{validator: checkInvite, trigger: 'blur'}]
      }
    }
  },
  methods: {
    register () {
      this.$router.replace({path: '/'})
    }
  }
}
</script>

<style scoped>
  #paper {
    background:url("../../assets/eva1.jpg") repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
  }
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }
  .login_button {
    width: 100%;
    border: none;
  }
</style>
