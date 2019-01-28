<template>
<div class="fillcontain">
        <head-top></head-top>
        <div class="table_container">
	<el-form ref="form" :model="form" label-width="100px" @submit.prevent="onSubmit">
		<el-form-item label="商品名称">
			<el-input v-model="form.goodsTitle" style="width:600px"></el-input>
		</el-form-item>
		<el-form-item label="商品种类">
			<el-select v-model="form.goodsTypeId" placeholder="请选择商品种类">
				<el-option label="学士服" value="1"></el-option>
				<el-option label="礼服" value="2"></el-option>
				<el-option label="婚纱" value="3"></el-option>
			</el-select>
		</el-form-item>
		<el-form-item label="是否激活">
			<el-switch on-text="" off-text="" v-model="form.active"></el-switch>
		</el-form-item>
		<el-form-item label="商品材质">
			<el-checkbox-group v-model="form.goodsMateriel" style="width:600px">
				<el-checkbox label="纺织纤维" name="type"></el-checkbox>
				<el-checkbox label="植物纤维——棉花、麻" name="type"></el-checkbox>
				<el-checkbox label="动物纤维——蚕丝" name="type"></el-checkbox>
				<el-checkbox label=" 化学纤维-涤纶、锦纶、丙纶，无机纤维" name="type"></el-checkbox>
			</el-checkbox-group>
		</el-form-item>
		<el-form-item label="返还地址">
			<el-select v-model="form.goodsAddress" placeholder="请选择商品返还地址">
				<el-option label="地址一" value="中建康城"></el-option>
				<el-option label="地址一" value="清江山水"></el-option>
				<el-option label="地址三" value="武汉大学代理处"></el-option>
			</el-select>
		</el-form-item>
		<el-form-item label="商品描述">
			<el-input type="textarea" v-model="form.goodsDescripe" style="width:600px"></el-input>
		</el-form-item>
		<el-form-item>
			<el-button @click="createGoods()" type="primary">立即创建</el-button>
			<el-button @click.native.prevent>取消</el-button>
			<el-button @click="uploadImage(1)" type="primary">商品图片上传</el-button>
		</el-form-item>
	</el-form>
        </div>
</div>
</template>

<script>
import headTop from '@/components/headerTop'
import {baseUrl, baseImgPath} from '@/config/env'
import { getGoodsList, addGoods } from "@/api/getData";
	export default {
		data() {
			return {
				baseUrl,
      			baseImgPath,
				form: {
					goodsTypeId : "",
					goodsTitle : "",
					goodsDescripe : "",
					goodsMateriel : "",
					goodsAddress : "",
					addTime : new Date(),
					active : true,
					deleted : false
				}
			}
		},
		 components: {
    		headTop,
  		},
		methods: {
            async initData()
            {

			},
			createGoods()
			{
				this.form.deleted = !this.form.active;
				addGoods(this.form).then((result) => {
					if (result.status == "200")
					{
						this.$message({
							message: '成功',
							type: 'success'
						});
					}
				}).catch((err) => {
					this.$message({
							message: '失败',
							type: 'failed'
						});
				});

			},
			uploadImage(id)
			{
				this.$router.push({ path: 'cropper', goodsId:id});
			},
			onSubmit() {
				console.log('submit!');
			}
		}
	}

</script>

<style>

    .table_container{
        padding: 20px;
    }

</style>
