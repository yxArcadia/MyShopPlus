<template>
  <div>
    <div class="head-info">
      <el-dropdown>
  <span class="el-dropdown-link my-info" >
    个人信息<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item><router-link to="/changepassword">账号安全</router-link></el-dropdown-item>
          <el-dropdown-item><router-link to="/address">收货地址</router-link></el-dropdown-item>
          <el-dropdown-item><router-link to="/logout">退出登录</router-link></el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <el-divider direction="vertical"></el-divider>
      <router-link to="/register">免费注册</router-link>
      <el-divider direction="vertical"></el-divider>
      <router-link to="/shoppingcart" >购物车</router-link>
      <el-divider direction="vertical"></el-divider>
      <router-link to="/order">我的订单</router-link>
    </div>
    <div class="header-logo">
      <img src="../assets/image/stumalllogo.png">
    </div>
    <el-autocomplete v-model="state" :fetch-suggestions="querySearchAsync" placeholder="请输入内容"
                      class="select_input" >
    </el-autocomplete>
    <el-button type="primary" icon="el-icon-search" @click="search()">搜索</el-button>
  </div>
</template>

<script>
    export default {
        name: "Header",
      data(){
        return{
          restaurants: [],
            timeout: null,
            state: '',
        }
      },
      methods: {
        loadAll() {
          return [
            {"value": "三全鲜食（北新泾店）", "address": "长宁区新渔路144号"},
            {"value": "Hot honey 首尔炸鸡（仙霞路）", "address": "上海市长宁区淞虹路661号"},
            {"value": "新旺角茶餐厅", "address": "上海市普陀区真北路988号创邑金沙谷6号楼113"},
          ];
        },
        querySearchAsync(queryString, cb) {
          var restaurants = this.restaurants;
          var results = queryString ? restaurants.filter(this.createStateFilter(queryString)) : restaurants;

          clearTimeout(this.timeout);
          this.timeout = setTimeout(() => {
            cb(results);
          }, 3000 * Math.random());
        },
        createStateFilter(queryString) {
          return (state) => {
            return (state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
          };
        },
        search:function () {
          console.log(this.state)
          this.$router.push('./search')
        }
      },
      mounted() {
        this.restaurants = this.loadAll();
      }
    }
</script>

<style scoped>
  .header-logo{
    position: absolute;
    top: 40px;
    left: 20px;
  }
  .head-info {
    position: absolute;
    right: 40px;
    top: 20px;
  }
  .select_input {
    width: 500px;
  }
  a {
    text-decoration: none;
  }
  .my-info:hover{
    cursor:pointer;
  }


</style>
