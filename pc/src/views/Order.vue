<template>
    <div>
      <el-header><Header></Header></el-header>
      <el-main>
        <div>
          <div style="margin: 10px 80px;border: 2px solid #DCDFE6">
            <el-table
              ref="multipleTable"
              :data="tableData"
              tooltip-effect="dark"
              style="width: 100%;"  >
              <el-table-column label="" width="140" align="center">
                <template slot-scope="scope">
                  <el-image class="block" style="margin: 3px" :src="scope.row.url" fit="contain"></el-image>
                </template>
              </el-table-column>
              <el-table-column prop="goods_name" label="商品" width="280"  align="center">
              </el-table-column>
              <el-table-column prop="order_id" label="订单号" width="140"  align="center">
              </el-table-column>
              <el-table-column prop="date" label="时间" width="120" align="center">
              </el-table-column>
              <el-table-column prop="name" label="收货人" align="center">
              </el-table-column>
              <el-table-column label="金额" align="center" >
                <template slot-scope="scope">
                  <span>￥{{scope.row.money}}</span>
                </template>
              </el-table-column>
              <el-table-column prop="pay_way" label="支付方式" align="center" >
              </el-table-column>
              <el-table-column prop="state" label="状态" align="center" >
              </el-table-column>
            </el-table>
          </div>
        </div>
      </el-main>
      <el-footer><Footer></Footer></el-footer>
    </div>
</template>

<script>
    import Header from "./Header";
    import Footer from "./Footer";
    export default {
        name: "Order",
      components: {Footer, Header},
      data() {
        return {
          tableData: [
            {
              url: "https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg",
              goods_name: '联想(Lenovo)小新Air13 Pro 13.3英寸14.8mm超轻薄笔记本电脑',
              order_id:"12345678",
              date: '2019-10-26',
              name: "张三",
              money:"3000",
              pay_way:"微信支付",
              state:"已发货",
            },{
              url: "https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg",
              goods_name: '联想(Lenovo)小新Air13 Pro 13.3英寸14.8mm超轻薄笔记本电脑',
              order_id:"12345678",
              date: '2019-10-26',
              name: "张三",
              money:"3000",
              pay_way:"微信支付",
              state:"已发货",
            },
          ],
          multipleSelection: [],
          total:{
            total_money:0,
            total_count:0,
          }
        }
      },
    }
</script>

<style scoped>

</style>
