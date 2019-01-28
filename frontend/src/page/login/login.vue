<template>
  <div class="bg-login">
    <div class="login-header container">
    </div>
      <div class="middle-box loginscreen bg-white container">
            <div class="login-top"></div>
            <div class="login-title text-center">
                <h1>用户登录</h1>
            </div>
            <el-form inline-message :model="loginForm" :rules="loginRules" ref="loginForm">
                <el-form-item prop="username">
                    <el-input status-icon prefix-icon="fa fa-user" v-model="loginForm.username" placeholder="请输入用户名" ></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input prefix-icon="fa fa-lock" :type="passwordType" @keyup.enter.native="doLogin"
                        v-model="loginForm.password" placeholder="请输入密码" auto-complete="on">
                    </el-input>
                    <span class="show-pwd" :style="eyeStatus" @click="showPwd"><i class="icon iconfont icon-eye"></i></span>
                </el-form-item>
                <el-form-item label="">
                    <el-button type="primary" :loading="loading" @click.native.prevent="doLogin">登录</el-button>
                </el-form-item>
            </el-form>
      </div>
  </div>
</template>
<script>
export default {
  name:'login',
  data() {
      return {
            loginForm:{
                username:'',
                password:''
            },
            loginRules:{
                username:[{require:true, message:'用户名不能为空',trigger:'blur'},{min:5, max:20, message:'长度在 5 到 20 个字符', trigger: 'blur'}],
                password:[{require:true,trigger:'blur'},{min:6,message:'密码长度必须6位以上',trigger:'blur'}]
            },
            loading:false,
            passwordType:'password',
            eyeStatus:''
      }
  },
  methods: {
        showPwd() {
            if (this.passwordType === 'password') {
                this.passwordType = ''
                this.eyeStatus = 'color:#1296db'
            } else {
                this.passwordType = 'password'
                this.eyeStatus = ''
            }
        },
        doLogin() {
			 this.$router.push({ path: "home" });
            // this.$refs.loginForm.validate(valid => {
            //     if (valid){
            //         this.loading = true
            //     } else{
            //         return false
            //     }
            // })
        }
  }
}
</script>
<style lang="scss" >
$dark_gray:#889aa4;
body{
    background: rgb(236, 231, 231);
    background-size: cover;
}
.container {
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
}
.bg-white{
    background-color: #ffffff;
    opacity: 0.8;
}
.middle-box{
    max-width: 400px;
    z-index: 100;
    margin: 0 auto;
    padding-bottom: 10px;
}
.loginscreen .middle-box{
    width: 300px;
}
.login-top{
    background-color: #3b3127;
    height: 6px;
}
.login-title{
    height:130px;
    padding:30px;
    font-weight:bold;
}
.login-header{
    height:265px;
}
.login-logo{
    margin-top:40px;
}
.login-logo-zh,
.login-logo-en{
    font-weight:bold;
    color:#3b3127;
}
.login-logo-zh{
    font-size:45px;
    font-family:"宋体";
}
.login-logo-en{
    font-size:21px;
    font-family:"Helvetica";
}
.middle-box{
    .el-input {
        display: inline-block;
    }
    .el-button {
        display: inline-block;
        width:100%;
    }
    .el-input__inner {
        text-align: center;
    }
}
.show-pwd {
    position: absolute;
    right: 10px;
    top: 2px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
}
</style>