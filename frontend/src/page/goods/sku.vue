<template>
<div>
    <el-collapse accordion v-for="(sku, index) in skuList" :key="index">
      <el-collapse-item :name="index">
          <template slot="title">
          {{calcTitle(sku)}}
          <i v-if="sku.add" class="header-icon el-icon-circle-plus-outline" style="color:red; font-weight:bold"></i>
          <i v-else-if="sku.delete" class="header-icon el-icon-delete" style="color:red; font-weight:bold"></i> 
          <i v-else-if="sku.edit" class="header-icon el-icon-edit" style="color:red; font-weight:bold"></i>        
      </template>
        <el-row>
          <el-col :span="8">
            <el-form :model="sku" label-width="80px">            
              <el-form-item label="编号">
                <label>{{sku.id}}</label>
              </el-form-item>
              <el-form-item label="激活">
                <el-switch v-model="!sku.cancel" :disabled="!sku.edit"></el-switch>
              </el-form-item>
              <el-form-item label="图片">
                <img v-if="sku.url" :src='sku.url' class="image" :disabled="!sku.edit" @click="showCropper(sku.id, sku.url)">
                <img v-else src="http://temp.im/200x200" @click="showCropper(sku.id, 'http://temp.im/200x200')"/>
              </el-form-item>
              <el-form-item label="时间">
                <label>{{sku.collectionTime}}</label>          
              </el-form-item>                   
            </el-form>
          </el-col>
          <el-col :span="16">
            <el-form v-for="(attribute, attributeIndex) in sku.attributeSkuMappings" v-bind:key="attributeIndex" label-width="80px">           
              <el-form-item :label="attribute.goodsAttributes.attribute">
                <el-input v-model="attribute.value" style="width:300px" :disabled="!sku.edit"></el-input>          
              </el-form-item>              
            </el-form>
            <el-form :model="sku" label-width="80px">            
              <el-form-item label="单价">
                <el-input v-model="sku.unitPrice" style="width:300px" :disabled="!sku.edit"></el-input>
              </el-form-item>
              <el-form-item label="数量">
                <el-input v-model="sku.avaliableNum" style="width:300px" :disabled="!sku.edit"></el-input>
              </el-form-item>                  
            </el-form>
          </el-col>
        </el-row>                        
        <el-button class="btn" @click="editGoodsSku(sku.id)" type="primary" icon="el-icon-edit" size="mini">编辑</el-button>
        <el-button class="btn" @click="deleteGoodsSku(sku.id)" type="danger" icon="el-icon-delete" size="mini">删除</el-button>
      </el-collapse-item>  
  </el-collapse>
  <el-row>		
				<el-col :span="2">
					<el-button @click="addGoodsSku()" type="success" icon="el-icon-circle-plus-outline" size="mini">新增</el-button>
				</el-col>
				<el-col :span="2" :offset="16">
					<el-button @click="cancelGoodsSku()" type="info" icon="el-icon-close" size="mini">取消</el-button>
				</el-col>
				<el-col :span="2" :offset="1">
					<el-button @click="saveGoodsSku()" type="primary" icon="el-icon-success" size="mini">保存</el-button>
				</el-col>		
	</el-row>
  <cropperDialog ref="cropperDialog" v-on:listenToChildEvent="popuBase64Image"></cropperDialog>  
</div>
</template>

