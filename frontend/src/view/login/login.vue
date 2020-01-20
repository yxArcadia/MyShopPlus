<style lang="less">
  @import './login.less';
</style>

<template>
  <div class="login">
    <div class="login-con">
      <Card icon="log-in" title="欢迎登录" :bordered="false">
        <div class="form-con">
          <login-form @on-success-valid="handleSubmit"></login-form>
        </div>
        <p class="login-tip" v-if="result">用户名密码错误</p>
      </Card>
    </div>
  </div>
</template>

<script>
import LoginForm from '_c/login-form'
import { mapActions } from 'vuex'
export default {
  components: {
    LoginForm
  },
  data(){
    return{
      result:false
    }
  },
  methods: {
    ...mapActions([
      'handleLogin',
      'getUserInfo'
    ]),
    handleSubmit ({ username, password }) {
      this.handleLogin({ username, password }).then(res => {
        if (res.data.state===20000){
          this.getUserInfo().then(res => {
            this.$router.push({
              name: this.$config.homeName
            })
          })
        }else {
          this.result=true;
        }
      })
    }
  }
}
</script>

<style>

</style>
