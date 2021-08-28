import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// 引入ElementUI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.config.productionTip = false
// 安装ElementUI
Vue.use(ElementUI)

// 引入 fonw-awesome
import 'font-awesome/css/font-awesome.min.css'


import {
  postRequest
} from "./utils/api";
import {
  putRequest
} from "./utils/api";
import {
  getRequest
} from "./utils/api";
import {
  deleteRequest
} from "./utils/api";
import {
  initMenu
} from './utils/menu'
//插件
Vue.prototype.postRequest = postRequest;
Vue.prototype.putRequest = putRequest;
Vue.prototype.getRequest = getRequest;
Vue.prototype.deleteRequest = deleteRequest;

router.beforeEach((to, from, next) => {
  if (window.sessionStorage.getItem("tokenStr")) {
    initMenu(router, store);
    if (!window.sessionStorage.getItem("user")) {
      return getRequest('/admin/info').then(resp => {
        if (resp) {
          //存入用户信息
          window.sessionStorage.setItem("user", JSON.stringify(resp));
          next();
        }
      });
    }
    next();
  } else {
    if (to.path == '/') {
      next();
    } else {
      next('/?redirect=' + to.path);
    }
  }
})


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')