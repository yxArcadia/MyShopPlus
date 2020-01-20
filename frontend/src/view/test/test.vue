<template>
  <div>
  <div class="demo-upload-list" v-for="item in uploadList">
    <template v-if="item.status === 'finished'">
      <img :src="item.url">
    </template>
    <template v-else>
      <Progress v-if="item.showProgress" :percent="item.percentage" hide-info></Progress>
    </template>
  </div>
  <Upload
    ref="upload"
    :show-upload-list="false"
    :default-file-list="defaultList"
    :on-success="handleSuccess"
    :format="['jpg','jpeg','png']"
    :max-size="2048"
    :on-format-error="handleFormatError"
    :on-exceeded-size="handleMaxSize"
    :before-upload="handleBeforeUpload"
    multiple
    type="drag"
    action="//jsonplaceholder.typicode.com/posts/"
    style="display: inline-block;width:58px;">
    <div style="width: 58px;height:58px;line-height: 58px;">
      <Icon type="ios-camera" size="20"></Icon>
    </div>
  </Upload>
  </div>
</template>
<script>
  export default {
    name: "uploadTest",
    data () {
      return {
        defaultList: [
          {
            'name': 'a42bdcc1178e62b4694c830f028db5c0',
            'url': 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg'
          },
          {
            'name': 'bc7521e033abdd1e92222d733590f104',
            'url': 'http://yx-myshop.oss-cn-hongkong.aliyuncs.com/8b46c227-8ff2-412f-b99f-b9cb0b4fdc6a.jpg'
          }
        ],
        uploadList: []
      }
    },
    methods: {
      handleView (name) {
        this.imgName = name;
        this.visible = true;
      },
      handleSuccess (res, file) {
        file.url = 'https://o5wwk8baw.qnssl.com/7eb99afb9d5f317c912f08b5212fd69a/avatar';
        file.name = '7eb99afb9d5f317c912f08b5212fd69a';
      },
      handleFormatError (file) {
        this.$Notice.warning({
          title: 'The file format is incorrect',
          desc: 'File format of ' + file.name + ' is incorrect, please select jpg or png.'
        });
      },
      handleMaxSize (file) {
        this.$Notice.warning({
          title: 'Exceeding file size limit',
          desc: 'File  ' + file.name + ' is too large, no more than 2M.'
        });
      },
      handleBeforeUpload () {
        const check = this.uploadList.length < 1;
        console.log(check)
        if (!check) {
          this.$Notice.warning({
            title: 'Up to five pictures can be uploaded.'
          });
        }
        return check;
      }
    },
    mounted () {
      this.uploadList = this.$refs.upload.fileList;
      console.log(this.uploadList)
    }
  }
</script>
<style>
  .demo-upload-list{
    display: inline-block;
    width: 60px;
    height: 60px;
    text-align: center;
    line-height: 60px;
    border: 1px solid transparent;
    border-radius: 4px;
    overflow: hidden;
    background: #fff;
    position: relative;
    box-shadow: 0 1px 1px rgba(0,0,0,.2);
    margin-right: 4px;
  }
  .demo-upload-list img{
    width: 100%;
    height: 100%;
  }
  .demo-upload-list-cover i{
    color: #fff;
    font-size: 20px;
    cursor: pointer;
    margin: 0 2px;
  }
</style>
