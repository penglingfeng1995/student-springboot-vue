import Vue from 'vue'
import Router from 'vue-router'
import Main from "../views/Main"

Vue.use(Router)

export default new Router({
  routes: [
    {path:"/",redirect:"/main"},
    {path: "/main",component:Main}
  ]
})
