import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import Vue from 'vue'

// 引入ElementUI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

createApp(App).use(router).mount('#app')
Vue.config.productionTip = false

// 安装ElementUI
Vue.use(ElementUI)
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')