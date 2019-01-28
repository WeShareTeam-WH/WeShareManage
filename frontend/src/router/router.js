import Vue from 'vue'
import Router from 'vue-router'
import App from '../App'

Vue.use(Router)

const login = r => require.ensure([], () => r(require('@/page/login')), 'login');
const home = r => require.ensure([], () => r(require('@/page/home')), 'home');
const index = r => require.ensure([], () => r(require('@/page/index')), 'index');
const notFound = r => require.ensure([], () => r(require('@/components/404')), 'notFound');
const leftSide = r => require.ensure([], () => r(require('@/components/leftNav')), 'leftSide');
const topSide = r => require.ensure([], () => r(require('@/components/headerTop')), 'topSide');

const order = r => require.ensure([], () => r(require('@/page/orders/order')), 'order');
const addUser = r => require.ensure([], () => r(require('@/page/user/addUser')), 'addUser');
const pictureSetting = r => require.ensure([], () => r(require('@/page/setting/picture')), 'picture');

const goods = r => require.ensure([], () => r(require('@/page/goods/index')), 'goods');
const goodsList = r => require.ensure([], () => r(require('@/page/goods/list')), 'goodsList');
const goodsAdd = r => require.ensure([], () => r(require('@/page/goods/add')), 'goodsAdd');
const goodsDetail = r => require.ensure([], () => r(require('@/page/goods/detail')), 'goodsDetail');

let router = new Router(
	{
		routes : [
			{
				path: '/login',
				component: login
			},
			{
				path:"*",
				component: notFound
			},
			{
				path: '/',
				name:"home",
				type:"home",
				redirect: '/index',
				component: home,
				children: [
					{
						path: '/index',
						name:"首页",
						menuShow: true,
						leaf: true, // 只有一个节点
          				iconCls: 'iconfont icon-home', // 图标样式class
						components:{
							default:index,
							leftSide:leftSide,
							topSide: topSide							
						},
					},
					{
						path: '/goods',
						name:"商品管理",
						menuShow: true,
						iconCls: 'el-icon-menu',
						components:{
							default:goods,
							leftSide:leftSide,
							topSide: topSide							
						},
						children: [{
							path: '/goods/list',
							component: goodsList,
							menuShow: true,
							name:'商品列表',
							meta: ['商品管理', '商品列表']
						},
						{
							path: '/goods/add',
							component: goodsAdd,
							menuShow: true,
							name:'添加商品',
							meta: ['商品管理', '添加商品']
						},
						{
							path: '/goods/detail/:id',
							component: goodsDetail,
							menuShow: false,
							name:'商品详情',
							meta: ['商品管理', '商品详情']
						}]
					},
					{
		
						path: '/order',
						component: order,
						meta: ['订单管理']
					},
					{
						path: '/addUser',
						component: addUser,
						meta: ['系统设置', '添加用户']
					},
					{
						path: '/pictureSetting',
						component: pictureSetting,
						meta: ['系统设置', '图片设置']
					}
		
			]
			}
			
		]
		
	}
)

router.beforeEach((to, from, next) => {
	// console.log('to:' + to.path)
	if (to.path.startsWith('/login')) {
	  window.localStorage.removeItem('access-user')
	  next()
	} else if(to.path.startsWith('/register')){
	  window.localStorage.removeItem('access-user')
	  next()
	} else {
	  let user = JSON.parse(window.localStorage.getItem('access-user'))
	  if (!user) {
		next({path: '/login'})
	  } else {
		next()
	  }
	}
  });


  export default router


