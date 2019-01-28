<template>
    <div class="fillcontain">
        <head-top></head-top>
        <div class="table_container">
        <!--搜索框-->
        <el-row>
            <el-col :span="3" class="grid">
                <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
            </el-col>
            <el-col :span="1" class="grid">
                <el-button type="success" icon="el-icon-search" size="mini">搜索</el-button>
            </el-col>
        </el-row>
        <br>
        <!--表格数据及操作-->
        <el-table :data="tableData" border style="width: 100%" stripe ref="multipleTable" tooltip-effect="dark">
            <!--勾选框-->
            <el-table-column type="selection" width="55">
            </el-table-column>
            <!--索引-->
            <el-table-column type="index" :index="indexMethod">
            </el-table-column>
            <el-table-column prop="addTime" label="日期" width="180" sortable>
            </el-table-column>
            <el-table-column prop="goodsTitle" label="服装名" width="180">
            </el-table-column>
            <el-table-column prop="goodsTypeId" label="种类" width="180">
            </el-table-column>
            <el-table-column prop="goodsDescripe" label="描述" width="180">
            </el-table-column>
            <el-table-column prop="goodsMateriel" label="材料" width="180">
            </el-table-column>
            <el-table-column prop="goodsAddress" label="地址">
            </el-table-column>
            <el-table-column prop="deleted" label="可用" width="180">
            </el-table-column>
            <el-table-column label="编辑" width="100">
                <template slot-scope="scope">
                    <el-button type="primary" icon="el-icon-edit" size="mini">编辑</el-button>
                </template>
            </el-table-column>
            <el-table-column label="删除" width="100">
                <template slot-scope="scope">
                    <el-button type="danger" icon="el-icon-delete" size="mini">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <br>
        <!--新增按钮-->
        <el-col :span="1" class="grid">
            <el-button @click="addGoods()" type="success" icon="el-icon-circle-plus-outline" size="mini" round>新增</el-button>
        </el-col>
        <!--全删按钮-->
        <el-col :span="1" :offset="1" class="grid">
            <el-button type="danger" icon="el-icon-delete" size="mini" round>全删</el-button>
        </el-col>

        <el-col :span="10" :offset="1" >
        <!--分页条-->
        <el-pagination background layout="prev, pager, next" :total="1000">
        </el-pagination>
        </el-col>
    </div>
    </div>
</template>
<script>
import headTop from '@/components/headerTop'
import {baseUrl, baseImgPath} from '@/config/env'
import { getGoodsList } from "@/api/getData";
export default {
  data() {
    return {
      baseUrl,
      baseImgPath,
      //表格数据
      tableData: [],
      //查询输入框数据
      input: "",
      limit: 20,
      count: 0,
      //导航条默认选项
      activeIndex: "1",
      activeIndex2: "1"
    }
  },
  created() {
    this.initData();
  },
  components: {
    headTop,
  },
  methods: {
    async initData() {
      try {
        await this.getGoodsAllData();
      } catch (err) {
        console.log("获取数据失败", err);
      }
    },
    async getGoodsAllData() {
      const goodsList = await getGoodsList();
      this.tableData = [];
      goodsList.data.forEach(element => {
        const rawData = {};
        rawData.id = element.id;
        rawData.goodsTypeId = element.goodsTypeId;
        rawData.goodsTitle = element.goodsTitle;
        rawData.goodsDescripe = element.goodsDescripe;
        rawData.goodsMateriel = element.goodsMateriel;
        rawData.goodsAddress = element.goodsAddress;
        rawData.addTime = element.addTime;
        rawData.deleted = element.deleted;
        this.tableData.push(rawData);
      });
    },
    addGoods() {
      this.$router.push({ path: "add" });
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    indexMethod(index) {
      return index;
    }
  }
};
</script>
<style>
    .table_container{
            padding: 20px;
    }

</style>