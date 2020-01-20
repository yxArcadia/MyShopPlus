<template>
  <div>
  <Form :model="formItem" :label-width="80">
    <FormItem label="头像">
      <Avatar :src=formItem.icon  size="large"  />&nbsp&nbsp&nbsp
      <Button type="primary" @click="toggleShow">上传头像</Button>
    </FormItem>
    <input v-model="formItem.id" type="hidden"></input>
    <FormItem label="用户名">
      <Input v-model="formItem.username" disabled></Input>
    </FormItem>
    <FormItem label="邮箱">
      <Input v-model="formItem.email" ></Input>
    </FormItem>
    <FormItem label="昵称">
      <Input v-model="formItem.nickName" ></Input>
    </FormItem>
    <FormItem label="创建时间">
      <Input v-model="formItem.createTime" disabled ></Input>
    </FormItem>
    <FormItem label="状态">
      <i-switch v-model="formItem.status" size="large" :true-value="Number(1)" :false-value="Number(0)">
        <span slot="open" >启用</span>
        <span slot="close">禁用</span>
      </i-switch>
    </FormItem>
    <FormItem label="备注">
      <Input v-model="formItem.note" type="textarea" :autosize="{minRows: 2,maxRows: 5}"></Input>
    </FormItem>
    <FormItem>
      <Button type="primary" @click="updateInfo">保存</Button>
    </FormItem>
  </Form>

  <image-cropper
    v-model="show"
    field="multipartFile"
    :width="300"
    :height="300"
    :url="url"
    :params="params"
    :headers="headers"
    img-format="png"
    @crop-success="cropSuccess"
    @crop-upload-success="cropUploadSuccess"
    @crop-upload-fail="cropUploadFail"
  ></image-cropper>
  </div>
</template>
<script>
  import ImageCropper from 'vue-image-crop-upload'
  import {info,update,modifyIcon} from "@/api/user";
  import {getToken} from "@/libs/util"
  import config from '@/config'
  export default {
    name: "ProfileInfo",
    components: { "image-cropper":ImageCropper },
    data() {
      return {
        formItem: {
          id:"",
          username: "",
          icon: "",
          email:"",
          nickName:"",
          createTime:"",
          status:"1",
          note:"",
        },
        url:  config.baseUrl.dev + 'upload',
        show: false,
        params: {
          access_token: getToken()
        },
        headers: {
          smail: '*_~'
        },
        image: this.$store.state.user.avatarImgPath
      }
    },
    created() {
      this.fetchData();
    },
    methods: {
      /**
       * 读取基本信息
       */
      fetchData() {
        info(this.$store.state.user.userName).then(response => {
          this.formItem =response.data.data ;
        })
      },
      /**
       * 修改基本信息
       */
      updateInfo(){
        update(this.formItem).then(response => {
          this.$Message.success(response.data.message);
        }).catch((response) => {
          this.$Message.error(response.data.message);
        })
      },
      //打开上传头像框
      toggleShow() {
        this.show = !this.show
      },

      /**
       *
       * @param image
       * @param field
       */
      cropSuccess(image, field) {
        // console.log('-------- crop success --------')
        this.image = image
      },
      /**
       * 上传成功
       * @param jsonData 服务器返回数据，已进行 JSON 转码
       * @param field
       */
      cropUploadSuccess(jsonData, field) {
        // console.log('-------- upload success --------')
        modifyIcon({
          username:this.$store.state.user.userName,
          path: jsonData.data.path
        }).then(response =>{
          this.$Message.success(response.data.message);
          this.$store.commit('setAvatar', jsonData.data.path)
          this.fetchData()
        }).catch(() => {
        })
      },
      /**
       * 上传失败
       * @param status 服务器返回的失败状态码
       * @param field
       */
      cropUploadFail(status, field) {
        console.log('-------- upload fail --------')
        console.log(status)
        console.log('field: ' + field)
      }
    }
  }
</script>

<style scoped>

</style>
