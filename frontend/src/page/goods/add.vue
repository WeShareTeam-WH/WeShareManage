<template>
<el-row class="wrap">
    <el-col :span="24" class="wrap-breadcrumb">
      <el-col :span="24" class="wrap-main">
        <el-form ref="form" :model="goodsBasic.goods" label-width="100px" @submit.prevent="onSubmit">
			<el-form-item label="商品名称">
				<el-input v-model="goodsBasic.goods.goodsTitle" style="width:600px"></el-input>
			</el-form-item>
				<el-form-item label="商品类型">           
				<el-select v-model="goodsBasic.goods.goodsTypeId" placeholder="请选择商品种类">
					<el-option v-for="(item, index) in goodsType" :key="index" :label="item.type" :value="item.id"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="是否激活">
				<el-switch on-text="" off-text="" v-model="!goodsBasic.goods.deleted"></el-switch>
			</el-form-item>
			<el-form-item label="商品标签">
				<el-select
					v-model="goodsLabelsIds"
					multiple
					filterable
					allow-create
					default-first-option
					placeholder="请选择标签">
					<el-option
						v-for="(item, index) in goodsLabelOptions"
						:key="index"
						:label="item.label"
						:value="item.id">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="返还地址">
				<el-select v-model="goodsBasic.goods.goodsAddress" placeholder="请选择商品返还地址">
					<el-option label="地址一" value="中建康城"></el-option>
					<el-option label="地址一" value="清江山水"></el-option>
					<el-option label="地址三" value="武汉大学代理处"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="商品描述">
				<el-input type="textarea" v-model="goodsBasic.goodsDescripe" style="width:600px"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button @click="createGoods()" type="primary" icon="el-icon-success" size="mini">立即创建</el-button>
				<el-button @click.native.prevent type="info" icon="el-icon-close" size="mini">取消</el-button>
				<el-button @click="uploadImage(1)" type="primary" icon="el-icon-upload" size="mini">商品图片上传</el-button>
			</el-form-item>
		</el-form>
      </el-col>
    </el-col>
  </el-row>
</template>

<script>
import headTop from '@/components/headerTop'
import { baseUrl, baseImgPath } from '@/config/env'
import { addGoodsBasic } from "@/api/goods";
import { getAllGoodsType } from "@/api/goodsType";
import { getAllGoodsLabels } from "@/api/goodsLabel";
import { formatDate } from "@/util/date"
	export default {
		data() {
			return {
				goodsBasic:{
					goods:
					{
						goodsTypeId:1,
						goodsTitle : "",
						goodsDescripe : "",
						goodsMateriel : "",
						goodsAddress : "",
						addTime : formatDate(new Date(), 'yyyy-MM-dd hh:mm:ss'),
						deleted : false,
						goodsImageUrl:""
					},
					goodsLabels:[]					
				},
				goodsType:{},
				goodsLabelsIds:[],			
				goodsLabelOptions:[]
			}
		},
		created() {
			this.initData();
		},
		methods: {
            async initData()
            {
				let goodsTypeData = await getAllGoodsType();
				this.goodsType = goodsTypeData.data;
				let goodsLabelData = await getAllGoodsLabels();
				this.goodsLabelOptions = goodsLabelData.data;
			},

			createGoods()
			{
				let addedGoodLabels = [];
				this.goodsLabelsIds.forEach((vulue,index) => {
					this.goodsLabelOptions.forEach((option, i) => {
						if (vulue == option.id)
						{
							addedGoodLabels.push(option);
						}
					})
				});
				this.goodsBasic.goodsLabels = addedGoodLabels;
				addGoodsBasic(this.goodsBasic).then((result) => {
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
