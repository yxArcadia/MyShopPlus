<template>
    <div>
      <el-header><Header></Header></el-header>
      <el-main class="content">
        <el-steps :active="active" align-center>
          <el-step title="验证手机号"/>
          <el-step title="修改密码"/>
          <el-step title="修改完成"/>
        </el-steps>
        <!--填写手机号验证-->
        <div class="phone_number" v-if="active==1">
          <el-form ref="form" :model="form1" label-width="80px" class="login-box"
                   style="margin-top: 30px;">
            <el-form-item>
              <el-input placeholder="请输入手机号" v-model="form1.phone">
                <template slot="prepend">中国大陆 0086</template>
              </el-input>
            </el-form-item>
            <el-form-item>
              <el-input placeholder="请输入内容">
                <template slot="prepend">验证码</template>
                <el-button slot="append">获取验证码</el-button>
              </el-input>
            </el-form-item>
          </el-form>
        </div>
        <!--填写基本信息-->
        <div class="info" v-if="active==2">
          <el-form ref="form" :model="form2" label-width="80px">
            <el-form-item label="新密码">
              <el-input v-model="form2.password" type="password"/>
            </el-form-item>
            <el-form-item label="确认密码">
              <el-input v-model="form2.password2" type="password"/>
            </el-form-item>
          </el-form>
        </div>

        <!--完成注册-->
        <div v-if="active==3">
          <h1 style="color:#16dcff">修改完成</h1>
          <el-button type="success" style="width: 200px;margin-top: 30px">去购物</el-button>
        </div>
        <el-button type="primary" @click="next()" class="next" v-if="active==1 ||active==2">下一步</el-button>
      </el-main>
      <el-footer><Footer></Footer></el-footer>
    </div>
</template>

<script>
    import Header from "./Header";
    import Footer from "./Footer";
    export default {
        name: "ChangePassword",
      components: {Footer, Header},
      data(){
          return{
            active:1,
            form1:{
              phone:""
            },
            form2:{
              password:"",
              password2:"",
            }
          }
      },
      methods:{
        next(){
          this.active+=1;
        }
      }
    }
</script>

<style scoped>
  .content {
    width: 800px;
    margin: 0 auto;
    text-align: center;
  }
  .phone_number{
    text-align: right;
  }
  .next{
    width: 300px;
  }

</style>
