<template>
    <div>
      <el-container>
        <el-header>
          <Header></Header>
        </el-header>
        <el-main>
          <div>
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{ path: '/index' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/index' }">家用电器</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/index' }">手机电脑</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/index' }">男装女装</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/index' }">个护清洁</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/index' }">鞋子箱包</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/index' }">办公用品</el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/index' }"></el-breadcrumb-item>
            </el-breadcrumb>
          </div>
          <div>
            <el-row :gutter="20">
              <el-col :span="18">
                <div style="margin-top: 40px">
                  <div style="background: #DCDFE6;text-align: left;padding: 10px" >
                      <el-radio-group v-model="radio3" size="mini">
                        <el-radio-button label="综合">综合<i class="el-icon-sort-down"></i></el-radio-button>
                        <el-radio-button label="销量">销量<i class="el-icon-sort-down"></i></el-radio-button>
                        <el-radio-button label="评论数">评论数<i class="el-icon-sort-down"></i></el-radio-button>
                        <el-radio-button label="新品">新品<i class="el-icon-sort-down"></i></el-radio-button>
                        <el-radio-button label="价格">价格<i class="el-icon-d-caret"></i></el-radio-button>
                      </el-radio-group>
                  </div>
                  <div>
                  <el-row v-for="o in 4" :key="o" style="margin-top: 20px">
                    <el-col :span="6" v-for="(o, index) in 4" :key="o" :offset="index > 0 ? 0 : 0">
                      <el-card :body-style="{ padding: '0px' }" class="card">
                        <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                             class="image" @click="toDetails">
                        <div style="text-align: left;margin-left: 15px ">
                          <span style="font-size: 16px;color: #F56C6C;margin-right: 10px">￥300</span>
                        </div >
                        <div style="padding: 10px;text-align: left">
                          <span style="font-size: 13px">好吃的汉堡啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</span>
                        </div>
                        <div style="text-align: left">
                          <el-button type="text" icon="iconfont iconxiaoliansmiley40">  易星自营店</el-button>
                        </div>
                        <div style="text-align: right">
                          <el-button-group style="margin:0 10px 10px 0">
                            <el-button size="mini" icon="iconfont iconshoucang">收藏</el-button>
                            <el-button size="mini" icon="iconfont icongouwuchekong">加入购物车</el-button>
                          </el-button-group>
                        </div>
                      </el-card>
                    </el-col>
                  </el-row>
                  </div>
                  <div style="margin-top: 30px">
                    <el-pagination
                      background
                      layout="prev, pager, next"
                      :total="1000">
                    </el-pagination>
                  </div>
                </div>
              </el-col>
              <el-col :span="6">
                <div style="margin:40px">
                  <el-row v-for="o in 5" :key="o" style="margin-top: 0px">
                    <el-col>
                      <el-card :body-style="{ padding: '0px' }" class="card">
                        <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                             class="image" @click="toDetails">
                        <div style="text-align: left;margin-left: 15px ">
                          <span style="font-size: 16px;color: #F56C6C;margin-right: 10px">￥300</span>
                        </div >
                        <div style="padding: 10px;text-align: left">
                          <span style="font-size: 13px">好吃的汉堡啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</span>
                        </div>
                      </el-card>
                    </el-col>
                  </el-row>
                </div>
              </el-col>
            </el-row>
          </div>
        </el-main>
        <el-footer>
          <Footer></Footer>
        </el-footer>
      </el-container>
    </div>
</template>

<script>
    import Header from "./Header";
    import Footer from "./Footer";
    export default {
        name: "Search",
      components: {Footer, Header},
      data(){
          return{
            radio3: '综合',
        }
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
