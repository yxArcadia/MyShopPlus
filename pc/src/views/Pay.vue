<template>
  <div>
    <el-header>
      <Header></Header>
    </el-header>
    <el-main>
      <el-steps :active="active" align-center>
        <el-step title="确认订单信息"></el-step>
        <el-step title="在线支付"></el-step>
        <el-step title="支付成功"></el-step>
      </el-steps>
      <div v-if="active==1">
        <div style="margin: 10px 80px;border: 2px solid #DCDFE6">
          <div style="margin: 0 20px 10px 10px;text-align: left">
            <h4>选择收货地址：</h4>
            <el-select v-model="value" placeholder="请选择"  style="width:100%">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </div>
          <el-table
            ref="multipleTable"
            :data="tableData"
            tooltip-effect="dark"
            style="width: 100%;">
            <el-table-column label="" width="140" align="center">
              <template slot-scope="scope">
                <el-image class="block" style="margin: 3px" :src="scope.row.url" fit="contain"></el-image>
              </template>
            </el-table-column>
            <el-table-column prop="goods_name" label="商品" width="280" align="center">
            </el-table-column>
            <el-table-column label="单价" width="120" align="center">
              <template slot-scope="scope">
                <span>￥{{scope.row.price}}</span>
              </template>
            </el-table-column>
            <el-table-column prop="num" label="数量" align="center">
            </el-table-column>
            <el-table-column label="金额" align="center" prop="total_price">
              <template slot-scope="scope">
                <span>￥{{(scope.row.price) * (scope.row.num)}}</span>
              </template>
            </el-table-column>
          </el-table>
          <div style="margin: 10px 30px 0 0;text-align: right ">
              <span>已选商品
								<span>{{1}}</span>件 总价¥
							<span>{{111}}</span>元
							</span>
          </div>
          <div style="text-align: right;margin: 30px">
            <el-button type="primary" @click="payment">在线支付</el-button>
          </div>
        </div>
      </div>

      <div v-if="active==2">
        <div style="margin: 10px 80px;border: 2px solid #DCDFE6">
          <div style="text-align: left;margin-left: 50px">
            <h3>请选择支付方式: &nbsp;&nbsp;</h3>
          </div>
          <div>
            <el-radio-group v-model="pay_way">
              <el-radio :label="1">支付宝</el-radio>
              <el-radio :label="2">微信</el-radio>
              <el-radio :label="3">网银</el-radio>
            </el-radio-group>
          </div>
          <div style="text-align: left;margin:30px 0 0 50px">
            <span style="color: #909399">订单号 ： </span>
            <small>1111111111，</small>
            <span>支付金额 : ￥1111</span>
            <div style="margin-top: 10px">
              <router-link to="/shoppingcart">返回购物车</router-link>
            </div>
          </div>
          <div style="margin: 20px 80px 20px 0;text-align: right">
            <span style="font-size: 30px;margin-right: 15px">￥1111</span>
            <el-button type="primary" @click="confirm ">确认付款</el-button>
          </div>
        </div>
      </div>
      <div v-if="active==3">
        <div style="margin: 0px 80px 80px 80px;border: 2px solid #DCDFE6;padding: 30px">
        <div >
          <h1 v-if="pay_result==true">支付成功</h1>
          <h1 v-if="pay_result==false">支付失败</h1>
        <span>易星商城不会以系统异常、订单升级为由，要求你点击任何链接进行退款操作</span>
        </div>
        <div style="text-align: left;margin-left: 50px">
          <router-link to="/order">查看订单</router-link>
        </div>
        </div>
      </div>
    </el-main>
    <el-footer>
      <Footer></Footer>
    </el-footer>
  </div>
</template>

<script>
  import Header from "./Header";
  import Footer from "./Footer";

  export default {
    name: "Pay",
    components: {Footer, Header},
    data() {
      return {
        pay_way: 1,
        active: 1,
        pay_result:true,
        tableData: [
          {
            url: "https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg",
            goods_name: '联想(Lenovo)小新Air13 Pro 13.3英寸14.8mm超轻薄笔记本电脑',
            price: '5298',
            num: 1,
            total_price: "",
          }
        ],
        options: [{
          value: '1',
          label: '重庆'
        }],
        value: ''
      }
    },
    methods: {
      payment() {
        this.active = 2;
      },
      confirm(){
        this.active = 3;
      }
    }
  }
</script>

<style scoped>

</style>
