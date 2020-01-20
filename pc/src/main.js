// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/icon/iconfont.css'

import axios from 'axios';
Vue.prototype.axiox=axios;

import Vuex from 'vuex';

import store from './strore'
Vue.use(Vuex);
Vue.use(ElementUI);

Vue.config.productionTip = false

router.beforeEach(((to, from, next) => {
    //去除session中isLogin
    let isLogin=sessionStorage.getItem("isLogin");
    //如果去的路径为lougot,清空session,到登录页
    if (to.path ==='/logout') {
      sessionStorage.clear();
      next({path:"/login"});
      //去的路径是登录页,跳转登录页
    }else if (to.path ==='/login'){
      if (isLogin ==='true'){
        next({path:"/index"})
      }
    }else if (isLogin==null){
      next({path:"/login"})
    }
    next();
}))

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  router,
  store,
  template: '<App/>',
  render: h => h(App)
})
