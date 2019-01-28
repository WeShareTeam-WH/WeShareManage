<template>
  <el-row class="container">
    <el-col :span="4"><router-view name="leftSide"></router-view></el-col>
    <!--头部-->
    <el-col :span="20">
      <router-view name="topSide"></router-view>
      <section class="content-container">
        <div class="grid-content bg-purple-light">
          <el-col :span="24" class="content-wrapper">
            <transition name="fade" mode="out-in">
              <router-view></router-view>
            </transition>
          </el-col>
        </div>
      </section>
    </el-col>
  </el-row>
</template>
<script>
  export default {
    name: 'home',
    data () {
      return {
        loading: false
      }
    }
  }
</script>

<style>
</style>
