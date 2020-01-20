<template>
  <div>
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>
      <el-main>
        <div style="margin-left: 50px">
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
          <div style="margin: 50px">
            <el-row>
              <el-col :span="8">
                <div class="block">
                  <el-image
                    style="margin: 3px;border: 3px solid "
                    :src="url"
                    fit="contain" ></el-image>
                </div>
                <div>
                  <el-row>
                    <el-col :span="24/(urls.length)" v-for="url in urls" :key="url">
                    <el-image class="block"
                      style="margin: 3px"
                      :src="url"
                      fit="contain"  @click="getUrl(url)"></el-image>
                    </el-col>
                  </el-row>
                </div>
              </el-col>
              <el-col :span="15" :offset="1">
                <div style="text-align: left">
                  <div >
                    <h1>荣耀MagicBook 2019 第三方Linux版 14英寸轻薄窄边框笔记本电脑（AMD锐龙5 3500U 8G 512G FHD IPS ）冰河银</h1>
                  </div>
                  <div  style="color: #F56C6C">
                  <small>【新品晒单就送荣耀耳机】新品预装第三方Linux版操作系统，赠送新机咨询服务！金属轻薄本，超高性价比，赶紧抢！</small>
                  </div>
                  <div style="margin: 20px 0;border: 2px solid #DCDFE6;background: #F2F6FC">
                    <div style="margin: 10px">
                    <small style="color: #909399">学员售价：</small><span style="color: #F56C6C;font-size: 26px">￥1111</span>
                    </div>
                    <div style="margin: 10px"><small>*退货补运费 *7天无理由退货 *24小时快速退款 </small></div>
                  </div>
                  <!-- <form class="form-inline product-form col-md-12" role="form"> -->
                  <div>
                    <span>数量：</span>
                    <el-input-number v-model="num1" size="small" @change="handleChange" :min="1" :max="10"></el-input-number>
                    <el-button-group>
                      <el-button size="mini" icon="iconfont iconshoucang">收藏</el-button>
                      <el-button size="mini" icon="iconfont icongouwuchekong">加入购物车</el-button>
                    </el-button-group>
                  </div>
                  <div style="margin: 20px 0">
                    <el-button type="primary" style="width: 300px">立即购买</el-button>
                  </div>
                </div>
              </el-col>
            </el-row>
          </div>

          <div style="margin: 0 100px">
            <el-tabs type="border-card" value="售后保障">
              <el-tab-pane label="商品介绍">商品介绍</el-tab-pane>
              <el-tab-pane label="规格包装">规格包装</el-tab-pane>
              <el-tab-pane label="商品评论">

              </el-tab-pane>
              <el-tab-pane label="售后保障" name="售后保障">
                <div >
                  <h3 >售后保障</h3>
                </div>
                <div >
                  <div >

                    <div >正品保障</div>
                  </div>
                  <div >
                    <div >学子商城向您保证所售商品均为正品行货，学子商城自营商品开具机打发票或电子发票。</div>
                  </div>

                  <div >
                    <div >厂家服务</div>
                  </div>
                  <div >
                    <div >本产品全国联保，享受三包服务，质保期为：二年质保</div>
                  </div>

                  <div >

                    <div >郑重承诺</div>
                  </div>
                  <div >
                    <div >学子商城销售并发货的商品，由学子商城提供发票和相应的售后服务。请您放心购买！
                      <br /> 注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！
                    </div>
                  </div>

                  <div class="col-md-12 ">
                    <div >全国联保</div>
                  </div>
                  <div >
                    <div >
                      凭质保证书及学子商城发票，可享受全国联保服务（奢侈品、钟表除外；奢侈品、钟表由学子商城联系保修，享受法定三包售后服务），与您亲临商场选购的商品享受相同的质量保证。学子商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！
                      <br /> 注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！
                    </div>
                  </div>

                  <div>
                    <div >无忧退货</div>
                  </div>
                  <div>
                    <div>客户购买学子商城商品7日内（含7日，自客户收到商品之日起计算），在保证商品完好的前提下，可无理由退货。（部分商品除外，详情请见各商品细则）</div>
                  </div>

                  <div>

                    <small><b>权利声明：</b><br />
                      所有商品信息、商品咨询等内容，是学子商城重要的经营资源，未经许可，禁止非法转载使用。<br />
                      注：本站商品信息均来自于合作方，其真实性、准确性和合法性由信息拥有者（合作方）负责。本站不提供任何保证，并不承担任何法律责任。</small>
                  </div>
                </div>
              </el-tab-pane>
            </el-tabs>
          </div>
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
    name: "Details",
    components: {Footer, Header},
    data() {
      return {
        num1: 1,
        url:"https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg",
        urls: ['https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg',
          'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
          'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
          'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg']
      };
    },
    methods:{
      getUrl:function (url) {
        console.log(url)
        this.url=url;
      },
      handleChange(value) {
        console.log(value);
      }
    }
  }
</script>

<style scoped>

</style>
