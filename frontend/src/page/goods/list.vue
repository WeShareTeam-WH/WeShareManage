<template>
    <div class="fillcontain">
        <div class="table_container">
        <!--搜索框-->
        <el-row>
            <el-col :span="3" class="grid">
                <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
            </el-col>
            <el-col :span="1" class="grid">
                <el-button type="success" icon="el-icon-search" size="mini">搜索</el-button>
            </el-col>
            <el-col :span="1" :offset="1" class="grid">
                <el-button @click="refresh()" circle icon="el-icon-refresh" size="mini" ></el-button>
            </el-col>
        </el-row>
        <br>
        <!--表格数据及操作-->
        <el-table :data="goodsList" border style="width: 100%" stripe ref="multipleTable" tooltip-effect="dark" highlight-current-row
    @current-change="handleCurrentChange">
            <!--勾选框-->
            <el-table-column type="selection" width="55">
            </el-table-column>
            <!--索引-->
            <el-table-column type="index" label="序号" :index="indexMethod">
            </el-table-column>
            <el-table-column prop="id" label="商品编号" width="100" sortable>
            </el-table-column>
            <el-table-column prop="addTime" label="日期" width="100" sortable>
            </el-table-column>
            <el-table-column prop="goodsTitle" label="服装名" width="100">
            </el-table-column>
            <el-table-column prop="goodsType.type" label="种类" width="100">
            </el-table-column>
            <el-table-column prop="goodsDescripe" label="描述" width="100">
            </el-table-column>
            <el-table-column prop="goodsAddress" label="厂家">
            </el-table-column>
            <el-table-column label="详情" width="100">
                <template slot-scope="scope">
                    <el-button @click="editGoodsDetail(scope.row.id)" type="primary" icon="el-icon-edit" size="mini">详情</el-button>
                </template>
            </el-table-column>
            <el-table-column label="删除" width="100">
                <template slot-scope="scope">
                    <el-button type="danger" icon="el-icon-delete" size="mini">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <br>
        <el-row>
          <!--新增按钮-->
          <el-col :span="1" class="grid">
              <el-button @click="addGoods()" type="success" icon="el-icon-circle-plus-outline" size="mini" round>新增</el-button>
          </el-col>
          <!--全删按钮-->
          <el-col :span="1" :offset="2" class="grid">
              <el-button type="danger" icon="el-icon-delete" size="mini" round>全删</el-button>
          </el-col>

          <el-col :span="10" :offset="2" >
          <!--分页条-->
          <el-pagination background layout="prev, pager, next" :total="1000">
          </el-pagination>
          </el-col>
        </el-row>
    </div>
    </div>
</template>
<script>
import {baseUrl, baseImgPath} from '@/config/env'
import { getGoodsList } from "@/api/goods";
export default {
  data() {
    return {
      baseUrl,
      baseImgPath,
      //查询输入框数据
      input: "",
      limit: 20,
      count: 0,
      //导航条默认选项
      activeIndex: "1",
      activeIndex2: "1",
      goodsList: []
    }
  },

  created() {
    this.initData();
  },

  computed() {
		this.initData();
  },

  methods: {
    async initData() {
      try {
        await this.getGoodsAllData();
      } catch (err) {
        console.log("获取数据失败", err);
      }
    },

    async refresh()
    {
       await getGoodsAllData();
    },

    editGoodsDetail(id) {   
      this.$router.push({ path: `detail/${id}`});
    },
    async getGoodsAllData() {
      const goodsListData = await getGoodsList();
      this.goodsList = goodsListData.data;    
    },
    addGoods() {
      this.$router.push({ path: "add" });
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    indexMethod(index) {
      return index;
    },
    handleCurrentChange(val) {
      this.currentRow = val;
    }
  }
};
</script>
<style>
    .table_container{
            padding: 20px;
    }

</style>