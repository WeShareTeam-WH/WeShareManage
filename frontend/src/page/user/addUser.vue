<template>
    <div class="header_container">

		<el-breadcrumb separator="/">
			<el-breadcrumb-item :to="{ path: '/manage' }">首页</el-breadcrumb-item>
			<el-breadcrumb-item v-for="(item, index) in $route.meta" :key="index">{{item}}</el-breadcrumb-item>
		</el-breadcrumb>
		<el-dropdown menu-align='start'>
			<img :src="baseImgPath + 'avator.jpg'" class="avator">
			<el-dropdown-menu slot="dropdown">
				<el-dropdown-item command="home">首页</el-dropdown-item>
				<el-dropdown-item command="singout">退出</el-dropdown-item>
			</el-dropdown-menu>
		</el-dropdown>
    </div>
</template>

<script>
	import {baseImgPath} from '@/config/env'

    export default {
    	data(){
    		return {
    			baseImgPath,
    		}
		}
    }
</script>

<style lang="scss" scoped>
	@import "../../style/mixin";
	.header_container{
		background-color: #EFF2F7;
		height: 60px;
		display: flex;
		justify-content: space-between;
		align-items: center;
		padding-left: 20px;
	}
	.avator{
		width: 36px;
	    height: 36px;
		border-radius: 50%;
		margin-right: 37px;
	}
	.el-dropdown-menu__item{
        text-align: center;
    }
</style>