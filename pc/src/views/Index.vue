<template>
  <div>
    <el-container>
      <el-header>
          <Header></Header>
      </el-header>
      <el-main>
        <div style="margin: 50px">
          <el-row :gutter="20">
            <!--左边-->
            <el-col :span="6">
              <el-card class="box-card">
                <div v-for="o in 10" :key="o" class="text item">
                  {{'列表内容 ' + o }}
                </div>
              </el-card>
            </el-col>
            <!--右边-->
            <el-col :span="18">
              <el-carousel :interval="4000" type="card" height="200px">
                <el-carousel-item>
                  <el-image :src="url1" @click="toDetails"></el-image>
                </el-carousel-item>
                <el-carousel-item>
                  <el-image :src="url2" @click="toDetails"></el-image>
                </el-carousel-item>
                <el-carousel-item>
                  <el-image :src="url3" @click="toDetails"></el-image>
                </el-carousel-item>
              </el-carousel>
            </el-col>
          </el-row>
        </div>

        <div style="margin: 50px">
          <el-row v-for="o in 2" :key="o" style="margin-top: 20px">
            <el-col :span="6" v-for="(o, index) in 4" :key="o" :offset="index > 0 ? 0 : 0">
              <el-card :body-style="{ padding: '0px'}" class="card">
                <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                     class="image" @click="toDetails">
                <div style="text-align: left ;margin-left: 15px">
                  <span style="font-size: 16px;color: #F56C6C;margin-right: 10px">￥300</span>
                </div >
                <div style="padding: 10px;text-align: left">
                  <span style="font-size: 13px">好吃的汉堡啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</span>
                </div>
                <div style="text-align: left">
                  <el-button type="text" icon="iconfont iconxiaoliansmiley40">  易星自营店</el-button>
                </div>
                <div style="text-align: right">
                  <el-button-group style="margin-bottom: 10px">
                    <el-button size="mini" icon="iconfont iconshoucang">收藏</el-button>
                    <el-button size="mini" icon="iconfont icongouwuchekong">加入购物车</el-button>
                  </el-button-group>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </div>
      </el-main>
      <el-footer><Footer></Footer></el-footer>
    </el-container>

  </div>
</template>

<script>
  import Header from './Header';
  import Footer from "./Footer";

  export default {
    name: "Index",
    components: {Footer, Header},
    data() {
      return {
        url1: 'https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg',
        url2: 'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
        url3: 'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
      };
    },
    methods:{
      toDetails:function () {
        this.$router.push("/details")
      }
    }

  }
</script>

<style scoped>
  .card:hover{
    border: 2px solid #989aa1;
    cursor:pointer;
  }
</style>
