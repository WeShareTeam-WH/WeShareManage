import Vue from 'vue'
import router from './router/router'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store.js'

Vue.use(ElementUI);

new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
