<template>
<div class="fillcontain">
    <div class="table_container">
      <lebel>{{goodsId}}</lebel>
      <el-tabs type="border-card">
      <el-tab-pane label="商品基本信息">
        <basicInfoView :id="goodsId" ref="basicInfoView"></basicInfoView>
      </el-tab-pane>
      <el-tab-pane label="商品SKU">
          <skuView :id="goodsId" ref="skuView"></skuView>
      </el-tab-pane>
      <el-tab-pane label="商品详情(描述)">
          <descriptionView :id="goodsId" ref="descriptionView"></descriptionView>
      </el-tab-pane>
      <el-tab-pane label="商品描述预览">
          <preView :id="goodsId" ref="preView"></preView>
      </el-tab-pane>
      </el-tabs>
    </div>
</div>
</template>

<script>
import basicInfoView from "./basicInfo";
import skuView from "./sku";
import descriptionView from "./description";
import preView from "./preview";
import { baseUrl, baseImgPath } from "@/config/env";
import { getGoodsList } from "@/api/goods";
export default {
  data: function() {
    return {
      currentDate: new Date(),
      goods: {},
      goodsId:this.$route.params.id
    }
  },
  watch: {

  },
  created() {
    console.log("detail created.");
    this.goodsId = this.$route.params.id;
  },

  mounted()
  {
    console.log("detail mounted.");
  },

  methods: {
    getGoods(a)
    {
      console.log(a);
    }
  },

  components: {
    basicInfoView,
    skuView,
    descriptionView,
    preView
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
  height: 200px;
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