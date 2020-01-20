<template>
    <div>
      <!--搜索框-->
      <Search></Search>
      <!--轮播图-->
      <van-swipe :autoplay="1500"  @change="onChange">
        <van-swipe-item v-for="(image, index) in images" :key="index">
          <van-image
            width="20rem"
            height="10rem"
            fit="contain"
            :src=image
          />
        </van-swipe-item>
      </van-swipe>
      <!--列表-->
      <van-grid :column-num="3">
        <van-grid-item
          v-for="navList in navLists"
          :key=navList.index
          :text=navList.text
        >
          <van-image round :src=navList.icon />
        </van-grid-item>
      </van-grid>
      <!--底部-->
      <Footer></Footer>
    </div>
</template>

<script>
    import Footer from "../components/Footer";
    import Search from "../components/Search";
    import { Swipe, SwipeItem,Grid, GridItem,Tag} from 'vant';
    export default {
        name: "Main",
      components: {Search, Footer,Swipe,SwipeItem,Grid, GridItem,Tag},
      data() {
        return {
          images: [
            'https://img.yzcdn.cn/vant/apple-1.jpg',
            'https://img.yzcdn.cn/vant/apple-2.jpg'
          ],
          navLists:[
            {
              image:1,
              icon:"https://img.yzcdn.cn/vant/apple-1.jpg",
              text:"商城"
            },{
              index:2,
              icon:"https://img.yzcdn.cn/vant/apple-1.jpg",
              text:"家电"
            },{
              index:3,
              icon:"https://img.yzcdn.cn/vant/apple-2.jpg",
              text:"服饰"
            },
          ]
        }
      },
      methods:{
        onChange(index) {
          console.log('当前 Swipe 索引：' + index);
        }
      }
    }
</script>

<style scoped>

</style>
