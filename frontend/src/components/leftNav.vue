<template>
  <!--左侧导航-->
  <leftSide :class="{showSidebar:!collapsed}">
    <!--展开折叠开关-->
    <div class="menu-toggle" @click.prevent="collapse">
      <i class="iconfont icon-outdent" v-show="!collapsed" title="收起"></i>
      <i class="iconfont icon-indent" v-show="collapsed" title="展开"></i>
    </div>
    <!--导航菜单-->
    <el-menu router :collapse="collapsed"  background-color="#545c64"
  text-color="#fff" class="left-nav">
      <template v-for="issue in $router.options.routes">
        <template v-if="issue.name === $store.state.leftNavState">
          <template v-for="(item,index) in issue.children">
            <el-submenu v-if="!item.leaf" :index="index" v-show="item.menuShow" v-bind:key="index">
              <template slot="title"><i :class="item.iconCls"></i><span slot="title">{{item.name}}</span></template>
              <el-menu-item v-for="term in item.children" :key="term.path" :index="term.path" v-if="term.menuShow"
                            :class="$route.path==term.path?'is-active':''">
                <i :class="term.iconCls"></i><span slot="title">{{term.name}}</span>
              </el-menu-item>
            </el-submenu>
            <el-menu-item v-else-if="item.leaf" :index="item.path" v-bind:key="index"
                          :class="$route.path==item.path?'is-active':''" v-show="item.menuShow">
              <i :class="item.iconCls"></i><span slot="title">{{item.name}}</span>
            </el-menu-item>
          </template>
        </template>
      </template>
    </el-menu>
  </leftSide>
</template>
<script>
  export default {
    name: 'leftNav',
    data () {
      return {
        loading: false,
        collapsed: this.$store.state.collapsed
      }
    },
    methods: {
      //折叠导航栏
      collapse: function () {
        this.collapsed = !this.collapsed;
        this.$store.state.collapsed = this.collapsed;
      },
      jumpTo(url){
        this.$router.push(url); //用go刷新
      }
    },
    watch: {
      '$route': function(to, from){ // 路由改变时执行
        //console.info("to.path:" + to.path);
      }
    }
  }
</script>

<style>
.left-nav
{
  height: 800px; 
  min-height: 100%; 
  background-color: #324057;
}
</style>
