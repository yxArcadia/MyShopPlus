<template>
  <div>
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>
      <el-main>
        <div>
          <div style="margin: 10px 80px;border: 2px solid #DCDFE6">
            <el-table
              ref="multipleTable"
              :data="tableData"
              tooltip-effect="dark"
              style="width: 100%;"  @selection-change="handleSelectionChange" @cell-mouse-enter="aaa">
              <el-table-column
                type="selection"
                width="55" >

              </el-table-column>
              <el-table-column label="" width="140" align="center">
                <template slot-scope="scope">
                <el-image class="block" style="margin: 3px" :src="scope.row.url" fit="contain"></el-image>
                </template>
              </el-table-column>
              <el-table-column prop="goods_name" label="商品" width="280"  align="center">
              </el-table-column>
              <el-table-column label="单价" width="120" align="center">
                <template slot-scope="scope">
                  <span>￥{{scope.row.price}}</span>
                </template>
              </el-table-column>
              <el-table-column label="数量" align="center">
                <template slot-scope="scope">
                <el-input-number size="mini" :min="1" v-model="scope.row.num"@change="changeNum(scope.row)" ></el-input-number>
                </template>
              </el-table-column>
              <el-table-column label="金额" align="center" prop="total_price">
                <template slot-scope="scope">
                  <span v-model="scope.row.total_price">￥{{(scope.row.price) * (scope.row.num)}}</span>
                </template>
              </el-table-column>
              <el-table-column label="操作" align="center">
                <template slot-scope="scope">
                  <el-button
                    @click.native.prevent="deleteRow(scope.$index, tableData)"
                    type="text"
                    size="small">
                    移除
                  </el-button>
                </template>
              </el-table-column>
            </el-table>
            <div style="margin: 10px 30px 0 0;text-align: right ">
              <span>已选商品
								<span v-model="total.total_count">{{total.total_count}}</span>件 总价¥
							<span v-model="total.total_money">{{total.total_money}}</span>元
							</span>
            </div>
            <div style="text-align: right;margin: 30px">
              <el-button type="primary" @click="pay">结算</el-button>
            </div>
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
  import Header from './Header';
  import Footer from './Footer'

  export default {
    name: "ShoppingCart",
    components: {Footer, Header},
    data() {
      return {
          tableData: [
            {
              url: "https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg",
              goods_name: '联想(Lenovo)小新Air13 Pro 13.3英寸14.8mm超轻薄笔记本电脑',
              price: '5298',
              num: 1,
              total_price:"",
            }, {
              url: "https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg",
              goods_name: '联想(Lenovo)小新Air13 Pro 13.3英寸14.8mm超轻薄笔记本电脑',
              price: '4000',
              num: 1,
              total_price:"",
            }, {
              url: "https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg",
              goods_name: '联想(Lenovo)小新Air13 Pro 13.3英寸14.8mm超轻薄笔记本电脑',
              price: '3000',
              num: 1,
              total_price:"",
            },
          ],
        multipleSelection: [],
        total:{
          total_money:0,
          total_count:0,
        }
      }
    },
    methods:{
      deleteRow(index, rows) {
        rows.splice(index, 1);
      },
      handleSelectionChange(val){
        this.multipleSelection=val;
        this.total.total_money=0;
        this.total.total_count=0;
        for (let i=0;i<val.length;i++){
          this.total.total_money+=((val[i].num)*(val[i].price));
          this.total.total_count+=val[i].num;
        }
      },
      changeNum(val){
        let goods=this.multipleSelection;
        for (let i=0;i<goods.length;i++){
          if (val==goods[i]){
            this.handleSelectionChange(goods);
            this.multipleSelection=goods;
          }
        }
      },
      pay(){
        console.log(this.multipleSelection);
        this.$router.push("/pay")
      },
      aaa(){
        alert(11)
      }

    }
  }
</script>

<style scoped>

</style>
