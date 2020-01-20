<template>
    <div>
      <el-container>
        <el-header>
          <div class="login-img">
            <img src="../assets/image/stumalllogo.png">
          </div>
          <div class="login-welcome">
            <h1>欢迎来到易星商城</h1>
          </div>
        </el-header>
        <el-main class="bg-img">
          <div class="mycontent">
            <el-form ref="form" :model="form" :rules="rules" label-width="80px" class="login-box">
              <h1 class="login-title">欢迎登录</h1>
              <el-form-item label="用户名" prop="username">
                <el-input v-model="form.username"></el-input>
              </el-form-item>
              <el-form-item label="密码" prop="password">
                <el-input v-model="form.password" type="password"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="login('form')">登录</el-button>
                <el-button type="text" class="register" icon="el-icon-d-arrow-right" @click="toReg()">立即注册</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-main>
        <el-footer style="margin-top: 80px">
            <Footer></Footer>
        </el-footer>
      </el-container>

    </div>
</template>

<script>
  import Header from './Header';
  import Footer from './Footer';
    export default {
        name: "Login",
      components:{
        Header,Footer
      },
        data(){
          return {
            form:{
              username:"",
              password:"",
            },
            rules:{
              username:[
                { required: true, message: '请输入用户名', trigger: 'blur' }
                ],
              password:[
                { required: true, message: '请输入密码', trigger: 'blur' }
              ]
            }
          }
        },
      methods:{
          login:function (form) {
            this.$refs[form].validate((v)=>{
              if (v){
                sessionStorage.setItem("isLogin","true");
                this.$store.dispatch("asyncUpdateUser",this.form);
                this.$router.push("/index")
              }else {
                this.$alert('请输入用户名活密码', '提示', {
                  confirmButtonText: '确定',
                });
                return false;
              }
            })
          },
          toReg:function ()   {
            this.$router.push("/register")
          }
    }
    }
</script>

<style scoped>
  .register{
    float: right;
  }
  .login-img{
    position: absolute;
    top: 40px;
    left: 20px;
  }
  .login-welcome{
    margin-top: -20px;
    float: right;
    color: #409EFF;
    font-size: 18px;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  }
  .bg-img{
    background-image: url(../assets/image/bg.jpg);
    width: 100%;
    background-size: 100% auto;
    padding: 6%;
  }
  .mycontent{
    float: right;
    margin-right: 80px;
  }
  .login-box{
    text-align: left;
    width: 400px;
    border: #DCDFE6 solid 1px;
    margin-left: 700px;
    padding: 20px 50px 20px 20px;
    border-radius: 6px;
    box-shadow: 0 0 15px;
    background-color: rgba(255, 255, 255, 0.85);
  }
  .login-title{
    text-align: center;
  }
</style>
