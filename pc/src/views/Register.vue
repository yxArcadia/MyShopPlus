<template>
  <div>
    <el-container>
      <el-header style="margin: 20px">
        <img src="../assets/image/stumalllogo.png">
      </el-header>
      <el-main class="content">
        <el-steps :active="active" align-center>
          <el-step title="验证手机号"></el-step>
          <el-step title="填写账号信息"></el-step>
          <el-step title="注册完成"></el-step>
        </el-steps>
        <!--填写手机号验证-->
        <div class="phone_number" v-if="active==1">
          <el-form ref="form" :model="form1" label-width="80px" class="login-box"
                   style="margin-top: 30px;">
            <el-form-item prop="phone">
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
            <el-form-item label="用户名">
              <el-input v-model="form2.name"></el-input>
            </el-form-item>
            <el-form-item label="设置密码">
              <el-input v-model="form2.password" type="password"></el-input>
            </el-form-item>
            <el-form-item label="确认密码">
              <el-input v-model="form2.password2" type="password"></el-input>
            </el-form-item>
            <el-form-item label="邮箱">
              <el-input v-model="form2.email"></el-input>
            </el-form-item>
            <el-form-item label="邮箱验证">
              <el-input placeholder="请输入内容" v-model="form2.ckeck_emali">
                <el-button slot="append">获取验证码</el-button>
              </el-input>
            </el-form-item>
          </el-form>
        </div>

        <!--完成注册-->
        <div v-if="active==3">
          <h1 style="color:#16dcff">恭喜你完成注册</h1>
          <el-button type="success" style="width: 200px;margin-top: 30px">去购物</el-button>
        </div>
        <el-button type="primary" @click="next()" class="next" v-if="active==1 ||active==2">下一步</el-button>
      </el-main>
      <el-footer height="20px">
        <el-row :gutter="20" class="footer">
          <el-col :span="4">&nbsp</el-col>
          <el-col :span="16">
            <el-col :span="3">
              <el-link :underline="false">关于我们</el-link>
            </el-col>
            <el-col :span="3">
              <el-link :underline="false">关于我们</el-link>
            </el-col>
            <el-col :span="3">
              <el-link :underline="false">关于我们</el-link>
            </el-col>
            <el-col :span="3">
              <el-link :underline="false">关于我们</el-link>
            </el-col>
            <el-col :span="3">
              <el-link :underline="false">关于我们</el-link>
            </el-col>
            <el-col :span="3">
              <el-link :underline="false">关于我们</el-link>
            </el-col>
            <el-col :span="3">
              <el-link :underline="false">关于我们</el-link>
            </el-col>
            <el-col :span="3">
              <el-link :underline="false">关于我们</el-link>
            </el-col>
          </el-col>
          <el-col :span="4">&nbsp;</el-col>
        </el-row>
        <span>Copyright © 2004-2019  xx.com 版权所有</span>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: "Register",
    data(){
      return {
        active:1,
        form1:{
          phone:""
        },
        form2:{
          name:"",
          password:"",
          password2:"",
          email:"",
          ckeck_emali:"",
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
