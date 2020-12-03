<template>
  <boby id="paper">
    <el-form class="login-container" label-width="0px"
             status-icon :rules="rules"
             label-position="left" :model="loginForm">
      <h3 class="login_title">系统登陆</h3>
      <el-form-item prop="username">
        <el-input type="text" v-model="loginForm.username"
                  autocomplete="off" aria-placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="loginForm.password"
                  autocomplete="off" aria-placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" class="login_button"
                   v-on:click="login">登录</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="warning" class="login_button" v-on:click="register">注册</el-button>
      </el-form-item>
    </el-form>
  </boby>
</template>

<script>
export default {
  name: 'Login',
  data () {
    const checkUsername = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('请输入用户名'))
      }
    }
    const checkPassword = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('请输入密码'))
      }
    }
    return {
      loginForm: {
        username: '',
        password: ''
      },
      rules: {
        username: [{validator: checkUsername, trigger: 'blur'}],
        password: [{validator: checkPassword, trigger: 'blur'}]
      }
    }
  },
  methods: {
    login () {
      if (this.loginForm.username === 'admin') {
        if (this.loginForm.password === '123') {
          this.$router.replace({path: '/'})
        }
      }
    },
    register () {
      this.$router.replace({path: '/register'})
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
