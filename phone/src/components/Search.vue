<template>
    <div>
      <van-search
        v-model="value"
        placeholder="请输入商品信息"
        show-action
        shape="round"
        @search="onSearch"
      >
        <div slot="action" @click="onSearch">搜索</div>
      </van-search>
    </div>
</template>

<script>
  import { Search } from 'vant';
    export default {
        name: "Search",
      components:{Search},
      data(){
          return{
            value:"",
        }
      },
      methods:{
        onSearch(){
          alert(this.value)
        }
      }
    }
</script>

<style scoped>

</style>
