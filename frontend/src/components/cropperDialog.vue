<template>
<el-dialog ref="cropperDialog" :visible.sync="showCropper" :title="goods.title+'('+goods.IDLabel+':'+goods.goodsID+' '+goods.NameLabel+':'+goods.goodsName+')'" width="90%">
    <div>
        <div>
            <h2><label class="btn" for="uploads">上传图片</label>
            <input type="file" id="uploads" style="position:absolute; clip:rect(0 0 0 0);" accept="image/png, image/jpeg, image/gif, image/jpg" @change="uploadImg($event, 1)"></h2>

            <div class="test-button">					
                <button @click="changeScale(1)" class="btn">+</button>
                <button @click="changeScale(-1)" class="btn">-</button>
                <button @click="rotateLeft" class="btn">&lt;</button>
                <button @click="rotateRight" class="btn">&gt;</button>
                <button @click="aspectRatio(16, 9)" class="btn" title="aspectRatio: 16 / 9">16:9</button>
                <button @click="aspectRatio(2, 3)" class="btn" title="aspectRatio: 2 / 3">2:3</button>
                <button @click="aspectRatio(1, 1)" class="btn" title="aspectRatio: 1 / 1">1:1</button>
                <button @click="aspectRatio(0, 0)" class="btn" title="aspectRatio: Free">Free</button>
                <el-dropdown @command="handleCommand">
                <el-button class="btn">
                    尺寸<i class="el-icon-arrow-down el-icon--right"></i>
                </el-button>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item command="400">400*400</el-dropdown-item>
                    <el-dropdown-item command="200">200*200</el-dropdown-item>
                    <el-dropdown-item command="100">100*100</el-dropdown-item>
                    <el-dropdown-item command="50">50*50</el-dropdown-item>
                    <el-dropdown-item command="20">20*20</el-dropdown-item>
                </el-dropdown-menu>
                </el-dropdown>
                <a @click="down('base64')" class="btn">&dArr;</a>
                <el-button @click="cancelCropper">取 消</el-button>
                <el-button type="primary" v-on:click="toCropper">确 定 裁 剪</el-button>		
            </div>
            <el-row>
            <el-col :span="16">
            <div class="test-cropper test1">
            <vueCropper
                ref="cropper"
                :img="option.img"
                :outputSize="option.size"
                :outputType="option.outputType"
                :info="true"
                :canScale="option.canScale"
                :full="option.full"
                :canMove="option.canMove"
                :canMoveBox="option.canMoveBox"
                :fixedBox="option.fixedBox"
                :original="option.original"
                :autoCrop="option.autoCrop"
                :autoCropWidth="option.autoCropWidth"
                :autoCropHeight="option.autoCropHeight"
                :fixed="option.fixed"
                :fixedNumber="option.fixedNumber"
                @realTime="realTime"
                @imgLoad="imgLoad"
            >
            </vueCropper>
        </div>
            </el-col>
            <el-col :span="8">
              <el-row>
                <label>如需重新裁剪此图片，请先下载，后上传!</label><a :href="url" class="btn">&dArr;</a>
                <div class="show-preview" :style="{'width': urlWidth + 'px', 'height': urlHeight + 'px',  'overflow': 'hidden', 'margin': '5px'}">
                      <img :src="url" style = "width: auto;  height: auto;  max-width: 100%;  max-height: 100%;  "/>
                </div>
              </el-row>
              <el-row>
                <div class="show-preview" :style="{'width': previews.w + 'px', 'height': previews.h + 'px',  'overflow': 'hidden', 'margin': '5px'}">
                  <div :style="previews.div">
                      <img :src="previews.url" :style="previews.img">
                  </div>
                </div>
              </el-row>
            </el-col>
        </el-row>       
        </div> 
    </div>
</el-dialog>
</template>

