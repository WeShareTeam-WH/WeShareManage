<template>
    <el-row>
            <el-col :span="8" v-for="(item, index) in itemList" v-bind:key="index">
              <el-card :body-style="{ padding: '0px'}" class="el-card">
                <img :src='item.img' class="image">         
                <div style="padding: 14px;">
                  <span class="span-size">{{item.size}}</span>            
                  <span class="span-desc">{{item.desc}}</span>
                  <div class="bottom clearfix">
                    <time class="time">{{ currentDate }}</time>
                    <el-button type="text" @click="editImage(item.img)">编辑</el-button>
                    <el-button type="text" @click="deleteImage(item.img)">删除</el-button>
                  </div>
                </div>
              </el-card>
            </el-col>
            <el-button class="btn" @click="showCropper()">新增</el-button>
          </el-row>  
</template>

<script>
import cropperDialog from "@/components/cropperDialog";
import { baseUrl, baseImgPath } from "@/config/env";
import { getGoodsList } from "@/api/goods";
export default {
  data: function() {
    return {
      currentDate: new Date(),
      itemList: [
        // {
        // 	img: 'https://fengyuanchen.github.io/cropper/images/picture.jpg'
        // },
        {
          img: "http://ofyaji162.bkt.clouddn.com/touxiang.jpg",
          size: "200*200",
          desc: "微信头像"
        },
        {
          img:
            "https://o90cnn3g2.qnssl.com/0C3ABE8D05322EAC3120DDB11F9D1F72.png",
          size: "200*300",
          desc: "微信服装首页"
        },
        {
          img: "http://ofyaji162.bkt.clouddn.com/bg1.jpg",
          size: "50*50",
          desc: "微信购物车页面"
        },
        {
          img: "http://ofyaji162.bkt.clouddn.com/bg2.jpg",
          size: "200*400",
          desc: "微信购物车页面"
        },
        {
          img: "http://ofyaji162.bkt.clouddn.com/can.jpg",
          size: "200*200",
          desc: "微信购物车页面"
        },
        {
          img: "http://ofyaji162.bkt.clouddn.com/nightcat.jpg",
          size: "200*200",
          desc: "微信购物车页面"
        }
      ],    
    };
  },

  methods: {
    showCropper()
    {
      this.$refs.cropperDialog.showCropperDialog();
    },

    editImage(url) {
      this.$refs.cropperDialog.showCropperDialog();
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