<template>
    <div class="header_container">

		<el-breadcrumb separator="/">
			<el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in $route.meta" :key="index">{{item}}</el-breadcrumb-item>
		</el-breadcrumb>
		<el-dropdown @command="handleCommand" menu-align='start'>
			<img :src="photo" class="avator">
			<el-dropdown-menu slot="dropdown">
				<el-dropdown-item command="home">首页</el-dropdown-item>
				<el-dropdown-item command="singout">退出</el-dropdown-item>
			</el-dropdown-menu>
		</el-dropdown>
    </div>
</template>

<script>
	import {signout} from '@/api/getData'
	import {baseImgPath} from '@/config/env'

    export default {
    	data(){
    		return {
				baseImgPath,
				photo: 'http://ofyaji162.bkt.clouddn.com/nightcat.jpg'
    		}
    	},
    	created(){
    		
    	},
    	computed: {
    		
    	},
		methods: {		
			async handleCommand(command) {
				if (command == 'home') {
					this.$router.push('/home');
				}else if(command == 'singout'){
					const res = await signout()
					if (res.status == 1) {
						this.$message({
	                        type: 'success',
	                        message: '退出成功'
	                    });
	                    this.$router.push('/');
					}else{
						this.$message({
	                        type: 'error',
	                        message: "error"
	                    });
					}
				}
			},
		}
    }
</script>

<style>
	.avator
	{
		height: 50px;
		width: 50px;
	}

	.header_container{
		background-color: #EFF2F7;
		height: 60px;
		display: flex;
		justify-content: space-between;
		align-items: center;
		padding-left: 20px;
	}
	.el-dropdown-menu__item{
        text-align: center;
    }
</style>
