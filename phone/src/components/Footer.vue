<template>
    <div>
      <van-tabbar v-model="active">
        <van-tabbar-item icon="wap-home-o">首页</van-tabbar-item>
        <van-tabbar-item icon="apps-o">分类</van-tabbar-item>
        <van-tabbar-item icon="fire-o">热卖</van-tabbar-item>
        <van-tabbar-item icon="shopping-cart-o">购物车</van-tabbar-item>
        <van-tabbar-item icon="contact">我的</van-tabbar-item>
      </van-tabbar>
    </div>
</template>

<script>
  import { Tabbar, TabbarItem } from 'vant';
  export default {
    name: "Footer",
    components: {Tabbar, TabbarItem},
    data() {
      return {
        active: 0,
        icon: {
          active: 'https://img.yzcdn.cn/vant/user-active.png',
          inactive: 'https://img.yzcdn.cn/vant/user-inactive.png'
        }
      }
    }
  }
</script>

<style scoped>

</style>