<script>
import vueCropper from "vue-cropper";
import { baseUrl, baseImgPath } from "@/config/env";
import { uploadImage } from "@/api/goods";
export default {
  name:"cropperDialog",
  data: function() {
    return {
      currentDate: new Date(),
      avatarUrl2: null,
      showCropper: false,
      model: true,
      modelSrc: "",
      crap: true,
      previews: {},
      option: {
        img: "",
        size: 1,
        full: true,
        outputType: "png",
        canMove: false,
        original: false,
        canMoveBox: true,
        canScale: true,
        autoCrop: true,
        autoCropWidth: 200,
        autoCropHeight: 200,
        fixed: true,
        fixedNumber: [1, 1],
        fixedBox: false
      },
      goods:
      {
          IDLabel:"商品号",
          NameLabel:"商品名",
          title:"商品图片上传",
          goodsID: 1,
          goodsName:"毕业照"
      },
      downImg: "#",
      parentComponentId:"",
      parentComponentPrimaryKey:"",
      url:"",
      urlHeight:200,
      urlWidth:200
    };
  },

  methods: {
    //隐藏裁剪框
    cancelCropper() {
      this.showCropper = false;
      this.$refs.cropper.endCrop();
    },
   
    dataTransfer(data)
    {
        this.goods = data;
    },

    showCropperDialog(parentComponentId, parentComponentPrimaryKey, url)
    {
        this.url = url;
        //var newUrl = this.fileOrBlobToDataURL(this.imageToBlob(url));
        this.showCropper = true;
        this.option.img = url;
        this.parentComponentId = parentComponentId;
        this.parentComponentPrimaryKey = parentComponentPrimaryKey;
    },

    fileOrBlobToDataURL(obj, cb){
      var a = new FileReader();
      a.readAsDataURL(obj);
      a.onload = function (e){
        cb(e.target.result);
      };
    },

    imageToBlob(src, cb){
      this.imageToCanvas(src, function (canvas){
        cb(this.dataURLToBlob(this.canvasToDataURL(canvas)));
      });
    },

    imageToCanvas(src, cb){
      var img = new Image();
      img.src = src;
      img.onload = function (){
        var canvas = document.createElement('CANVAS');
        var ctx = canvas.getContext('2d');
        canvas.width = img.width;
        canvas.height = img.height;
        ctx.drawImage(img, 0, 0);
        cb(canvas);
      };
    },

    dataURLToBlob(dataurl){
      var arr = dataurl.split(',');
      var mime = arr[0].match(/:(.*?);/)[1];
      var bstr = atob(arr[1]);
      var n = bstr.length;
      var u8arr = new Uint8Array(n);
      while(n--){
        u8arr[n] = bstr.charCodeAt(n);
      }
      return new Blob([u8arr], {type:mime});
    },

    canvasToDataURL(canvas, format, quality){
	    return canvas.toDataURL(format||'image/jpeg', quality||1.0);
    },

    //父组件调用子组件裁剪方法
    toCropper() {
      this.$refs.cropper.getCropData(data => {
        this.downImg = data;
        this.$emit("listenToChildEvent", {id : this.parentComponentId, primaryKey:this.parentComponentPrimaryKey, base64Image:this.downImg});
      });
      this.showCropper = false;
    },

    convertBase64UrlToBlob(urlData) {
      let bytes = atob(urlData.substring(urlData.indexOf(',') + 1));//去掉url的头，并转换为byte
      //处理异常,将ascii码小于0的转换为大于0
      let ab = new ArrayBuffer(bytes.length);
      let ia = new Uint8Array(ab);
      for (var i = 0; i < bytes.length; i++) {
        ia[i] = bytes.charCodeAt(i);
      }
      let formData = new FormData();
      let blob = new Blob([ab], { type: 'image/png' });
      formData.append('file', blob, 'image.png');
      formData.enctype='multipart/form-data;';
      return formData;
    },

    editImage(url) {
      this.showCropper = true;
      this.option.img = url;
    },

    changeScale(num) {
      num = num || 1;
      this.$refs.cropper.changeScale(num);
    },

    rotateLeft() {
      this.$refs.cropper.rotateLeft();
    },

    rotateRight() {
      this.$refs.cropper.rotateRight();
    },

    aspectRatio(x, y) {
      if (x != 0 && y != 0) {
        this.option.fixedNumber[0] = x;
        this.option.fixedNumber[1] = y;
        this.option.fixed = true;
      } else {
        this.option.fixed = false;
      }
      this.$refs.cropper.goAutoCrop();
    },

    handleCommand(x) {
      this.option.fixedNumber[0] = 1;
      this.option.fixedNumber[1] = 1;
      this.$refs.cropper.changeCrop(x, x);
    },

    // 实时预览函数
    realTime(data) {
      this.previews = data;
    },

    down(type) {
      // event.preventDefault()
      var aLink = document.createElement("a");
      aLink.download = "demo";
      // 输出
      if (type === "blob") {
        this.$refs.cropper.getCropBlob(data => {
          this.downImg = window.URL.createObjectURL(data);
          aLink.href = window.URL.createObjectURL(data);
          aLink.click();
        });
      } else {
        this.$refs.cropper.getCropData(data => {
          this.downImg = data;
          aLink.href = data;
          aLink.click();
        });
      }
    },

    uploadImg(e, num) {
      //上传图片
      // this.option.img
      var file = e.target.files[0];
      if (!/\.(gif|jpg|jpeg|png|bmp|GIF|JPG|PNG)$/.test(e.target.value)) {
        alert("图片类型必须是.gif,jpeg,jpg,png,bmp中的一种");
        return false;
      }
      var reader = new FileReader();
      reader.onload = e => {
        let data;
        if (typeof e.target.result === "object") {
          // 把Array Buffer转化为blob 如果是base64不需要
          data = window.URL.createObjectURL(new Blob([e.target.result]));
        } else {
          data = e.target.result;
        }
        this.option.img = data;
        this.url = data;
      };
      // 转化为base64
      // reader.readAsDataURL(file)
      // 转化为blob
      reader.readAsArrayBuffer(file);
    },

    imgLoad(msg) {
      console.log(msg);
    }
  },

  components: {
    vueCropper
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

.el-dialog {
  margin-top: 2px !important;
}

.el-dialog__title
{
    font-size: 14px;
    color: rgb(48, 2, 252);
}

.el-dialog__header {
  padding: 5px 20px !important;
}

.el-dialog__body {
  padding: 0px 20px 20px 20px !important;
}

.content {
  margin: auto;
  max-width: 1200px;
  margin-bottom: 100px;
}

.test-button {
  display: flex;
  flex-wrap: wrap;
  margin-bottom: 5px;
}

.btn {
  display: inline-block;
  line-height: 1;
  white-space: nowrap;
  cursor: pointer;
  background: #fff;
  border: 1px solid #c0ccda;
  color: #1f2d3d;
  text-align: center;
  box-sizing: border-box;
  outline: none;
  margin: 20px 10px 0px 0px;
  padding: 9px 15px;
  font-size: 14px;
  border-radius: 4px;
  color: #fff;
  background-color: #50bfff;
  border-color: #50bfff;
  transition: all 0.2s ease;
  text-decoration: none;
  user-select: none;
}

.test-cropper {
  height: 500px;
}
</style>