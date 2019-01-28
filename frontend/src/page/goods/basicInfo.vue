<template>
<div>
    <el-row class="wrap">
    <el-col :span="24" class="wrap-breadcrumb">
      <el-col :span="24" class="wrap-main">
      <el-form ref="form" :model="goods" label-width="100px" @submit.prevent="onSubmit">
			<el-form-item label="商品编号">
				<label style="width:600px" :disabled="readonly">{{goods.id}}</label>
			</el-form-item>
			<el-form-item label="商品名称">
				<el-input v-model="goods.goodsTitle" style="width:600px" :disabled="readonly"></el-input>
			</el-form-item>
			<el-form-item label="商品类型">           
				<el-select v-model="goods.goodsTypeId" placeholder="请选择商品种类" :disabled="readonly">
					<el-option v-for="(item, index) in goodsType" :key="index" :label="item.type" :value="item.id"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="是否激活">
				<el-switch on-text="" off-text="" v-model="!goods.active" :disabled="readonly"></el-switch>
			</el-form-item>
			<el-form-item label="商品标签">
				<el-select
				v-model="goodsLabelIds"
				multiple
				filterable
				allow-create
				default-first-option
				placeholder="请选择标签">
				<el-option
					v-for="(item, index) in goodsLabelOptions"
					:key="index"
					:label="item.label"
					:value="item.id" :disabled="readonly">
    </el-option>
  	</el-select>
			</el-form-item>
			<el-form-item label="返还地址">
				<el-select v-model="goods.goodsAddress" placeholder="请选择商品返还地址" :disabled="readonly">
					<el-option label="中建康城" value="中建康城"></el-option>
					<el-option label="清江山水" value="清江山水"></el-option>
					<el-option label="武汉大学代理处" value="武汉大学代理处"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="商品描述">
				<el-input type="textarea" v-model="goods.goodsDescripe" style="width:600px" :disabled="readonly"></el-input>
			</el-form-item>
      <el-form-item label="商品图">
				<img v-if="goods.goodsImageUrl" :src="goods.goodsImageUrl" class="avatar" @click="showCropper(goods.goodsImageUrl)"/>
				<img v-else src="http://temp.im/200x200" @click="showCropper('http://temp.im/200x200')"/>
			</el-form-item>
			<el-row>		
				<el-col :span="2">
					<el-button @click="editGoods()" type="primary" icon="el-icon-edit" size="mini" :disabled="!readonly">编辑</el-button>
				</el-col>
				<el-col :span="2" :offset="16">
					<el-button @click="cancelGoods()" type="info" icon="el-icon-close" size="mini" :disabled="readonly">取消</el-button>
				</el-col>
				<el-col :span="2" :offset="1">
					<el-button @click="saveGoods()" type="primary" icon="el-icon-success" size="mini" :disabled="readonly">保存</el-button>
				</el-col>		
			</el-row>
		</el-form>
      </el-col>
    </el-col>
  </el-row>
	<cropperDialog ref="cropperDialog" v-on:listenToChildEvent="popuBase64Image"></cropperDialog>  
</div>
</template>

<script>
import cropperDialog from "@/components/cropperDialog";
import { baseUrl, baseImgPath } from "@/config/env";
import { getGoodsById, editGoodsBasic } from "@/api/goods";
import { getAllGoodsType } from "@/api/goodsType";
import { getAllGoodsLabels } from "@/api/goodsLabel";
import { deepClone } from "@/util/deepClone";
import { formatDate } from "@/util/date";
export default {
  data: function() {
    return {
			pageId : "basicInfoPage",
			originalGoods: {},
			currentDate: new Date(),
			readonly:true,
			goodsType:{},
			goods:{},
			goodsLabels:[],
			originalGoodsLabelIds:[],
			goodsLabelIds:[],
			goodsLabelOptions:[],
			submitData:{
					goods : {},
					goodsLabels:[],
					goodsSkus:[],
					goodsDescriptions:[]
				}
    };
  },

  props: {
		id: {
			required: true,
			type:Number,
			default:0
		}
	},

	computed() {
		this.initData();
  },

  created() {
      this.initData();
  },

  methods: {
		popuBase64Image(cropperData)
		{
			if (cropperData != null)
			{
				if (cropperData.id == this.pageId)
				{
					this.goods.base64Image = cropperData.base64Image;
					let urlData = cropperData.base64Image;
					let reader = new FileReader();
					let bytes = atob(urlData.substring(urlData.indexOf(',') + 1));//去掉url的头，并转换为byte
					//处理异常,将ascii码小于0的转换为大于0
					let ab = new ArrayBuffer(bytes.length);
					let ia = new Uint8Array(ab);
					for (var i = 0; i < bytes.length; i++) {
						ia[i] = bytes.charCodeAt(i);
					}
					let blob = new Blob([ab], { type: 'image/jpeg' });
					this.goods.goodsImageUrl = URL.createObjectURL(blob);
				}	
			}				  
		},

    async initData()
    {
			let goodsData = await getGoodsById(this.id);
			this.originalGoods = deepClone(goodsData.data.goods);
			this.goods = deepClone(goodsData.data.goods);
			this.goodsLabels = deepClone(goodsData.data.goodsLabels);
			let labeids = [];
			this.goodsLabels.forEach((element, index) => {
				labeids.push(element.id);
			});
			this.goodsLabelIds = labeids;
			this.originalGoodsLabelIds = deepClone(labeids);

			let goodsTypeData = await getAllGoodsType();
			this.goodsType =  deepClone(goodsTypeData.data);
			let goodsLabelData = await getAllGoodsLabels();
			this.goodsLabelOptions =  deepClone(goodsLabelData.data);
    },
		
		editGoods()
		{
			this.readonly = false;
		},

		saveGoods()
		{
			this.readonly = true;
			this.goods.addTime = formatDate(new Date(), 'yyyy-MM-dd hh:mm:ss');
			this.submitData.goods = this.goods;
			this.submitData.goodsLabels = this.goodsLabels;	
			editGoodsBasic(this.submitData).then((result) => {
					if (result.status == "200")
					{
						this.$message({
							message: '成功',
							type: 'success'
						});
						this.goods.goodsImageUrl = result.data.goods.goodsImageUrl;
					}
				}).catch((err) => {
					this.$message({
							message: '失败',
							type: 'failed'
						});
				});
		},

		cancelGoods()
		{
			this.goods = deepClone(this.originalGoods);
			this.goodsLabelIds = deepClone(this.originalGoodsLabelIds);
			this.readonly = true;
		},
		
    showBaiscInfo(goods)
    {
        this.goods = goods;
    },

    showCropper(url)
    {
			if (this.readonly)
			{
				return;
			}
      this.$refs.cropperDialog.showCropperDialog(this.pageId, "1", url);
    }
  },

   components: {
    cropperDialog
  },

  mounted() {
    
  }
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}

.wrap-breadcrumb{
min-height: 600px;
}

.time {
  font-size: 13px;
  color: #999;
}
.span-size {
  display: inline;
  color: #07fa95;
}

.span-desc {
  display: inline-block;
  color: #06192491;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.el-card {
  text-align: center;
}

.avatar
{
	  width: 200px;
    height: 200px;
    display: block;
}

.clearfix:before,

.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}
</style>