<script>
import cropperDialog from "@/components/cropperDialog";
import { baseUrl, baseImgPath } from "@/config/env";
import { getGoodsById} from "@/api/goods";
import { getSKUAttributes} from "@/api/goodsAttributes";
import { addOrUpdateGoodsSku } from "@/api/goodsSku";
import { deepClone } from "@/util/deepClone";
export default {
  data: function() {
    return {
      pageId : "skuPage",
      currentDate: new Date(),
      skuList: [],
      goods: {},
      goodsSkuAttributes:[],
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

  components: {
    cropperDialog
  },

  mounted() {
    console.log("sku mounted.");
  },

  created() {
    console.log("sku created.");
    this.initData();
  },

  methods: {
    async initData()
    {
      let goodsData = await getGoodsById(this.id);
      let skuAttributes = await getSKUAttributes();
      this.skuList = deepClone(goodsData.data.goodsSkus);
      this.goods = deepClone(goodsData.data);
      this.goodsSkuAttributes = deepClone(skuAttributes.data);
    },

    popuBase64Image(cropperData)
		{
			if (cropperData != null)
			{
				if (cropperData.id == this.pageId)
				{
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
          this.skuList.forEach((elemen, index) => {
          if (elemen.id == cropperData.primaryKey)
          {
            this.$set(elemen, 'base64Image', cropperData.base64Image);
            this.$set(elemen, 'url', URL.createObjectURL(blob));
          }
          });
				}	
			}				  
    },
    
    addGoodsSku()
    {
      if (this.skuList.length > 0)
      {
        let newAddGoods = deepClone(this.skuList[this.skuList.length -1]);
        newAddGoods.id = newAddGoods.id + 1;
        newAddGoods.cancel = false;
        newAddGoods.goodsByGoodsId = this.goods.id;
        newAddGoods.url="";
        newAddGoods.base64Image = "";
        newAddGoods.unitPrice=0;
        newAddGoods.avaliableNum=0;      
        newAddGoods.attributeSkuMappings.forEach((element, index) =>{
          element.value = "";
        });
        newAddGoods.add = true;
        newAddGoods.edit = true;
        this.skuList.push(newAddGoods);
      }
      else
      {
        let attributes = [];
        this.goodsSkuAttributes.forEach((item,index)=>{
          let data ={
            goodsAttributes:{
              id:item.id,
              goodsTypeId: item.goodsTypeId,
              attribute: item.attribute,
              addTime: item.addTime,
              deleted: item.deleted
            },
            addTime:new Date(),
            value:"",
            deleted:false
          }
          attributes.push(data);
        });
        let newAddGoods = {
          id : 0,
          cancel: false,
          add:true,
          unitPrice: 0,
          avaliableNum: 0,
          attributeSkuMappings:attributes,
          add: true,
          edit: true
        };
        this.skuList.push(newAddGoods);
      }    
    },

    editGoodsSku(id)
    {
      this.skuList.forEach((elemen, index) => {
        if (elemen.id == id)
        {
          this.$set(elemen, 'edit', true);
        }
      });
    },

    cancelGoodsSku()
    {
      this.skuList = deepClone(this.goods.goodsSkus);
    },

    saveGoodsSku()
    {
        let addOrUpdateSkuList = [];
        this.skuList.forEach((item, index)=>{
          item.unitPrice = parseFloat(item.unitPrice);
          item.avaliableNum = parseInt(item.avaliableNum);
          if (item.add)
          {
            item.id = 0;
            if (item.attributeSkuMappings != null)
            {
              item.attributeSkuMappings.forEach((mapping, index)=>{
                mapping.id = 0;
              });
            }
            addOrUpdateSkuList.push(item);
          }
          else if (item.edit)
          {
            addOrUpdateSkuList.push(item);
          }
          else if (item.delete)
          {
            item.deleted = true;
            addOrUpdateSkuList.push(item);
          }
        });
        this.submitData.goods = this.goods.goods;
        this.submitData.goodsSkus = addOrUpdateSkuList;
        //submitData.goodsSkus = addOrUpdateSkuList;
        addOrUpdateGoodsSku(this.submitData).then((result) => {
					if (result.status == "200")
					{
						this.$message({
							message: '成功',
							type: 'success'
            });
            this.skuList = deepClone(result.data.goodsSkus);
            this.goods = deepClone(result.data);
					}
				}).catch((err) => {
					this.$message({
							message: '失败',
							type: 'failed'
						});
				});
    },

    calcTitle(sku)
    {
      let title = "";
      if (sku != null)
      {
        title = title + "编号" + "(" + sku.id + ")" + "-";
        if (sku.attributeSkuMappings != null)
        {
          sku.attributeSkuMappings.forEach((item,index)=>{
              title = title + item.goodsAttributes.attribute +"("+item.value +")" + "-"
          });
        }
        title = title + "单价/元" + "("+sku.unitPrice +")" + "-";
        title + title + "剩余数量" + "("+sku.avaliableNum +")" + "-";
        title = title.substring(0, title.length-1);     
      }
      return title;
    },

    showCropper(primaryKey, url)
    {
      this.$refs.cropperDialog.showCropperDialog(this.pageId, primaryKey, url);
    }

  }
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
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

.image {
  height: 120px;
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