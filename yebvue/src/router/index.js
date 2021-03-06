import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login'
import Test1 from '../views/Test1'
import Test2 from '../views/Test2'
Vue.use(VueRouter)

const routes = [
  {
    path: '/home',
    name: '导航一',
    component: Home,
    children:[
      {
           path: '/test1',
           name: '选项1',
           component: Test1
      },
      {
           path: '/test2',
           name: '选项2',
           component: Test2
      }
    ]
  },
  {
    path: '/',
    name: 'Login',
    component: Login,
    hidden: true
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue'),
    hidden: true
  }
]

const router = new VueRouter({
  routes
})

export default router
